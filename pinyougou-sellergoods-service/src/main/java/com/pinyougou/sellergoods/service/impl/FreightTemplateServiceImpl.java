package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.FreightTemplateMapper;
import com.pinyougou.model.FreightTemplate;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.FreightTemplateService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FreightTemplateServiceImpl implements FreightTemplateService {

	@Autowired
	private FreightTemplateMapper freightTemplateMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<FreightTemplate> getAll() {
		return freightTemplateMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<FreightTemplate> getAll(FreightTemplate freightTemplate,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<FreightTemplate> all = freightTemplateMapper.select(freightTemplate);
        PageInfo<FreightTemplate> pageInfo = new PageInfo<FreightTemplate>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(FreightTemplate freightTemplate) {
		return freightTemplateMapper.insertSelective(freightTemplate);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateFreightTemplateById(FreightTemplate freightTemplate){
		return freightTemplateMapper.updateByPrimaryKeySelective(freightTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public FreightTemplate getOneById(Long id){
		return freightTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(FreightTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_freightTemplate where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return freightTemplateMapper.deleteByExample(example);	
	}

}
