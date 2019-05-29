package edu.cqut.hr.dao;

import java.util.Date;
import java.util.List;

import edu.cqut.hr.entity.Teacher;

public interface TeacherDao {
	
	//增加
	void create(Teacher teacher );
	//删除
	public void remove(Integer id);
	//更新
	public void update(Integer oldId, Integer id, String name, Float salary, String sex, Date birthday, String college, String major);
	//查询
	public List<Teacher> select();
	
}
