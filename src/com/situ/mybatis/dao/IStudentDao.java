package com.situ.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.vo.SearchVO;
import com.situ.mybatis.vo.StudentSearchCondition;

public interface IStudentDao {
	// 接口的方法要与StudentMapper.xml里的方法一致
	// StudentMapper.xml的命名空间要绑定这个接口
	List<Student> list();

	Student findById(Integer id);

	List<Student> findByCondition(SearchVO searchVO);

	Integer updateStudent(Student student);

	List<Student> findByIdArray(int[] idArray);
	
	List<Student> findByIdList(List<Integer> idList);
	
 	List<Student> findByConditionChoose(SearchVO searchVO);

	Integer getTotalCount(StudentSearchCondition studentSearchCondition);

	List<Student> findPageBeanListByCondition(@Param("studentSearchCondition")StudentSearchCondition studentSearchCondition, @Param("offset")Integer offset);
}
