package com.ysw.chapter02.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ysw.chapter02.pojos.User;
public class UserDemo {
	public static void main(String[] args){
		//创建测试用user对象
		User user=new User("诗文","s",1);
		//实例化configration
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		//持久化操作
		session.save(user);
		//Transaction中主要定义了commint()和rollback()两个方法：提交和回滚
		//一个transaction对象的事务可能包括多个持久化操作，
		//程序员可以根据需要将多个持久化操作放在开始事务和提交事务之间，形成一个完整的事务。
		transaction.commit();
		session.close();
	}
}
