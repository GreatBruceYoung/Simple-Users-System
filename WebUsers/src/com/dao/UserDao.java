package com.dao;
//���ݲ�����

import java.util.List;
import com.entity.Users;

public interface UserDao {
	public boolean login(String name,String pwd);//��¼
	public boolean register(Users user);//ע��
	public List<Users> searchAll();//�����û���Ϣ����
	public boolean delete(int id) ;//����idɾ���û�
	public boolean update(int id,String name, String pwd,String sex, String home,String info) ;//�����û���Ϣ
}
