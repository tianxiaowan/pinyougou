package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Item;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ItemService {

	/**
	 * 返回Item全部列表
	 * @return
	 */
	public List<Item> getAll();
	
	
	/***
     * 分页返回<Item>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Item> getAll(Item item, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Item item);
	
	
	/**
	 * 修改
	 */
	int updateItemById(Item item);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Item getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
