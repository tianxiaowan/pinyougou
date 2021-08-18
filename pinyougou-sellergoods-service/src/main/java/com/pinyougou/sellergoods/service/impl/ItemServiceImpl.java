package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.ItemMapper;
import com.pinyougou.model.Item;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.ItemService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Item> getAll() {
		return itemMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Item> getAll(Item item,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Item> all = itemMapper.select(item);
        PageInfo<Item> pageInfo = new PageInfo<Item>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Item item) {
		return itemMapper.insertSelective(item);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateItemById(Item item){
		return itemMapper.updateByPrimaryKeySelective(item);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Item getOneById(Long id){
		return itemMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Item.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_item where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return itemMapper.deleteByExample(example);	
	}

}
