package com.springAspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "com.springAspect")
@EnableAspectJAutoProxy 
public class AspectConfig {

}
