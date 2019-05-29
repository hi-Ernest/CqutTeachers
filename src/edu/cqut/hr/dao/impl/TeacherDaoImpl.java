package edu.cqut.hr.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cqut.hr.dao.DBUtil;
import edu.cqut.hr.dao.TeacherDao;
import edu.cqut.hr.entity.Teacher;


public class TeacherDaoImpl implements TeacherDao{
	private static DBUtil dbu;
	
	/**
	 * ������ʦ�ļ�¼
	 * @param teacher
	 */
	public void create(Teacher teacher )
	{
		Date birthday = new java.sql.Date(teacher.getBirthday().getTime());
		String sql = "insert into teacher (id,name,salary,sex,birthday,college,major) values("
						+teacher.getId()+",'"+teacher.getName()+"',"+teacher.getSalary()+",'"
				+teacher.getSex()+"','"+birthday+"','"+teacher.getCollege()+"','"+teacher.getMajor()+"')";
		
		try {
			System.out.println(sql);
			DBUtil.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ɾ��ָ��id��ʦ�ļ�¼
	 * @param id
	 */
	public void remove(Integer id)  
	{
		String sql = "delete from teacher where id ="+id;
		try {
			System.out.println(sql);
			DBUtil.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ɾ��ָ��id��ʦ�ļ�¼ 
	 * @param id
	 */
	public void delete(Integer id)
	{
		String sql = "delete from teacher where id = "+ id;
		Statement stmt = (Statement) dbu.getStatement();
		try {
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ���±��ָ����¼
	 * @param oldId
	 * @param id
	 * @param name
	 * @param salary
	 */
	public void update(Integer oldId, Integer id, String name, Float salary, String sex, java.util.Date birthday, String college, String major)
	{
		Date bdate = new java.sql.Date(birthday.getTime());
		String sql ="update teacher set id = "+id+",name = '"+name+"',"
						+ "salary = "+salary+",sex = '"+sex+"',birthday = '"+bdate+"'"+
							",college = '"+college+"',major = '"+major+ "'"
									+ " where id = "+oldId;
		try {
			System.out.println(sql);
			DBUtil.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��ѯ����ȫ����Ϣ
	 */
	public List<Teacher> select()   
	{

        System.out.println("11111");

		String sql = "select * from teachers";


		Statement stmt = (Statement) dbu.getStatement();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		List<Teacher> teacherList = new ArrayList();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setSalary(rs.getFloat("salary"));
				teacher.setSex(rs.getString("sex"));
		
				
				teacher.setBirthday(rs.getDate("birthday"));
				teacher.setCollege(rs.getString("college"));
				teacher.setMajor(rs.getString("major"));
				teacherList.add(teacher);

                System.out.println(teacher.toString());
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherList;
	}
}
