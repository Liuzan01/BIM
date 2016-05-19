package com.yc.bim.main;

import static org.junit.Assert.*;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bim.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ContainerTest {
	
	
	@Autowired
	private Container<Person> container;
	
	
	@Test
	public void testAdd() {
		Random rand = new Random();
		for(int i=0;i<10;i++){
			Person person = new Person();
			person.setName("刘"+i);
			person.setHeight(rand.nextInt(300));
			person.setWeight(rand.nextInt(1000));
			container.add(person);
		}
		LogManager.getLogger().debug("测量的对象==>" + container.getObjs());
		LogManager.getLogger().debug("测量的最大对象==>" + container.getMaxObj());

		LogManager.getLogger().debug("测量的最小对象==>" + container.getMinObj());

		LogManager.getLogger().debug("测量的总量==>" + container.getTotal());

		LogManager.getLogger().debug("测量的平均值==>" + container.getAvg());

	}

}
