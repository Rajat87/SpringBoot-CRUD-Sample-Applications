package com.springBeanScope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RepositoryImplementer implements Repository {

	@Override
	public void storeInDB() {
		System.out.println("Stored in DB");
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The Bean present in the Context created by Spring which has a Singleton Scope";
	}
}
