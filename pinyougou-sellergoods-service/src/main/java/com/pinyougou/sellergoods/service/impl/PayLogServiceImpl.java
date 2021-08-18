package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.PayLogMapper;
import com.pinyougou.model.PayLog;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.PayLogService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class PayLogServiceImpl implements PayLogService {

	@Autowired
	private PayLogMapper payLogMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<PayLog> getAll() {
		return payLogMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<PayLog> getAll(PayLog payLog,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<PayLog> all = payLogMapper.select(payLog);
        PageInfo<PayLog> pageInfo = new PageInfo<PayLog>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(PayLog payLog) {
		return payLogMapper.insertSelective(payLog);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updatePayLogById(PayLog payLog){
		return payLogMapper.updateByPrimaryKeySelective(payLog);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public PayLog getOneById(Long id){
		return payLogMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(PayLog.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_payLog where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return payLogMapper.deleteByExample(example);	
	}

}
