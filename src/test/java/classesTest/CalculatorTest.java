package classesTest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.Calculator;

//@RunWith(JUnitParamsRunnner.class)
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
	
	@Test(expected=ArithmeticException.class)
	public void testDiv() {
		
		Calculator c = new Calculator();
		
		c.setOperandsInMemory(100, 0);
		
		c.div();
		
	}
	
	private static final Object[] getMulResults() {
		
		return new Object[] {
				
				new Object[] { 10, 10 , 100 },
				
				new Object[] { 2 , 10 , 20  } ,
				
				new Object[] { 30 , 5 , 150 } 
				
		};
		
	}
	
	//@Test
	/*@Parameters({
		"10,10,10",
		"10,10,10"
	})*/
	public void testMul(int op1, int op2, int result) {
		
		Calculator c = new Calculator();
		
		c.setOperandsInMemory(op1,op2);
		
		assertThat("Resultados MUL", c.mul() , equalTo(result) );
		
	}
	
}
