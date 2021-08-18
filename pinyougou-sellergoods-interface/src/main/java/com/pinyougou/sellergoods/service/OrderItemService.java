package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.OrderItem;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface OrderItemService {

	/**
	 * 返回OrderItem全部列表
	 * @return
	 */
	public List<OrderItem> getAll();
	
	
	/***
     * 分页返回<OrderItem>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<OrderItem> getAll(OrderItem orderItem, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(OrderItem orderItem);
	
	
	/**
	 * 修改
	 */
	int updateOrderItemById(OrderItem orderItem);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	OrderItem getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
