package edu.cqut.hr.service;

import java.util.Date;
import java.util.List;

import edu.cqut.hr.entity.Teacher;

public interface TeacherService {
	//����
	boolean create(Teacher teacher );
	//ɾ��
	boolean remove(Integer id);
	//����
	boolean update(Integer oldId, Integer id, String name, Float salary, String sex, Date birthday, String college, String major);
	//��ѯ
	List<Teacher> findAllTeachers();
}
