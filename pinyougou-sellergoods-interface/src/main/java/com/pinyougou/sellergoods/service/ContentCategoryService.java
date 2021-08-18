package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.ContentCategory;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ContentCategoryService {

	/**
	 * 返回ContentCategory全部列表
	 * @return
	 */
	public List<ContentCategory> getAll();
	
	
	/***
     * 分页返回<ContentCategory>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<ContentCategory> getAll(ContentCategory contentCategory, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(ContentCategory contentCategory);
	
	
	/**
	 * 修改
	 */
	int updateContentCategoryById(ContentCategory contentCategory);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	ContentCategory getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
