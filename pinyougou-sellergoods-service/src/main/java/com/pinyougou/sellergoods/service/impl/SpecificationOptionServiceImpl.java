package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.SpecificationOptionMapper;
import com.pinyougou.model.SpecificationOption;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.SpecificationOptionService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SpecificationOption> getAll() {
		return specificationOptionMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<SpecificationOption> getAll(SpecificationOption specificationOption,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<SpecificationOption> all = specificationOptionMapper.select(specificationOption);
        PageInfo<SpecificationOption> pageInfo = new PageInfo<SpecificationOption>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(SpecificationOption specificationOption) {
		return specificationOptionMapper.insertSelective(specificationOption);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateSpecificationOptionById(SpecificationOption specificationOption){
		return specificationOptionMapper.updateByPrimaryKeySelective(specificationOption);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SpecificationOption getOneById(Long id){
		return specificationOptionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(SpecificationOption.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_specificationOption where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return specificationOptionMapper.deleteByExample(example);	
	}

}
