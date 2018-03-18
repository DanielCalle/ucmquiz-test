package classesTest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import classes.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

	@BeforeClass
	public static void beforeTestBeguin() {
		
		System.out.println("ESTO SE EJECUTA SOLO UNA VEZ ANTES DE TODAS LAS PRUEBAS");
		
	}
	
	@AfterClass
	public static void afterTestEnd() {
		
		System.out.println("ESTO SE EJECUTA SOLO UNA VEZ DESPUES DE TODAS LAS PRUEBAS");
		
	}
	
	@Before
	public void beforeEvaluateEachUnit() {
		
		System.out.println("ESTO SE EJECUTA ANTES DE CADA PRUEBA");
		
	}
	
	@After
	public void afterEvaluateEachUnit() {
		
		System.out.println("ESTO SE EJECUTA DESPUES DE CADA PRUEBA");
		
	}
	
	@Test
	public void testAdd() {

		Calculator c = new Calculator();
		
		c.setOperandsInMemory(10, 20);
		
		assertTrue("La suma deberia ser 30", c.add() == 30 );
		
	}
	
	@Ignore("Este metodo no es evaluado, de lo contrario produce fallos.")
	@Test
	public void testSub() {
		
		fail("Esta funcionalidad aun no ha sido implementada.");
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDiv() {
		
		Calculator c = new Calculator();
		
		c.setOperandsInMemory(100, 0);
		
		c.div();
		
	}
	
	@Test
	@Parameters({
		"10,2,20",
		"3,5,15",
		"9,3,27"
	})
	public void testMul(int op1, int op2, int result) {
		
		Calculator c = new Calculator();
		
		c.setOperandsInMemory(op1,op2);
		
		assertThat("Resultados MUL", c.mul() , equalTo(result) );
		
	}
	
	@Test
	public void testBadCast() {
		
		Calculator c = new Calculator();
		
		assertNull(c.badCast());
		
	}
	
	@Test
	public void testSeconGradeEcuationFisrtSolution() {
		
		Calculator c = new Calculator();
	
		assertThat( c.seconGradeEcuationFirstSolution(1, -5, 6) , equalTo(3) );
		
	}
	
	@Test
	public void testSeconGradeEcuationSecondSolution() {
		
		Calculator c = new Calculator();
	
		assertThat( c.seconGradeEcuationSecondSolution(1, -5, 6) > 0 , equalTo(true) );
	
		assertThat("Comprobacion del resultado", c.seconGradeEcuationSecondSolution(1, -5, 6) , equalTo(2) );
		
	}
	
	@Test
	public void testInternalIntegrationTest() {
		
		Calculator c = new Calculator(3,5);
		
		int sol1 = c.add();
		
		assertEquals(sol1,8);
		
		c.setOperandsInMemory(6, 3);
		
		int sol2 = c.div();
		
		assertEquals(sol2,2);
		
		c.setOperandsInMemory(sol1, sol2);
		
		int sol3 = c.mul();
		
		assertEquals(sol3,16);
		
		assertEquals(c.seconGradeEcuationFirstSolution(sol1, sol2, sol3),0);
		
	}
	
}
