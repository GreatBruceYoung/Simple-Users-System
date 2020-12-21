package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import com.entity.Users;
import com.util.DBconnection;

public class UserDaoImpl implements UserDao {
	/*����һ������ֵ��־*/
    static boolean flag = false;
    /*���SQL������ÿ�������ﶼҪ��дSQL���*/
    static String sql = null;
    
    public boolean login(String name, String pwd) {
        try {
            DBconnection.init();
            sql = "SELECT * FROM users WHERE name= ? AND pwd = ?";
            /*ʹ��Ԥ����SQL���ݲ���*/
            Object[] args = {name,pwd};
            ResultSet rs = DBconnection.searchSql(sql, args);
            /*�������ݿ�����˺��������jsp�������˺��������Ա�*/
            while (rs.next()) {
                if (rs.getString("name").equals(name)&&rs.getString("pwd").equals(pwd)){
                    flag = true;
                    System.out.println("��¼�ɹ�");
                }
            }
        }catch (Exception e) {
            System.out.println("��¼ʧ��");
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
                System.out.println("ע��ɹ�");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("ע��ʧ��");
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
            System.out.println("��ȡ�����û���Ϣ�ɹ�");
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
            System.out.println("��ȡ�����û���Ϣʧ��");
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
                System.out.println("���ݸ��³ɹ�");
            }
        }catch (Exception e) {
            System.out.println("���ݸ���ʧ��");
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
                System.out.println("ɾ���ɹ�");
            }
        }catch (Exception e) {
            System.out.println("ɾ��ʧ��");
            e.printStackTrace();
        }finally {
            DBconnection.close();
        }
        return flag;
    }

}
