package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.GoodsDescMapper;
import com.pinyougou.model.GoodsDesc;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.GoodsDescService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService {

	@Autowired
	private GoodsDescMapper goodsDescMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<GoodsDesc> getAll() {
		return goodsDescMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<GoodsDesc> getAll(GoodsDesc goodsDesc,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<GoodsDesc> all = goodsDescMapper.select(goodsDesc);
        PageInfo<GoodsDesc> pageInfo = new PageInfo<GoodsDesc>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(GoodsDesc goodsDesc) {
		return goodsDescMapper.insertSelective(goodsDesc);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateGoodsDescById(GoodsDesc goodsDesc){
		return goodsDescMapper.updateByPrimaryKeySelective(goodsDesc);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public GoodsDesc getOneById(Long id){
		return goodsDescMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(GoodsDesc.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_goodsDesc where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return goodsDescMapper.deleteByExample(example);	
	}

}
