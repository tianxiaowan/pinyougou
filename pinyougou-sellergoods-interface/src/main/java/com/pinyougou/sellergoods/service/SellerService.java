package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Seller;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerService {

	/**
	 * 返回Seller全部列表
	 * @return
	 */
	public List<Seller> getAll();
	
	
	/***
     * 分页返回<Seller>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Seller> getAll(Seller seller, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Seller seller);
	
	
	/**
	 * 修改
	 */
	int updateSellerById(Seller seller);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Seller getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
