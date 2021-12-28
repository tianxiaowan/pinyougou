package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import java.util.Map;

import com.pinyougou.mapper.SpecificationOptionMapper;
import com.pinyougou.model.SpecificationOption;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.SpecificationMapper;
import com.pinyougou.model.Specification;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.SpecificationService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationMapper specificationMapper;

	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<Specification> getAll() {
		return specificationMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Specification> getAll(Specification specification,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		Example example = new Example(Specification.class);
		Example.Criteria criteria = example.createCriteria();
		if(specification != null){
			if (StringUtils.isNotBlank(specification.getSpecName())){
				criteria.andLike("specName","%"+specification.getSpecName()+"%");
			}
		}

		List<Specification> specifications = specificationMapper.selectByExample(example);

//		List<Specification> all = specificationMapper.select(specification);

        PageInfo<Specification> pageInfo = new PageInfo<Specification>(specifications);
//		System.out.println(pageInfo);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Specification specification) {
//		System.out.println(specification);
		int count =  specificationMapper.insertSelective(specification);
		List<SpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
//		System.out.println(specificationOptionList!=null);
//		System.out.println(specificationOptionList);
//		System.out.println(specificationOptionList.size());
		if(specificationOptionList != null && specificationOptionList.size()>0){
			for (SpecificationOption so:specificationOptionList) {
				so.setSpecId(specification.getId());
				specificationOptionMapper.insertSelective(so);
			}
		}
		return count;
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateSpecificationById(Specification specification){
		int i = specificationMapper.updateByPrimaryKeySelective(specification);
		if(i>0){
			List<SpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
			SpecificationOption specificationOption = new SpecificationOption();
			specificationOption.setSpecId(specification.getId());
			specificationOptionMapper.delete(specificationOption);

			for (SpecificationOption s:specificationOptionList
				 ) {

				s.setSpecId(specification.getId());
				int i1 = specificationOptionMapper.insertSelective(s);
			}

		}

		return specificationMapper.updateByPrimaryKeySelective(specification);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification getOneById(Long id){
		Specification specification = specificationMapper.selectByPrimaryKey(id);
		System.out.println(specification);
		if(specification!=null){
			SpecificationOption specificationOption = new SpecificationOption();
			specificationOption.setSpecId(specification.getId());
			List<SpecificationOption> select = specificationOptionMapper.select(specificationOption);
			specification.setSpecificationOptionList(select);
		}
		System.out.println(specification.getSpecificationOptionList()==null);
		return specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {

		//创建Example，来构建根据ID删除数据
        Example example = new Example(Specification.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_specification where id in(1,2,5,6)
        criteria.andIn("id",ids);
		int i = specificationMapper.deleteByExample(example);

		Example example1 = new Example(SpecificationOption.class);
		Example.Criteria criteria1 = example1.createCriteria();
		criteria1.andIn("specId",ids);
		int i1 = specificationOptionMapper.deleteByExample(example1);
		return i1+i;
	}

	@Override
	public List<Map<String, Object>> selectOptionList() {
		return specificationMapper.selectOptionList();
	}

}
