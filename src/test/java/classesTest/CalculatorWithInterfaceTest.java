package classesTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import classes.Areas;
import classes.CalculatorWithInterface;

public class CalculatorWithInterfaceTest {

	@Category(Areas.class)
	@Test
	public void testCircleArea() {
		
		CalculatorWithInterface c = new CalculatorWithInterface();
		
		System.out.println(c.circleArea(10));
		
	}
	
	@Test
	public void testRectangleArea() {
		Integer a = 2;
		Integer b = 1 + 1;
		assertEquals(a, b);
	}

}
