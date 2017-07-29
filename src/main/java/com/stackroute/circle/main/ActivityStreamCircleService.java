package com.stackroute.circle.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.stackroute.circle.model.Circle;

@SpringBootApplication(scanBasePackages={"com.stackroute.circle"})
@EntityScan(basePackageClasses=Circle.class)
public class ActivityStreamCircleService {

	public static void main(String[] args)
	{
		SpringApplication.run(ActivityStreamCircleService.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
}
