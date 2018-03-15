import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		
		Calculator c = new Calculator();
		
		c.setOperandsInMemory(10, 20);
		
		assertTrue("La suma deberia ser 30", c.add() == 30 );
		
	}
	
	@Test
	public void testSub() {
		
		fail("Esta funcionalidad aun no ha sido implementada.");
		
	}
	
	@Test
	public void testBadCast() {
		
		Calculator c = new Calculator();
		
		assertNull(c.badCast());
		
	}

	
	
}
