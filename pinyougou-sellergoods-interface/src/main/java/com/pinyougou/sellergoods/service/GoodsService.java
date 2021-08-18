package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Goods;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * 返回Goods全部列表
	 * @return
	 */
	public List<Goods> getAll();
	
	
	/***
     * 分页返回<Goods>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Goods> getAll(Goods goods, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Goods goods);
	
	
	/**
	 * 修改
	 */
	int updateGoodsById(Goods goods);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Goods getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
