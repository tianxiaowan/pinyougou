package com.pinyougou.sellergoods.service.impl;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.model.Brand;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.BrandService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Brand> getAll() {
		return brandMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Brand> getAll(Brand brand,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		System.out.println("测试");
		System.out.println(pageNum+":"+pageSize);
//		List<Brand> all = brandMapper.select(brand);

		Example example = new Example(Brand.class);
		Example.Criteria criteria = example.createCriteria();
		if(brand != null){
			if(StringUtils.isNotBlank(brand.getName())){
				criteria.andLike("name","%"+brand.getName()+"%");
			}

			if (StringUtils.isNotBlank(brand.getFirstChar())){
				criteria.andEqualTo("firstChar",brand.getFirstChar());
			}
		}

		List<Brand> brands = brandMapper.selectByExample(example);

		PageInfo<Brand> pageInfo = new PageInfo<Brand>(brands);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Brand brand) {
		return brandMapper.insertSelective(brand);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateBrandById(Brand brand){
		return brandMapper.updateByPrimaryKeySelective(brand);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Brand getOneById(Long id){
		return brandMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_brand where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return brandMapper.deleteByExample(example);	
	}

}
