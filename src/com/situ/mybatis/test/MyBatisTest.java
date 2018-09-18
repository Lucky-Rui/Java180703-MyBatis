package com.situ.mybatis.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.situ.mybatis.dao.IStudentDao;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.service.IStudentService;
import com.situ.mybatis.service.impl.StudentServiceImpl;
import com.situ.mybatis.util.MyBatisUtil;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.SearchVO;
import com.situ.mybatis.vo.StudentSearchCondition;

public class MyBatisTest {

	@Test
	public void testFindById() throws IOException {
		// 创建SqlSession,调用封装好的工具类
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 执行sql语句
		Student student = sqlSession.selectOne("student.findById", 56);
		System.out.println(student);
	}

	@Test
	public void testList() throws IOException {
		// 创建SqlSession,调用封装好的工具类
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 执行sql语句
		List<Student> list = sqlSession.selectList("student.list");
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testFindByName() throws IOException {
		// 创建SqlSession,调用封装好的工具类
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 执行sql语句
		List<Student> list = sqlSession.selectList("student.findByName", 77);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testUpdateById() throws IOException {
		// 创建SqlSession,调用封装好的工具类
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 执行sql语句
		Student student = new Student(56, "zhangsan", 2, "2", 2);
		Integer count = sqlSession.update("student.updateStudent", student);
		System.out.println(count);
		// 更新类需要手动提交
		sqlSession.commit();
		// 手动关闭（可略）
		sqlSession.close();
	}

	@Test
	public void testInsert() throws IOException {
		// 创建SqlSession,调用封装好的工具类
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 执行sql语句
		Student student = new Student("www", 4, "1");
		Integer count = sqlSession.insert("student.insert", student);
		System.out.println(count);
		// 更新类需要手动提交
		sqlSession.commit();
		// 手动关闭（可略）
		sqlSession.close();
	}

	@Test
	public void testDeleteById() throws IOException {
		// 创建SqlSession,调用封装好的工具类
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 执行sql语句
		Integer count = sqlSession.delete("student.deleteById", 69);
		System.out.println(count);
		// 更新类需要手动提交（必须有）
		sqlSession.commit();
		// 手动关闭（可略）
		sqlSession.close();
	}

	// @Test
	// public void testFindBySearchVO() throws IOException {
	// SqlSession sqlSession = MyBatisUtil.getSqlSession();
	// SearchVO searchVO = new SearchVO();
	// Student student = new Student("77", 10, "男", 2);
	// searchVO.setStudent(student);
	// List<Student> list = sqlSession.selectList("student.findBySearchVO",
	// searchVO);
	// for (Student stu : list) {
	// System.out.println(stu);
	// }
	// }

	@Test
	public void testFindByPage() throws IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		Map<String, Object> map = new HashMap<>();
		map.put("offset", 2);
		map.put("pageSize", 3);
		List<Student> list = sqlSession.selectList("student.findByPage", map);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	// 用mapper动态代理的开发方式就不需要写StudentDaoImpl
	@Test
	public void testFindByIdMapperDemo() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// IStudentDao studentDao = new StudentDaoImpl();
		// 用mapper动态代理的开发方式就不需要写StudentDaoImpl
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		Student student = studentDao.findById(59);
		System.out.println(student);
	}

	@Test
	public void testFindByCondition() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		SearchVO searchVO = new SearchVO();
		// searchVO.setName("7");
		searchVO.setAge(23);
		// searchVO.setGender("q");
		List<Student> list = studentDao.findByCondition(searchVO);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testUpdateStudent() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		Student student = new Student();
		student.setId(58);
		student.setName("www");
		student.setAge(2);
		student.setGender("2");
		Integer count = studentDao.updateStudent(student);
		sqlSession.commit();
		System.out.println(count);
		sqlSession.close();
	}

	@Test
	public void testFindByIdArray() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		int[] idArray = { 78, 58, 59 };
		List<Student> list = studentDao.findByIdArray(idArray);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testFindByIdList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		List<Integer> idList = new ArrayList<>();
		idList.add(58);
		idList.add(59);
		List<Student> list = studentDao.findByIdList(idList);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testFindByConditionChoose() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		SearchVO searchVO = new SearchVO();
		// searchVO.setAge(2);
		searchVO.setName("7");
		searchVO.setGender("男");
		List<Student> list = studentDao.findByConditionChoose(searchVO);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testGetPageBean() {
		IStudentService studentService = new StudentServiceImpl();
		StudentSearchCondition studentSearchCondition = new StudentSearchCondition();
		studentSearchCondition.setPageNo(1);
		studentSearchCondition.setPageSize(3);
		studentSearchCondition.setName("7");
		PageBean<Student> pageBean = studentService.getPageBean(studentSearchCondition);
		System.out.println(pageBean);
	}

}
