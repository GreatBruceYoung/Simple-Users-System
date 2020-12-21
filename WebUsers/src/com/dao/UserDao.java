package com.dao;
//数据操作类

import java.util.List;
import com.entity.Users;

public interface UserDao {
	public boolean login(String name,String pwd);//登录
	public boolean register(Users user);//注册
	public List<Users> searchAll();//返回用户信息集合
	public boolean delete(int id) ;//根据id删除用户
	public boolean update(int id,String name, String pwd,String sex, String home,String info) ;//更新用户信息
}
