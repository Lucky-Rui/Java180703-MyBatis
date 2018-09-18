package com.situ.mybatis.vo;

import com.situ.mybatis.entity.Student;

public class SearchVO {
/*	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "SearchVO [student=" + student + "]";
	}*/
	
	private String name;
	private Integer age;
	private String gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "SearchVO [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	 

}
