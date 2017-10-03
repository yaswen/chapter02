package com.ysw.chapter02.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ysw.chapter02.pojos.User;
import com.ysw.chapter02.util.HibernateUtils;


public class HibernateSessionDemo2 {
	public static void main(String[] args){
		//addus();
		//updateuns();
		
	}
	//批量加一下数据用
	public static void addus() {
		//批量加一下数据
				for(int i = 1 ; i<=10;i++) {
					User user= new User("yas"+i,"111"+i,i);
					System.out.println("新建用户对象"+" "+user.getUserName()+" "+user.getUserPwd()+" "+user.getRole());
					addUser(user);
				}
	}
	/*shiwen批量修改用户名*/
	public static void updateuns() {
		for(int i = 1 ;i<=10;i++){
			User user= getUser(new Integer(i));
			System.out.println("----------原始数据----------"+i);
			System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserPwd()+"\t"+user.getRole());
			user.setUserName("shiwen"+i);
			//调用changeUser()方法修改用户对象信息
			changeUser(user);
			System.out.println("--------修改后的数据--------"+i);
			System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserPwd()+"\t"+user.getRole());
			}
	}
	/*获取用户*/
	public static User getUser(Integer key){
		Session session=HibernateUtils.getSession();
		Transaction trans=session.beginTransaction();
		//根据主键获取用户对象,这里主键是ID列，在hbm.xml中设置的
		User user = (User) session.get(User.class,key);
		trans.commit();
		HibernateUtils.closeSession();
		return user;
	}
	/*修改用户信息*/
	public static void changeUser(User user){
		Session session = HibernateUtils.getSession();
		Transaction trans=session.beginTransaction();
		//更新
		session.update(user);
		trans.commit();
		HibernateUtils.closeSession();
	}
	/*添加用户*/
	public static void addUser(User user){
		Session session = HibernateUtils.getSession();
		Transaction trans=session.beginTransaction();
		//更新
		session.save(user);
		trans.commit();
		HibernateUtils.closeSession();
	}
}
