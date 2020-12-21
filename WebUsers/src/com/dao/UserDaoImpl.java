package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import com.entity.Users;
import com.util.DBconnection;

public class UserDaoImpl implements UserDao {
	/*创建一个返回值标志*/
    static boolean flag = false;
    /*提高SQL作用域，每个方法里都要编写SQL语句*/
    static String sql = null;
    
    public boolean login(String name, String pwd) {
        try {
            DBconnection.init();
            sql = "SELECT * FROM users WHERE name= ? AND pwd = ?";
            /*使用预编译SQL传递参数*/
            Object[] args = {name,pwd};
            ResultSet rs = DBconnection.searchSql(sql, args);
            /*遍历数据库里的账号密码与从jsp传来的账号密码作对比*/
            while (rs.next()) {
                if (rs.getString("name").equals(name)&&rs.getString("pwd").equals(pwd)){
                    flag = true;
                    System.out.println("登录成功");
                }
            }
        }catch (Exception e) {
            System.out.println("登录失败");
            e.printStackTrace();
        } finally {
            DBconnection.close();
        }
        return flag;
    }

    public boolean register(Users user) {
        try {
            DBconnection.init();
            sql="INSERT INTO users(name,pwd,sex,home,info)"+"VALUES(?,?,?,?,?)";
            Object[] args = {user.getName(),user.getPwd(),user.getSex(),user.getHome(),user.getInfo()};
            int i = DBconnection.addUpdDel(sql,args);
            if (i>0){
                flag = true;
                System.out.println("注册成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("注册失败");
        }finally {
            DBconnection.close();
        }
        return flag;
    }

    public List<Users> searchAll() {
        List<Users> list = new ArrayList<Users>();
        try {
            DBconnection.init();
            sql = "SELECT * FROM users";
            ResultSet rs = DBconnection.getUsers(sql);
            System.out.println("获取所有用户信息成功");
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                list.add(user);
            }
        }catch (Exception e){
            System.out.println("获取所有用户信息失败");
            e.printStackTrace();
        }finally{
            DBconnection.close();
        }
        return list;
    }

    public boolean update(int id, String name, String pwd, String sex, String home, String info) {
        try {
            DBconnection.init();
            sql = "UPDATE users SET name=?,pwd=?,sex=?,home=?,info=? WHERE id=?";
            Object[] args={name,pwd,sex,home,info,id};
            int i = DBconnection.addUpdDel(sql,args);
            if (i>0){
                flag=true;
                System.out.println("数据更新成功");
            }
        }catch (Exception e) {
            System.out.println("数据更新失败");
            e.printStackTrace();
        }finally {
            DBconnection.close();
        }
        return flag;
    }

    public boolean delete(int id) {
        try {
            DBconnection.init();
            sql = "DELETE FROM users WHERE id = ?";
            Object[] args = {id};
            int i = DBconnection.addUpdDel(sql,args);
            if (i>0){
                flag=true;
                System.out.println("删除成功");
            }
        }catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }finally {
            DBconnection.close();
        }
        return flag;
    }

}
