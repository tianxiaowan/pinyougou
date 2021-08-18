package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Content;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ContentService {

	/**
	 * 返回Content全部列表
	 * @return
	 */
	public List<Content> getAll();
	
	
	/***
     * 分页返回<Content>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Content> getAll(Content content, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Content content);
	
	
	/**
	 * 修改
	 */
	int updateContentById(Content content);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Content getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
