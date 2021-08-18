package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.pinyougou.model.PayLog;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface PayLogService {

	/**
	 * 返回PayLog全部列表
	 * @return
	 */
	public List<PayLog> getAll();
	
	
	/***
     * 分页返回<PayLog>列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	public PageInfo<PayLog> getAll(PayLog payLog, int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	int add(PayLog payLog);
	
	
	/**
	 * 修改
	 */
	int updatePayLogById(PayLog payLog);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	PayLog getOneById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int deleteByIds(List<Long> ids);

	
}
