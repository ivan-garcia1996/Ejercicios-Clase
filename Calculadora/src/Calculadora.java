
public class Calculadora implements ICalculadora{

	@Override
	public int sumar(int a, int b) {
		return a+b;
	}

	@Override
	public int restar(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplicar(int a, int b) {
		return a*b;
	}

	@Override
	public boolean esPar(int a) {
		return a % 2 == 0;
		
	}
	@Override
	public double cuadrado(int a) {
		return Math.pow(a,2);
	}
		
}
