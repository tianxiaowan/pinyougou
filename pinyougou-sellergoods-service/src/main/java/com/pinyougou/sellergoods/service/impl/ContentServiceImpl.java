package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.ContentMapper;
import com.pinyougou.model.Content;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.ContentService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Content> getAll() {
		return contentMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Content> getAll(Content content,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Content> all = contentMapper.select(content);
        PageInfo<Content> pageInfo = new PageInfo<Content>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Content content) {
		return contentMapper.insertSelective(content);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateContentById(Content content){
		return contentMapper.updateByPrimaryKeySelective(content);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Content getOneById(Long id){
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_content where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return contentMapper.deleteByExample(example);	
	}

}
