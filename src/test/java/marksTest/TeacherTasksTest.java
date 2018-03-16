package marksTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import Marks.Student;
import Marks.StudentBuilder;
import Marks.StudentDAO;
import Marks.TeacherTasks;

@RunWith(MockitoJUnitRunner.class)
public class TeacherTasksTest {

	private Student student;
	private ArrayList<Student> students;

	@InjectMocks
	private TeacherTasks teacherTasks;

	@Mock
	private StudentDAO studentDAO;
	
	@Before
	public void preparations() {
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
	
}
