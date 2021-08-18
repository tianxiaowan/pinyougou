package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.TypeTemplate;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface TypeTemplateService {

	/**
	 * 返回TypeTemplate全部列表
	 * @return
	 */
	public List<TypeTemplate> getAll();
	
	
	/***
     * 分页返回<TypeTemplate>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<TypeTemplate> getAll(TypeTemplate typeTemplate, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(TypeTemplate typeTemplate);
	
	
	/**
	 * 修改
	 */
	int updateTypeTemplateById(TypeTemplate typeTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	TypeTemplate getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
