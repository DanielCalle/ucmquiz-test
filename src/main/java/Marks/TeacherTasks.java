package Marks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TeacherTasks {
	
	private StudentDAO studentDAO;
	
	public TeacherTasks() {
		setStudentDAO(new StudentDAO());
	}
	
	public ArrayList<String> getOrderedNames() {
		ArrayList<Student> students = studentDAO.readAll();
		ArrayList<String> names = new ArrayList<String>();
		for (Student student : students) {
			names.add(student.getName());
		}
		Collections.sort(names);
		return names;
	}
	
	public float getStudentAverage(Student student) {
		HashMap<String, Integer> marks = student.getMarks();
		if (marks == null || marks.size() == 0) return -1;
		else {
			Integer sum = 0;
			for (Integer mark : marks.values()) {
				sum += mark;
			}
			return sum / marks.size();
		}
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
}
