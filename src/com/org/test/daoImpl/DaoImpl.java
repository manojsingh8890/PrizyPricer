package com.org.test.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.test.beans.Product;
import com.org.test.dao.Dao;

@Repository
public class DaoImpl implements Dao{
	
	@Autowired	
	private com.org.test.dao.DaoSupport daoSupport;

    public boolean saveOrUpdate(Product product){
		Session session  = null;
		Transaction t= null;
		try{			 
			session= daoSupport.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.saveOrUpdate(product);
			t.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			if(session != null)
				session.close();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return false;
	}
	
	public int saveData(Product product){
		Session session  = null;
		Transaction t= null;
		int id =0;
		try{			
			session= daoSupport.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.saveOrUpdate(product);
			t.commit();
			session.close();			
		}catch(Exception e){
			e.printStackTrace();
			if(session != null)
				session.close();
		}finally{
			if(session.isOpen())
				session.close();
		}
		
		return id;
	}


	@Override
	public List<Product> getProducts() {
		Session session  = null;
		Transaction t= null;
		int id =0;
		try{			
			session= daoSupport.getSessionFactory().openSession();
			
			List<Product> list = session.createQuery("from Product as p inner join fetch p.price").list();
			
						
			Hibernate.initialize(list.get(0).getPrice().size());
			
						return list;
		}catch(Exception e){
			e.printStackTrace();
			if(session != null)
				session.close();
		}finally{
			if(session.isOpen())
				session.close();
		}
		
		
		return null;
	}

	@Override
	public Product getProductById(String barcode) {
		Session session  = null;
		Transaction t= null;
		
		try{			
			session= daoSupport.getSessionFactory().openSession();
			
			List<Product> list = session.createQuery("from Product as p inner join fetch p.price where p.barcode =:barcode").setParameter("barcode", barcode).list();
			Hibernate.initialize(list.get(0).getPrice().size());
			
			Product p1= list.get(0);
			for(Product p : list){
				p1.getPrice().add(p.getPrice().get(0));
			}
			return p1;
		}catch(Exception e){
			e.printStackTrace();
			if(session != null)
				session.close();
		}finally{
			if(session.isOpen())
				session.close();
		}
		
		
		return null;
	}
	
	
	/*public boolean deleteData(long id){
		try{
			Session session = daoSupport.getSessionFactory().openSession();
			Student std = (Student) session.get("bean.Student", id);
			session.beginTransaction();
			session.delete(std);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}*/
	
	/*@SuppressWarnings("unchecked")
	public List<Object> getData(){
		try{
			Session session = daoSupport.getSessionFactory().openSession();	
			List<Student> list = session.createQuery("from bean.Student").list();			
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	} */
	
	/*@SuppressWarnings("unchecked")
	public Student getUpdateData(long id){
		try{
			Session session = daoSupport.getSessionFactory().openSession();
			List<Student> list = session.createQuery("from bean.Student where id="+id).list();	
			if(list != null && !list.isEmpty()){
				return list.get(0);
			}
			session.close();			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}*/
	
	
	
	
}
