package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.AreasMapper;
import com.pinyougou.model.Areas;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.AreasService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AreasServiceImpl implements AreasService {

	@Autowired
	private AreasMapper areasMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Areas> getAll() {
		return areasMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Areas> getAll(Areas areas,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Areas> all = areasMapper.select(areas);
        PageInfo<Areas> pageInfo = new PageInfo<Areas>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Areas areas) {
		return areasMapper.insertSelective(areas);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateAreasById(Areas areas){
		return areasMapper.updateByPrimaryKeySelective(areas);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Areas getOneById(Long id){
		return areasMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Areas.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_areas where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return areasMapper.deleteByExample(example);	
	}

}
