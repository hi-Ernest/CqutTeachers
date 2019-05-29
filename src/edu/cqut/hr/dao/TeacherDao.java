package edu.cqut.hr.dao;

import java.util.Date;
import java.util.List;

import edu.cqut.hr.entity.Teacher;

public interface TeacherDao {
	
	//����
	void create(Teacher teacher );
	//ɾ��
	public void remove(Integer id);
	//����
	public void update(Integer oldId, Integer id, String name, Float salary, String sex, Date birthday, String college, String major);
	//��ѯ
	public List<Teacher> select();
	
}
