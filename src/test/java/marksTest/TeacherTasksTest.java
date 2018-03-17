package marksTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import marks.Student;
import marks.StudentDAO;
import marks.TeacherTasks;

@RunWith(MockitoJUnitRunner.class)
public class TeacherTasksTest {

	@Mock
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
	
	@Test // matchers
	public void testShowMarkGivenStudent() {
		student = student
			.setName("nekomamushi")
			.setSurname("cat viper")
			.setGender(true)
			.addMark("Dibujo Tecnico", 0)
			.addMark("Lengua", 5)
			.addMark("Matematicas", 8)
			.addMark("Tecnologia", 7)
			.addMark("Educacion Fisica", 10)
			.build();
		when(studentDAO.read(anyInt())).thenReturn(student);
		teacherTasks.showMark(2);
		verify(studentDAO, times(1)).read(anyInt());
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = NullPointerException.class)
	public void testThrowException() {
		when(studentDAO.read(anyInt())).thenThrow(NullPointerException.class);
		teacherTasks.showMark(2);
	}
}
