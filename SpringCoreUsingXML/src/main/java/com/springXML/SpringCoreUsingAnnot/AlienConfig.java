package com.springXML.SpringCoreUsingAnnot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.springXML.SpringCoreUsingAnnot")
@EnableAspectJAutoProxy
public class AlienConfig {
	
	}
	

