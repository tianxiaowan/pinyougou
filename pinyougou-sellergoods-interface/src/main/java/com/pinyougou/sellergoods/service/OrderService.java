package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Order;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface OrderService {

	/**
	 * 返回Order全部列表
	 * @return
	 */
	public List<Order> getAll();
	
	
	/***
     * 分页返回<Order>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Order> getAll(Order order, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Order order);
	
	
	/**
	 * 修改
	 */
	int updateOrderById(Order order);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Order getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
