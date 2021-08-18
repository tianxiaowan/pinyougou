package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Address;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AddressService {

	/**
	 * 返回Address全部列表
	 * @return
	 */
	public List<Address> getAll();
	
	
	/***
     * 分页返回<Address>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Address> getAll(Address address, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Address address);
	
	
	/**
	 * 修改
	 */
	int updateAddressById(Address address);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Address getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
