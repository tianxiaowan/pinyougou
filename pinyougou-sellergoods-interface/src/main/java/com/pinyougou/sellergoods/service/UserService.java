package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.User;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 返回User全部列表
	 * @return
	 */
	public List<User> getAll();
	
	
	/***
     * 分页返回<User>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<User> getAll(User user, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(User user);
	
	
	/**
	 * 修改
	 */
	int updateUserById(User user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	User getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
