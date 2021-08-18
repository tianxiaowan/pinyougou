package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.SeckillGoods;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SeckillGoodsService {

	/**
	 * 返回SeckillGoods全部列表
	 * @return
	 */
	public List<SeckillGoods> getAll();
	
	
	/***
     * 分页返回<SeckillGoods>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<SeckillGoods> getAll(SeckillGoods seckillGoods, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(SeckillGoods seckillGoods);
	
	
	/**
	 * 修改
	 */
	int updateSeckillGoodsById(SeckillGoods seckillGoods);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SeckillGoods getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
