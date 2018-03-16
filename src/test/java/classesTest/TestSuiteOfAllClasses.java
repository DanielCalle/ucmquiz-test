package classesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import marksTest.TeacherTasksTest;

@RunWith(Suite.class)
@SuiteClasses({ CalculatorTest.class , TeacherTasksTest.class })
public class TestSuiteOfAllClasses {}