package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Areas;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AreasService {

	/**
	 * 返回Areas全部列表
	 * @return
	 */
	public List<Areas> getAll();
	
	
	/***
     * 分页返回<Areas>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Areas> getAll(Areas areas, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Areas areas);
	
	
	/**
	 * 修改
	 */
	int updateAreasById(Areas areas);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Areas getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
