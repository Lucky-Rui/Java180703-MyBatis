package com.situ.mybatis.service;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.StudentSearchCondition;

public interface IStudentService {
	
	PageBean<Student> getPageBean(StudentSearchCondition studentSearchCondition);
}
