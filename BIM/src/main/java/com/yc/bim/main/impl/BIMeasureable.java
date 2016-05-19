package com.yc.bim.main.impl;

import org.springframework.stereotype.Component;

import com.yc.bim.entity.Person;
import com.yc.bim.main.Measureable;

@Component("measureable")
public class BIMeasureable implements Measureable<Person> {

	@Override
	public double measure(Person person) {
		
		return person.getWeight()/(person.getHeight() * person.getHeight());
	}

}
