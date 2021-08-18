package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Cities;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CitiesService {

	/**
	 * 返回Cities全部列表
	 * @return
	 */
	public List<Cities> getAll();
	
	
	/***
     * 分页返回<Cities>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Cities> getAll(Cities cities, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Cities cities);
	
	
	/**
	 * 修改
	 */
	int updateCitiesById(Cities cities);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Cities getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
