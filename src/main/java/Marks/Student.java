package Marks;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Student {
	
	private int id;
	private String name;
	private String surname;
	private Date birthDay;
	private boolean gender;
	private String nationality;
	private int grade;
	private HashMap<String, Integer> marks;
	
	public Student() {
		id = 0;
		name = "no_name";
		surname = "no_surname";
		birthDay = new GregorianCalendar().getTime();
		gender = true;
		nationality = "Spain";
		grade = 3;
		marks = new HashMap<String, Integer>();
	}
	
	public Student(int id, String name, String surname, Date birthDay, boolean gender, String nationality, int grade, HashMap<String, Integer> marks) {
		setId(id);
		setName(name);
		setSurname(surname);
		setBirthDay(birthDay);
		setGender(gender);
		setNationality(nationality);
		setGrade(grade);
		setMarks(marks);
	}

	public int getId() {
		return id;
	}

	public Student setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Student setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public Student setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public boolean isGender() {
		return gender;
	}

	public Student setGender(boolean gender) {
		this.gender = gender;
		return this;
	}

	public String getNationality() {
		return nationality;
	}

	public Student setNationality(String nationality) {
		this.nationality = nationality;
		return this;
	}

	public int getGrade() {
		return grade;
	}

	public Student setGrade(int grade) {
		this.grade = grade;
		return this;
	}

	public HashMap<String, Integer> getMarks() {
		return marks;
	}
	
	public Student setMarks(HashMap<String, Integer> marks) {
		this.marks = marks;
		return this;
	}

	public Student addMark(String subject, Integer mark) {
		this.marks.put(subject, mark);
		return this;
	};
	
	public Student build() {
		id += 1;
		return new Student(id, name, surname, birthDay, gender, nationality, grade, marks);
	}
	
	public String toString() {
		return (name + " " + surname + " " + birthDay.toString() + " " + (gender ? "M" : "F") + " " + nationality + " " + grade);
	}

}
