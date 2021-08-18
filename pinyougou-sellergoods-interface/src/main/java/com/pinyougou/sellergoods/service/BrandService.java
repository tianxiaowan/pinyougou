package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.Brand;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 返回Brand全部列表
	 * @return
	 */
	public List<Brand> getAll();
	
	
	/***
     * 分页返回<Brand>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Brand> getAll(Brand brand, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Brand brand);
	
	
	/**
	 * 修改
	 */
	int updateBrandById(Brand brand);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Brand getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
