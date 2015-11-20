package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

	
	public boolean login(Users u) {
		Transaction tx=null;//事务对象
		String hql="";
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Users where username=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list=query.list();
			tx.commit();
			if(list.size()>0){
				return true;
			}else
			{
				return false;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}finally{
			if(tx!=null){
				
				tx=null;
			}
			
		}
	}
	

}
