package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.SeckillGoodsMapper;
import com.pinyougou.model.SeckillGoods;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.SeckillGoodsService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

	@Autowired
	private SeckillGoodsMapper seckillGoodsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SeckillGoods> getAll() {
		return seckillGoodsMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<SeckillGoods> getAll(SeckillGoods seckillGoods,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<SeckillGoods> all = seckillGoodsMapper.select(seckillGoods);
        PageInfo<SeckillGoods> pageInfo = new PageInfo<SeckillGoods>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(SeckillGoods seckillGoods) {
		return seckillGoodsMapper.insertSelective(seckillGoods);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateSeckillGoodsById(SeckillGoods seckillGoods){
		return seckillGoodsMapper.updateByPrimaryKeySelective(seckillGoods);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SeckillGoods getOneById(Long id){
		return seckillGoodsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(SeckillGoods.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_seckillGoods where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return seckillGoodsMapper.deleteByExample(example);	
	}

}
