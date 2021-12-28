package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

import com.pinyougou.model.Specification;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SpecificationService {

	/**
	 * 返回Specification全部列表
	 * @return
	 */
	public List<Specification> getAll();
	
	
	/***
     * 分页返回<Specification>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<Specification> getAll(Specification specification, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(Specification specification);
	
	
	/**
	 * 修改
	 */
	int updateSpecificationById(Specification specification);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Specification getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);


    List<Map<String, Object>> selectOptionList();
}
