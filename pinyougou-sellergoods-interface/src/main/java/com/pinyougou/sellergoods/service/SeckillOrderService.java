package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.SeckillOrder;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SeckillOrderService {

	/**
	 * 返回SeckillOrder全部列表
	 * @return
	 */
	public List<SeckillOrder> getAll();
	
	
	/***
     * 分页返回<SeckillOrder>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<SeckillOrder> getAll(SeckillOrder seckillOrder, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(SeckillOrder seckillOrder);
	
	
	/**
	 * 修改
	 */
	int updateSeckillOrderById(SeckillOrder seckillOrder);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SeckillOrder getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
