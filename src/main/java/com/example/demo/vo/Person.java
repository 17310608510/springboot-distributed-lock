package com.example.demo.vo;

import java.io.Serializable;

/**
 * @author 作者 zuoruibo:
 * @date 创建时间：2020年11月16日 下午5:50:00
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class Person implements Serializable {
	private static final long serialVersionUID = -6112847285691942529L;

	private String id;
	private String name;
	private Integer age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getAge()=" + getAge() + "]";
	}

	public Person() {
		super();
	}

	public Person(String id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

}
