package marksTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Marks.Student;
import Marks.StudentDAO;
import Marks.TeacherTasks;

public class TeacherTasksTest2 {

	private Student student;
	private ArrayList<Student> students;

	@InjectMocks
	private TeacherTasks teacherTasks;

	@Mock
	private StudentDAO studentDAO;
	
	@Before
	public void preparations() {
		MockitoAnnotations.initMocks(this);
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
	
	// Spy
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSpyException() {
		ArrayList<Student> twoStudents = Mockito.spy(students);

	    when(twoStudents.get(2)).thenReturn(student);

	    assertEquals(student, twoStudents.get(2));
	}
	
	@Test
	public void testSpyNoException() {
		ArrayList<Student> twoStudents = Mockito.spy(students);
	    twoStudents.add(new Student());
	    
	    when(twoStudents.get(2)).thenReturn(student);
	    
	    assertEquals(student, twoStudents.get(2));
	}
	
	@Test
	public void testSpyForce() {
		ArrayList<Student> twoStudents = Mockito.spy(students);
	    twoStudents.add(new Student());
	    
	    doReturn(student).when(twoStudents).get(2);
	    
	    assertEquals(student, twoStudents.get(2));
	}
	
}

