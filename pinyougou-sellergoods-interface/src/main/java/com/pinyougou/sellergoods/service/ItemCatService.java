package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.ItemCat;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ItemCatService {

	/**
	 * 返回ItemCat全部列表
	 * @return
	 */
	public List<ItemCat> getAll();
	
	
	/***
     * 分页返回<ItemCat>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<ItemCat> getAll(ItemCat itemCat, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(ItemCat itemCat);
	
	
	/**
	 * 修改
	 */
	int updateItemCatById(ItemCat itemCat);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	ItemCat getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
