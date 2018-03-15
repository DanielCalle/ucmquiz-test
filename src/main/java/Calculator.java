
public class Calculator {

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

}
