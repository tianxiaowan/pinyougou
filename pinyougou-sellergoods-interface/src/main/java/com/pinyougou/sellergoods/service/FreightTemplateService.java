package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.FreightTemplate;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface FreightTemplateService {

	/**
	 * 返回FreightTemplate全部列表
	 * @return
	 */
	public List<FreightTemplate> getAll();
	
	
	/***
     * 分页返回<FreightTemplate>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<FreightTemplate> getAll(FreightTemplate freightTemplate, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(FreightTemplate freightTemplate);
	
	
	/**
	 * 修改
	 */
	int updateFreightTemplateById(FreightTemplate freightTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	FreightTemplate getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
