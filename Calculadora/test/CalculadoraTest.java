import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	private Calculadora c;
	
	@Before
	public void setUp() {
		c=new Calculadora();
		System.out.println("Se ha llamado al setUp");
	}
	
	@Test
	public void testSumar() {
		assertEquals(12,c.sumar(8, 4));
		
	}
	@Test
	public void testRestar() {
		assertEquals(4,c.restar(8, 4));
	}
	@Test
	public void testMultiplicar() {
		assertEquals(32,c.multiplicar(8, 4));
	}
	@Test
	public void testEsPar() {
		assertTrue(c.esPar(6));
		assertFalse(c.esPar(7));
	}
	@Test
	public void testCuadrado() {
		assertEquals(25.0, c.cuadrado(5),0.000001);
	}
}
