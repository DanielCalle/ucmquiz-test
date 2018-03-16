package Marks;

import java.util.Date;

public class StudentBuilder {
	
	private Student student;
	
	public StudentBuilder() {
		student = new Student();
	}
	
	public StudentBuilder addName(String name) {
		student.setName(name);
		return this;
	}

	public StudentBuilder addSurname(String surname) {
		student.setSurname(surname);
		return this;
	}
	
	public StudentBuilder addBirthDay(Date birthDay) {
		student.setBirthDay(birthDay);
		return this;
	}
	
	public StudentBuilder addGender(boolean gender) {
		student.setGender(gender);
		return this;
	}
	
	public StudentBuilder addNationality(String nationality) {
		student.setNationality(nationality);
		return this;
	}
	
	public StudentBuilder addGrade(int grade) {
		student.setGrade(grade);
		return this;
	}
	
	public StudentBuilder addMark(String subject, Integer mark) {
		student.addMark(subject, mark);
		return this;
	}
	
	public Student build() {
		student.setId(student.getId() + 1);
		return student;
	}
}
