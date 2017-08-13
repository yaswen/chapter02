package com.ysw.chapter02.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ysw.chapter02.pojos.User;
import com.ysw.chapter02.util.HibernateUtils;


public class HibernateSessionDemo {
	public static void main(String[] args){
		//调用getUser()方法获取用户对象
		User user= getUser(new Integer(1));
		System.out.println("----------原始数据----------");
		System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserPwd()+"\t"+user.getRole());
		user.setUserPwd("111222");
		//调用changeUser()方法修改用户对象信息
		changeUser(user);
		System.out.println("--------修改后的数据--------");
		System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserPwd()+"\t"+user.getRole());
		
	}
	/*获取用户*/
	public static User getUser(Integer key){
		Session session=HibernateUtils.getSession();
		Transaction trans=session.beginTransaction();
		//根据主键获取用户对象
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
}
