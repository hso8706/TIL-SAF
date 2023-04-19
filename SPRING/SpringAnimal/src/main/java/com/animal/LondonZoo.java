package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("london")
public class LondonZoo implements Zoo{
	@Autowired
	@Qualifier("t2")
	Tiger tiger;
	@Autowired
	@Qualifier("l2")
	Lion lion;
	
	public void info() {
		tiger.info();
		lion.info();
	}
}
