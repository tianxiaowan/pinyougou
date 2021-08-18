package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Provinces;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ProvincesService {

	/**
	 * 返回Provinces全部列表
	 * @return
	 */
	public List<Provinces> getAll();
	
	
	/***
     * 分页返回<Provinces>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Provinces> getAll(Provinces provinces, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Provinces provinces);
	
	
	/**
	 * 修改
	 */
	int updateProvincesById(Provinces provinces);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Provinces getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
