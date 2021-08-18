package com.pinyougou.sellergoods.service.impl;
import java.util.List;
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

		List<Specification> all = specificationMapper.select(specification);
        PageInfo<Specification> pageInfo = new PageInfo<Specification>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Specification specification) {
		return specificationMapper.insertSelective(specification);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateSpecificationById(Specification specification){
		return specificationMapper.updateByPrimaryKeySelective(specification);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification getOneById(Long id){
		return specificationMapper.selectByPrimaryKey(id);
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
        return specificationMapper.deleteByExample(example);	
	}

}
