package com.yc.bim.main;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yc.bim.entity.Person;
import com.yc.bim.main.impl.BIMeasureFilter;
@Aspect
@Component
public class FilterAspect {
	@Autowired
	private BIMeasureFilter measureFilter;
	
	@AfterThrowing(value="execution(* com.yc.bim.main.impl.BIMeasureFilter.*(..))",throwing="e")
	public void AfterThrowingMethod(JoinPoint joinPoint,Exception e){
		Person person =(Person)(joinPoint.getArgs()[0]);
		
		boolean wflag =false;
		boolean hflag = false;
		if(person.getHeight() < measureFilter.getMinHeight() || person.getHeight()>measureFilter.getMaxHeight()){
			hflag = true;
		}
		if(person.getWeight() < measureFilter.getMinWeight() || person.getWeight()>measureFilter.getMaxWeight()){
			hflag = true;
		}
		if(wflag && hflag){
			LogManager.getLogger().warn(person + "==>身高和体重都是非正常值!!!");
		}else if(hflag){
			LogManager.getLogger().warn(person + "==>身高是非正常值!!!");
		}else if(wflag){
			LogManager.getLogger().warn(person + "==>体重是非正常值!!!");

		}
		
		
	}
	
}
