package com.situ.mybatis.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.situ.mybatis.dao.IStudentDao;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.service.IStudentService;
import com.situ.mybatis.until.MyBatisUtil;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.StudentSearchCondition;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao studentDao = null;
	
	public StudentServiceImpl() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@Override
	public PageBean<Student> getPageBean(StudentSearchCondition studentSearchCondition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageNo(studentSearchCondition.getPageNo());
		pageBean.setPageSize(studentSearchCondition.getPageSize());
		// 总记录数（是符合condition条件的总记录数）
		int totalCount = studentDao.getTotalCount(studentSearchCondition);
		pageBean.setTotalCount(totalCount);
		// 一共有多少页
		int totalPage = (int) Math.ceil((double) totalCount / studentSearchCondition.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 得到当前页的数据
		int offset = (studentSearchCondition.getPageNo() - 1) * studentSearchCondition.getPageSize();
		List<Student> list = studentDao.findPageBeanListByCondition(studentSearchCondition, offset);
		pageBean.setList(list);

		return pageBean;
	}

}
