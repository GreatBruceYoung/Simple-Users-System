package com.entity;

public class Users {
	//实体类：实体即抽象出来的用户对象，对应数据库中的user表,表中每个字段在实体中为一个属性，也可以理解为一个User对象对应数据库中的user表一条记录
	//定义对象的属性
	 private int id;
	 private String name;
	 private String pwd;
	 private String sex;
	 private String home;
	 private String info;
	 public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getHome() {
			return home;
		}
		public void setHome(String home) {
			this.home = home;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}

}
