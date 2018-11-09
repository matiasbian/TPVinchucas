import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Vinchucas.Ubicacion;

class testUbicacion {
	Ubicacion u1;
	@Before
	void SetUp() {
		
	}
	@Test
	void testGetLatitud() {
		u1 = new Ubicacion(150,200);
		assertEquals(u1.latitud(),150);
	}
	
	@Test
	void testGetLongitud() {
		u1 = new Ubicacion(150,200);
		assertEquals(u1.longitud(),200);
	}

}
