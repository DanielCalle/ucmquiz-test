package classes;

public class Calculator implements Areas {

	private int operand1, operand2;
	
	public Calculator() {}
	
	public Calculator(int op1, int op2) {
		this.operand1 = op1;
		this.operand2 = op2;
	}
	
	public void setOperandsInMemory(int op1, int op2) {
		this.operand1 = op1;
		this.operand2 = op2;
	}
	
	public int add() {
		return this.operand1 + this.operand2;
	}
	
	public Integer badCast() {
		return null;
	}
	
	public int seconGradeEcuationFirstSolution(int a, int b, int c) {
		
		int sqrtInside = (int) (Math.pow(b, 2) - 4 * a * c);
		
		int sqrtResult = (int) Math.sqrt(sqrtInside);
		
		int finalSolution = ( (-b) + sqrtResult ) / (2 * a); 
		
		return finalSolution;
	
	}
	
	public int seconGradeEcuationSecondSolution(int a, int b, int c) {
		
		int sqrtInside = (int) (Math.pow(b, 2) - 4 * a * c);
		
		int sqrtResult = (int) Math.sqrt(sqrtInside);
		
		int finalSolution = ( (-b) - sqrtResult ) / (2 * a); 
		
		return finalSolution;
	
	}
	
	public int div() {
		
		return operand1 / operand2;
		
	}
	
	public int mul() {
		
		return operand1 * operand2;
		
	}
	
	public double circleArea(double r) {
		return Math.PI * Math.pow(r, 2);
	}

}
