package edu.cqut.hr.service.impl;

import java.util.Date;
import java.util.List;

import edu.cqut.hr.dao.TeacherDao;
import edu.cqut.hr.dao.impl.TeacherDaoImpl;
import edu.cqut.hr.entity.Teacher;
import edu.cqut.hr.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	@Override
	public boolean create(Teacher teacher) {
		teacherDao.create(teacher);
		return true;
	}

	@Override
	public boolean remove(Integer id) {
		teacherDao.remove(id);
		return true;
	}

	@Override
	public boolean update(Integer oldId, Integer id, String name, Float salary, String sex, Date birthday,
			String college, String major) {
		teacherDao.update(oldId, id, name, salary, sex, birthday, college, major);
		return true;
	}

	@Override
	public List<Teacher> findAllTeachers() {
		return teacherDao.select();
	}
	
}