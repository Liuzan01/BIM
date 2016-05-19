package com.yc.bim.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yc.bim.entity.Person;
import com.yc.bim.exception.BIMException;

@Component("container")
public class Container<T> {
	@Autowired
	private Measureable<T> measureable;	//测量工具
	@Autowired
	private MeasureFilter<T> measureFilter;	//过滤工具
	
	private List<T> objs=new ArrayList<T>();	//	测量东东
	private T maxObj;
	private T minObj;
	private double total;	//总量
	private double avg;
	
	public void add(T obj){
		//1.先过滤
		try {
			measureFilter.doFilter(obj);
		} catch (BIMException e) {
			return;
		}
			
		
		//2.再测量
		double currValue = measureable.measure(obj);
		//3.设置最大值和最小值
		if(maxObj == null && minObj == null){
			maxObj = obj;
			minObj = obj;
		}else if(currValue > measureable.measure(maxObj)){
			maxObj = obj;
		}else if(currValue < measureable.measure(minObj)){
			minObj = obj;
		}
		//4.计算总量
		total += currValue;
		//5.添加到测量数据集中
		objs.add(obj);
	}

	public List<T> getObjs() {
		return objs;
	}

	public Object getMaxObj() {
		return maxObj;
	}

	public Object getMinObj() {
		return minObj;
	}

	public double getTotal() {
		return total;
	}

	//取平均
	public double getAvg() {
		if(objs.size() == 0){
			return 0;
		}
		return total/objs.size();
	}
	
}
