package com.stackroute.circle.dao;

import java.util.List;

import com.stackroute.circle.model.Circle;

public interface CircleDao {

	boolean addCircle(Circle circle);
	boolean deleteCircle(Circle circle);
	List<Circle> getAllCircles();
	List<Circle> getCircleByUser(String emailId);
	
}

