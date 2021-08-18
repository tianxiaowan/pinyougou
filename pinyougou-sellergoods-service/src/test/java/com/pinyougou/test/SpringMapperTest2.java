package com.pinyougou.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.model.Brand;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

public class SpringMapperTest2 {
    private BrandMapper brandMapper;

    @Before
    public void init (){
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring/spring.xml");
        brandMapper = acx.getBean(BrandMapper.class);
    }

    @Test
    public void testInsert(){
        Brand brand = new Brand();
        brand.setName("测试啊");
        brandMapper.insert(brand);
    }

    @Test
    public void testInsertSelective(){
        Brand brand = new Brand();
        brand.setName("测试啊66");
        brandMapper.insertSelective(brand);
    }

    @Test
    public void testDeleteByPrimaryKey(){
        long id = 29L;
        brandMapper.deleteByPrimaryKey(id);
    }

    @Test
    public void testDelete(){
        Brand brand = new Brand();
        brand.setName("测试啊");
        brandMapper.delete(brand);
    }

    @Test
    public void testDeleteByExample(){
        Example example =new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        List<Long> ids = new ArrayList<Long>();
        ids.add(32L);
        ids.add(33L);
        criteria.andIn("id",ids);
        brandMapper.deleteByExample(example);
    }

    @Test
    public void testUpdateByExample(){
        Brand brand = new Brand();
        brand.setName("测试啊");
        Example  example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        List<String> names = new ArrayList<String>();
        names.add("小红666");
        names.add("小黑666");
        criteria.andIn("name",names);
        brandMapper.updateByExample(brand,example);
    }

    @Test
    public void testSelectAll(){
        PageHelper.startPage(1,5);

        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);

        PageInfo<Brand> pageInfo = new PageInfo<Brand>();
        System.out.println(pageInfo);
    }

}
