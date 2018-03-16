package marksTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Marks.Student;
import Marks.StudentDAO;
import Marks.TeacherTasks;

public class TeacherTasksTest3 {

	private Student student;
	private ArrayList<Student> students;
	private TeacherTasks teacherTasks;
	private StudentDAO studentDAO;
	
	@Before
	public void preparations() {
		studentDAO = Mockito.mock(StudentDAO.class);
		teacherTasks = new TeacherTasks();
		teacherTasks.setStudentDAO(studentDAO);
		student = new Student();
		students = new ArrayList<Student>();
		students.add(student.setName("zunisha").build());
		students.add(student.setName("nekomamushi").build());
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testSortNullList() {
		when(studentDAO.readAll()).thenReturn(null);
		teacherTasks.getOrderedNames();
	}
	
	
	@Test
	public void testSortList() {
		when(studentDAO.readAll()).thenReturn(students);
		ArrayList<String> names = teacherTasks.getOrderedNames();
		assertEquals("zunisha", names.get(1));
		assertEquals("nekomamushi", names.get(0));
	}
	
	@Test // Mock in mock
	public void testShowMarkGivenStudentAndFalseMarks() {
		student = Mockito.mock(Student.class);

		HashMap<String, Integer> marks = new HashMap<String, Integer>();
		marks.put("Dibujo Tecnico", 0);
		marks.put("Lengua", 5);

		when(studentDAO.read(anyInt())).thenReturn(student);
		when(student.getMarks()).thenReturn(marks);
		teacherTasks.showMark(2);
		verify(studentDAO, times(1)).read(anyInt());
		verify(student, times(1)).getMarks();
	}
	
}

