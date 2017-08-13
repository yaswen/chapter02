package com.ysw.chapter02.demo;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ysw.chapter02.pojos.User;

public class UserCriteriaDemo {
	public static void main(String[] args) {
		// 实例化configuration
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		//打开session
		Session session = sessionFactory.openSession();
		//开始一个事务
		Transaction trans = session.beginTransaction();
		//创建一个criteria查询对象，查询user类的所有对象
		Criteria criteria=session.createCriteria(User.class);
		//执行查询
		List<User> list = criteria.list();
		for (User u : list) {
			System.out.println(u.getId() + "\t\t" + u.getUserName() + "\t\t" + u.getUserPwd() + "\t\t" + u.getRole());

		}
		trans.commit();
		session.close();

	}
}
