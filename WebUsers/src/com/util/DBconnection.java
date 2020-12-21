package com.util;
//���ݿ����ӹ�����

import java.sql.*;

public class DBconnection {
    static String url = "jdbc:postgresql://localhost:5432/web";
    static String username = "postgres";
    static String password = "123456";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

  /*�������ݿ�*/
      public static void init() {
        try {
          /*1.���������������������*/
          Class.forName("org.postgresql.Driver");
          /*2.�������ݿ�*/
          conn = DriverManager.getConnection(url, username, password);
          System.out.println("���ݿ����ӳɹ�");
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("���ݿ�����ʧ��");
        }
    }
    /*��ѯ����(���ݲ���)*/
    public static ResultSet searchSql(String sql,Object[] args){
        try {
            ps = conn.prepareStatement(sql);
            for (int j = 0; j < args.length; j++) {
                ps.setObject(j+1, args[j]);
            }
            rs = ps.executeQuery();
            System.out.println("���ݿ��ѯ�ɹ�");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("���ݿ��ѯʧ��");
        }
        return rs;
    }
    /*��ɾ�Ĳ�����(���ݲ���)*/
    public static int addUpdDel(String sql,Object[] args){
        int i = 0;
        try{
            ps = conn.prepareStatement(sql);
            for (int j = 0; j < args.length; j++) {
                ps.setObject(j+1, args[j]);
            }
            i = ps.executeUpdate();
            System.out.println("���ݿ���³ɹ�");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("���ݿ����ʧ��");
        }
        return i;
    }
    /*�����ݲ�����ѯ�����û���Ϣ*/
    public static ResultSet getUsers(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("���ݿ��ѯ�ɹ�");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("���ݿ��ѯʧ��");
        }
        return rs;
    }
    /*����*/
    public static void close() {
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            System.out.println("���ݿ�ر��쳣");
        }
    }
    
}
