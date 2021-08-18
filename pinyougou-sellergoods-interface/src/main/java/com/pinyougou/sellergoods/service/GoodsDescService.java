package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.GoodsDesc;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsDescService {

	/**
	 * 返回GoodsDesc全部列表
	 * @return
	 */
	public List<GoodsDesc> getAll();
	
	
	/***
     * 分页返回<GoodsDesc>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<GoodsDesc> getAll(GoodsDesc goodsDesc, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(GoodsDesc goodsDesc);
	
	
	/**
	 * 修改
	 */
	int updateGoodsDescById(GoodsDesc goodsDesc);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	GoodsDesc getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
