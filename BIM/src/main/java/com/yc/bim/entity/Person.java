package com.yc.bim.entity;

//测量对象实体类
public class Person {
	
	private String name;
	private double height;
	private double weight;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "\nPerson [name=" + name + ", height=" + height + ", weight="
				+ weight + "]";
	}
	
}
