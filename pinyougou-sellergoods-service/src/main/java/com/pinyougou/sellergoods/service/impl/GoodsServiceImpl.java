package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.GoodsMapper;
import com.pinyougou.model.Goods;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.GoodsService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Goods> getAll() {
		return goodsMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Goods> getAll(Goods goods,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Goods> all = goodsMapper.select(goods);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Goods goods) {
		return goodsMapper.insertSelective(goods);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateGoodsById(Goods goods){
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Goods getOneById(Long id){
		return goodsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_goods where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return goodsMapper.deleteByExample(example);	
	}

}
