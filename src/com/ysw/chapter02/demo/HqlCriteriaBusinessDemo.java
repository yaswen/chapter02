package com.ysw.chapter02.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.Order;
import com.ysw.chapter02.util.HibernateUtils;

public class HqlCriteriaBusinessDemo {
	public static void main(String[] args){
		//findCustomerByAddress_HQL("嵊泗");
		//findCustomerByAddress_QBC("嵊泗");
		//orderByUserNameByDesc_HQL();
		//orderByuserNameByDesc_QBC();
		//第二页，每页三条记录：
		//List<Customer> list=listPageCustomer_HQL(1,3);
		//List<Customer> list=listPageCustomer_QBC(2,3);

		//Customer c=findOneCustomer_HQL();
		//Customer c=findOneCustomer_QBC();
		//System.out.println(c.getId()+"\t"+c.getUserName()+"\t"+c.getIdCard().getCardNo());
		//List<Customer> list=findCustomersByName1("Mary");
//		List<Customer> list=findCustomersByName2("Mary");
//		for (Customer c:list){
//			System.out.println(c.getId()+"\t"+c.getUserName());
//		}
//		printOrder_HQL();
//		printOrder_QBC();
//		printCustomer_HQL();
		findCustomerByJoin();
	}
	/*使用HQL检索根据地址查询Customer*/
	public static void findCustomerByAddress_HQL(String address){
		//(1)获取session对象
		Session session=HibernateUtils.getSession();
		//(2)编写hql语句
		String hql="from Customer c where c.address = :address";
		/*//(3)以HQL作为参数，调用session的createQuery()方法创建Query对象
		Query query=session.createQuery(hql);
		//(4)调用Query对象的setXXX()方法为参数赋值
		query.setString("address",address);
		//(5)调用Query对象的list()等方法得到查询结果
		List<Customer> list=query.list();*/
		/*将以上345步匿名方式进行简化（方法链编程风格）*/
		List<Customer> list=session.createQuery(hql)
				.setString("address",address)
				.list();
		for (Customer c:list){
			System.out.println(c.getId()+"\t"+c.getUserName());
		}
	}
	/*使用QBC检索根据地址查询Customer*/
	public static void findCustomerByAddress_QBC(String address){
		//(1)获取session对象
		Session session=HibernateUtils.getSession();
		/*分步方式
		//(2)以Customer的Class对象作为参数，创建Criteria对象
		Criteria criteria=session.createCriteria(Customer.class);
		//(3)调用Criteria对象的add()方法，增加Criteria查询条件
		criteria.add(Restrictions.eq("address",address));
		//(4)执行Criteria的list()方法返回查询结果
		List<Customer> list=criteria.list();
		*/
		/*使用匿名方式简化代码：*/
		List<Customer> list=session.createCriteria(Customer.class)
				.add(Restrictions.eq("address", address))
				.list();
		//遍历输出结果
		for (Customer c:list){
			System.out.println(c.getId()+"\t"+c.getUserName());
		}
	}
	public static void orderByUserNameByDesc_HQL(){
		//(1)获取session对象
		Session session=HibernateUtils.getSession();
		//(2)编写hql语句
		String hql="from Customer c order by c.userName desc";
		//(3)以hql作为参数，调用session的createQuery()方法创建Query对象
		Query query=session.createQuery(hql);
		//(4)调用query对象的list方法遍历结果
		List<Customer> list=query.list();
		for(Customer c:list){
			System.out.println(c.getId() + "\t" + c.getUserName()+"\t"+c.getAddress());
		}
	}
	public static void orderByuserNameByDesc_QBC(){
		//获取session对象
		Session session=HibernateUtils.getSession();
		//(2)以Customer的Class对象作为参数，创建criteria对象
		Criteria criteria=session.createCriteria(Customer.class);
		//调用criteria对象的addOrder()方法条件排序规则
		criteria.addOrder(org.hibernate.criterion.Order.desc("userName"));
		List<Customer> list = criteria.list();
		for(Customer c:list){
			System.out.println(c.getId()+"\t"+c.getUserName()+"\t"+c.getAddress());
		}
	}
	public static List<Customer> listPageCustomer_HQL(int pageNo,int perPageNum){
		Session session=HibernateUtils.getSession();
		String hql="from Customer c order by c.userName desc";
		Query query=session.createQuery(hql);
		query.setFirstResult((pageNo-1)*perPageNum);
		query.setMaxResults(perPageNum);
		List<Customer> list=query.list();
		return list;
	}
	public static List<Customer> listPageCustomer_QBC(int pageNo,int perPageNum){
		Session session=HibernateUtils.getSession();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.setFirstResult((pageNo-1)*perPageNum);
		criteria.setMaxResults(perPageNum);
		List<Customer> list=criteria.list();
		return list;
		
	}
	public static Customer findOneCustomer_HQL(){
		Session session=HibernateUtils.getSession();
		String hql="from Customer c order by c.userName desc";
		Customer customer=(Customer)session.createQuery(hql)
				.setMaxResults(1)
				.uniqueResult();
		return customer;
	}
	public static Customer findOneCustomer_QBC(){
		Session session=HibernateUtils.getSession();
		Customer customer=(Customer) session.createCriteria(Customer.class)
				.addOrder(org.hibernate.criterion.Order.desc("userName"))
				.setMaxResults(1)
				.uniqueResult();
		return customer;
	}
	public static List<Customer> findCustomersByName1(String name){
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//创建HQL
		String hql="from Customer as c where c.userName = :name";
		Query query=session.createQuery(hql);
		//按照参数名字进行绑定
		query.setString("name",name);
		return query.list();
	}
	public static List<Customer> findCustomersByName2(String name){
		Session session=HibernateUtils.getSession();
		String hql="from Customer as c where c.userName = ?";
		Query query=session.createQuery(hql);
		//按照参数位置进行绑定
		query.setString(0, name);
		return query.list();
	}
	public static void printOrder_HQL(){
		Session session=HibernateUtils.getSession();
		//HQL检索日期在指定范围之内
		String hql="from Order o where o.date between ? and ?";
		//创建一个日期格式类，用于格式化日期
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			List<Order> list = session.createQuery(hql)
					.setParameter(0, dateFormat.parse("2017-08-01 00:00:00"))
					.setParameter(1, dateFormat.parse("2017-08-10 23:59:59"))
					.list();
			//打印结果
			for(Order o:list){
				System.out.println(o.getId()+"\t"+o.getDate());
			}
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	public static void printOrder_QBC(){
		Session session=HibernateUtils.getSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			List<Order> list=session
					.createCriteria(Order.class)
					.add(Restrictions.between("date", 
							dateFormat.parse("2017-07-01 00:00:00"),
							dateFormat.parse("2017-07-31 23:59:59")))
					.list();
			for(Order o:list){
				System.out.println(o.getId()+"\t"+o.getDate());
			}
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	//比较运算
	public static void printCustomer_HQL(){
		Session session=HibernateUtils.getSession();
		String hql="from Customer c where c.address ='嵊泗'";
			List<Customer> list = session.createQuery(hql).list();
			//打印结果
			for(Customer c:list){
				System.out.println(c.getId()+"\t"+c.getUserName());

			}
	}
	//HQL内连接
	public static void findCustomerByJoin(){
		Session session=HibernateUtils.getSession();
		//使用HQL进行内连接
		String hql="from Customer c inner join c.orders o where c.userName like :name";
		Query query=session.createQuery(hql);
		query.setString("name", "M%");
		List<Object[ ]> list=query.list();
		for(Object[ ] objs:list){
			Customer customer=(Customer)objs[0];
			System.out.print(customer.getId()+"*"+customer.getUserName()+"*");
			Order order=(Order) objs[1];
			System.out.print(order.getOrderNo()+"*");
			System.out.print(order.getDate());
			System.out.println();
		}
	//通过内连接的方式将Query对象的list()方法返回的集合中包含的满足条件的元素在控制台上输出，
	//且每个元素对应查询结果中的一条记录，每个元素都是Object[ ]类型，并且其长度为2，
	//实际上每个Object[ ]数组中都存放了一对Customer和Order对象。
	}
}
