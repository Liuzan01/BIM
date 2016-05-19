package com.yc.bim.main.impl;

import org.springframework.stereotype.Component;

import com.yc.bim.entity.Person;
import com.yc.bim.exception.BIMException;
import com.yc.bim.main.MeasureFilter;
import com.yc.bim.main.Measureable;

@Component("BIMeasureFilter")
public class BIMeasureFilter implements MeasureFilter <Person>{

	private double maxHeight;
	private double minHeight;
	private double maxWeight;
	private double minWeight;
	
	
	public double getMaxHeight() {
		return maxHeight;
	}


	public double getMinHeight() {
		return minHeight;
	}


	public double getMaxWeight() {
		return maxWeight;
	}


	public double getMinWeight() {
		return minWeight;
	}


	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}


	public void setMinHeight(double minHeight) {
		this.minHeight = minHeight;
	}


	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}


	public void setMinWeight(double minWeight) {
		this.minWeight = minWeight;
	}


	@Override
	public boolean doFilter(Person person) throws BIMException {
		if(person == null ||person.getHeight()>maxHeight ||
				person.getHeight()<minHeight ||person.getWeight()>maxWeight ||
				person.getWeight()<minWeight ){
			throw new BIMException();
		}
		return true;
	}

}
