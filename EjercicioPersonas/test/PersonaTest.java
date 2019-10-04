import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void testGetNombre() {
		Persona p=new Persona("Iván", "García");
		assertEquals("Iván",p.getNombre());
	}
	
	@Test
	public void testGetApellido() {
		Persona p=new Persona("Iván", "García");
		assertEquals("García",p.getApellido());
	}
	
	@Test
	public void testGetNombreCompleto() {
		Persona p=new Persona("Iván", "García");
		assertEquals("García, Iván",p.getNombreCompleto());
	}
	
}
