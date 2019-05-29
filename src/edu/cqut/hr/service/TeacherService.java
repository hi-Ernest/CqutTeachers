package edu.cqut.hr.service;

import java.util.Date;
import java.util.List;

import edu.cqut.hr.entity.Teacher;

public interface TeacherService {
	//增加
	boolean create(Teacher teacher );
	//删除
	boolean remove(Integer id);
	//更新
	boolean update(Integer oldId, Integer id, String name, Float salary, String sex, Date birthday, String college, String major);
	//查询
	List<Teacher> findAllTeachers();
}
