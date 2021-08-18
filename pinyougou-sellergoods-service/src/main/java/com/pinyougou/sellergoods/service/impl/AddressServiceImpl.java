package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.AddressMapper;
import com.pinyougou.model.Address;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.AddressService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Address> getAll() {
		return addressMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<Address> getAll(Address address,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Address> all = addressMapper.select(address);
        PageInfo<Address> pageInfo = new PageInfo<Address>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Address address) {
		return addressMapper.insertSelective(address);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateAddressById(Address address){
		return addressMapper.updateByPrimaryKeySelective(address);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Address getOneById(Long id){
		return addressMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_address where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return addressMapper.deleteByExample(example);	
	}

}
