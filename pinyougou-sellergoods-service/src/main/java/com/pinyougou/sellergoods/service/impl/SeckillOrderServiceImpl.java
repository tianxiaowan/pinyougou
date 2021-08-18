package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.SeckillOrderMapper;
import com.pinyougou.model.SeckillOrder;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.SeckillOrderService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

	@Autowired
	private SeckillOrderMapper seckillOrderMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SeckillOrder> getAll() {
		return seckillOrderMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<SeckillOrder> getAll(SeckillOrder seckillOrder,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<SeckillOrder> all = seckillOrderMapper.select(seckillOrder);
        PageInfo<SeckillOrder> pageInfo = new PageInfo<SeckillOrder>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(SeckillOrder seckillOrder) {
		return seckillOrderMapper.insertSelective(seckillOrder);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateSeckillOrderById(SeckillOrder seckillOrder){
		return seckillOrderMapper.updateByPrimaryKeySelective(seckillOrder);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SeckillOrder getOneById(Long id){
		return seckillOrderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(SeckillOrder.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_seckillOrder where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return seckillOrderMapper.deleteByExample(example);	
	}

}
