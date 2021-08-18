package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.ProvincesMapper;
import com.pinyougou.model.Provinces;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.ProvincesService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ProvincesServiceImpl implements ProvincesService {

	@Autowired
	private ProvincesMapper provincesMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Provinces> getAll() {
		return provincesMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Provinces> getAll(Provinces provinces,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Provinces> all = provincesMapper.select(provinces);
        PageInfo<Provinces> pageInfo = new PageInfo<Provinces>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Provinces provinces) {
		return provincesMapper.insertSelective(provinces);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateProvincesById(Provinces provinces){
		return provincesMapper.updateByPrimaryKeySelective(provinces);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Provinces getOneById(Long id){
		return provincesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Provinces.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_provinces where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return provincesMapper.deleteByExample(example);	
	}

}
