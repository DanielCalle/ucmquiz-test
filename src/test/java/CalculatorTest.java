import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import static org.hamcrest.Matchers.*;



public class CalculatorTest {

	@Test
	public void testAdd() {
		
		Calculator c = new Calculator();
		
		c.setOperandsInMemory(10, 20);
		
		assertTrue("La suma deberia ser 30", c.add() == 30 );
		
	}
	
	@Test
	public void testSub() {
		
		// fail("Esta funcionalidad aun no ha sido implementada.");
		
	}
	
	@Test
	public void testBadCast() {
		
		Calculator c = new Calculator();
		
		assertNull(c.badCast());
		
	}
	
	@Test
	public void testSeconGradeEcuationFisrtSolution() {
		
		Calculator c = new Calculator();
	
		assertThat( c.seconGradeEcuationFirstSolution(1, -5, 6) , is(equalTo(3)) );
		
	}
	
	@Test
	public void testSeconGradeEcuationSecondSolution() {
		
		Calculator c = new Calculator();
	
		assertThat( c.seconGradeEcuationSecondSolution(1, -5, 6) > 0 , is(true));
	
		assertThat("Comprobacion del resultado", c.seconGradeEcuationSecondSolution(1, -5, 6) , is(equalTo(2)) );
		
	}

}
