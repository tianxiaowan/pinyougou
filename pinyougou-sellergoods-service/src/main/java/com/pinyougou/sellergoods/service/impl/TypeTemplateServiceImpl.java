package com.pinyougou.sellergoods.service.impl;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TypeTemplateMapper;
import com.pinyougou.model.TypeTemplate;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.TypeTemplateService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired
	private TypeTemplateMapper typeTemplateMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TypeTemplate> getAll() {
		return typeTemplateMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<TypeTemplate> getAll(TypeTemplate typeTemplate,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

//		List<TypeTemplate> all = typeTemplateMapper.select(typeTemplate);
		Example example = new Example(TypeTemplate.class);
		Example.Criteria criteria = example.createCriteria();

		if (typeTemplate!=null && StringUtils.isNotBlank(typeTemplate.getName())){
			System.out.println(1);
			criteria.andLike("name","%"+typeTemplate.getName()+"%");
		}

		List<TypeTemplate> typeTemplates = typeTemplateMapper.selectByExample(example);

		PageInfo<TypeTemplate> pageInfo = new PageInfo<TypeTemplate>(typeTemplates);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(TypeTemplate typeTemplate) {
		return typeTemplateMapper.insertSelective(typeTemplate);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateTypeTemplateById(TypeTemplate typeTemplate){
		return typeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TypeTemplate getOneById(Long id){
		return typeTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(TypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_typeTemplate where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return typeTemplateMapper.deleteByExample(example);	
	}

}
