package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("seoul")
public class SeoulZoo implements Zoo{
	@Autowired
	@Qualifier("t1")
	Tiger tiger;
	@Autowired
	@Qualifier("l1")
	Lion lion;
	
	public void info() {
		tiger.info();
		lion.info();
	}
}
