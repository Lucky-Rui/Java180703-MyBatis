package com.situ.mybatis.dao.impl;

import java.util.List;

import com.situ.mybatis.dao.IStudentDao;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.vo.SearchVO;
import com.situ.mybatis.vo.StudentSearchCondition;

public class StudnetDaoImpl implements IStudentDao{

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByCondition(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByIdArray(int[] idArray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByIdList(List<Integer> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByConditionChoose(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotalCount(StudentSearchCondition studentSearchCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findPageBeanListByCondition(StudentSearchCondition studentSearchCondition, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

}
