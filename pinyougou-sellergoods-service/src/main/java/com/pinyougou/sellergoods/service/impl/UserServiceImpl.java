package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.UserMapper;
import com.pinyougou.model.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import com.pinyougou.sellergoods.service.UserService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<User> getAll() {
		return userMapper.selectAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageInfo<User> getAll(User user,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<User> all = userMapper.select(user);
        PageInfo<User> pageInfo = new PageInfo<User>(all);
        return pageInfo;
	}

	/**
	 * 增加
	 */
	@Override
	public int add(User user) {
		return userMapper.insertSelective(user);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public int updateUserById(User user){
		return userMapper.updateByPrimaryKeySelective(user);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public User getOneById(Long id){
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deleteByIds(List<Long> ids) {
		//创建Example，来构建根据ID删除数据
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_user where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return userMapper.deleteByExample(example);	
	}

}
