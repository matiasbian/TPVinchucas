import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Vinchucas.Muestra;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.Ubicacion;
import Vinchucas.Usuario;

import static org.mockito.Mockito.*;

class TestMuestras {
	Muestra muestra1;
	Ubicacion ubicacion1;
	Usuario usuario ;
	@Before
	void Init() {
		
		
	}
	
	@Test
	void testVerificoFotoVinchuca() {
		usuario = new Usuario();
		ubicacion1 = new Ubicacion();
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals("vinchuca.bmp", muestra1.fotoVinchuca());
	}

}
