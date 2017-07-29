package com.stackroute.circle.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.circle.dao.CircleDao;
import com.stackroute.circle.model.Circle;

@Repository(value="circleDao")
@Component
@Transactional
public class CircleDaoImpl implements CircleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CircleDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public CircleDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean addCircle(Circle circle) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(circle);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	

	
	public boolean deleteCircle(Circle circle) {
		try
		{
			sessionFactory.getCurrentSession().delete(circle);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public List<Circle> getAllCircles() {
		
		return sessionFactory.getCurrentSession().createQuery("from Circle").list();
	}
	public List<Circle> getCircleByUser(String emailId) {
		try
		{
			String hql="from Circle where createdBy= '" + emailId +"'";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
	}
	

}
