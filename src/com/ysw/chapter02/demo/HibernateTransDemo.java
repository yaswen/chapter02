package com.ysw.chapter02.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.User;
import com.ysw.chapter02.util.HibernateUtils;

public class HibernateTransDemo {
	public static void main(String[] args){
		insert10();
	}
	public static void insert10(){
		Session session=HibernateUtils.getSession();
		Transaction trans=session.beginTransaction();
		/*保存100000ge Customer对象*/
		for(int i = 0;i<100000;i++){
			User user=new User("shiwen"+i,""+i+i+i,i%5);
			session.save(user);
			if(i%10==0){
				session.flush();
				session.clear();
				trans.commit();
				trans=session.beginTransaction();
			}
		}
		
		HibernateUtils.closeSession();
	}
}
