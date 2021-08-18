package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.SpecificationOption;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SpecificationOptionService {

	/**
	 * 返回SpecificationOption全部列表
	 * @return
	 */
	public List<SpecificationOption> getAll();
	
	
	/***
     * 分页返回<SpecificationOption>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<SpecificationOption> getAll(SpecificationOption specificationOption, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(SpecificationOption specificationOption);
	
	
	/**
	 * 修改
	 */
	int updateSpecificationOptionById(SpecificationOption specificationOption);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SpecificationOption getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
