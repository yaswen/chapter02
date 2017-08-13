package com.ysw.chapter02.demo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ysw.chapter02.pojos.User;

public class UserHQLDemo {
	public static void main(String[] srgs){
		//实例化configuration
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		StandardServiceRegistryBuilder standardServiceRegistryBuilder =
				new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		//查询User表，这里写的不是数据库中的表名，而是类名（坑）
		Query query=session.createQuery("from User");
		//将User类对应表中的所有记录封装成User对象并保存到List集合中
		List<User> list=query.list();
		for(User u:list){
			System.out.println(u.getId()+"\t\t"+u.getUserName()+"\t\t"+u.getUserPwd()+"\t\t"+u.getRole());
			
		}
		trans.commit();
		session.close();
	}
}
