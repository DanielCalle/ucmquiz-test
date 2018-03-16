package classes;

public class CalculatorWithInterface implements Areas {

	@Override
	public double circleArea(double r) {
		return Math.PI * Math.pow(r, 2);
	}

}
