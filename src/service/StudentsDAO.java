package service;

import java.util.List;

import entity.Students;

//学生的业务逻辑
public interface StudentsDAO {

	//查询所有学生
	public List<Students> queryAllStudents();
	//根据学号查询
	public Students queryStudentsBySid(String sid);
	//增加学生
	public boolean addStudents(Students s);
	//更新学生
	public boolean updateStudents(Students s);
	//删除学生
	public boolean deleteStudents(String sid);
}
