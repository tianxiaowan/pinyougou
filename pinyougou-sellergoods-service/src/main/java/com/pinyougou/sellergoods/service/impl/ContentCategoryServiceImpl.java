package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.ContentCategoryMapper;
import com.pinyougou.model.ContentCategory;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.ContentCategoryService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper contentCategoryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ContentCategory> getAll() {
		return contentCategoryMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<ContentCategory> getAll(ContentCategory contentCategory,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<ContentCategory> all = contentCategoryMapper.select(contentCategory);
        PageInfo<ContentCategory> pageInfo = new PageInfo<ContentCategory>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(ContentCategory contentCategory) {
		return contentCategoryMapper.insertSelective(contentCategory);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateContentCategoryById(ContentCategory contentCategory){
		return contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ContentCategory getOneById(Long id){
		return contentCategoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(ContentCategory.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_contentCategory where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return contentCategoryMapper.deleteByExample(example);	
	}

}
