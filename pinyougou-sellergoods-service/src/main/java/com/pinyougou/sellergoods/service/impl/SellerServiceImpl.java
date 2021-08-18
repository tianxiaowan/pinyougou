package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.SellerMapper;
import com.pinyougou.model.Seller;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.SellerService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerMapper sellerMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Seller> getAll() {
		return sellerMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Seller> getAll(Seller seller,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Seller> all = sellerMapper.select(seller);
        PageInfo<Seller> pageInfo = new PageInfo<Seller>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Seller seller) {
		return sellerMapper.insertSelective(seller);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateSellerById(Seller seller){
		return sellerMapper.updateByPrimaryKeySelective(seller);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Seller getOneById(Long id){
		return sellerMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Seller.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_seller where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return sellerMapper.deleteByExample(example);	
	}

}
