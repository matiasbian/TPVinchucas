import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Vinchucas.Bajo;
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
		usuario = mock(Usuario.class);
		ubicacion1 = new Ubicacion();
		
	}
	
	@Test
	void testVerificoFotoVinchuca() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals("vinchuca.bmp", muestra1.fotoVinchuca());
	}
	@Test
	void testTipoVinchucaFotografiada() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals(Vinchuca.Vinchuca, muestra1.tipoVinchucaFotog());
	}
	
	@Test
	void testFotoVinchucaFotografiada() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals("vinchuca.bmp", muestra1.fotoVinchuca());
	}
	
	@Test
	void testAliasUsuario() {
		usuario = mock(Usuario.class);
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		when(usuario.getAlias()).thenReturn("MatiBian");
		assertEquals("MatiBian", muestra1.aliasUsuario());
	}
	
	@Test
	void testUbicacionVinchuca() {
		ubicacion1 = mock(Ubicacion.class);
		when(ubicacion1.getLatitud()).thenReturn(150);
		when(ubicacion1.getLongitud()).thenReturn(300);
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals(muestra1.ubicacion().getLatitud(), 150);
		assertEquals(muestra1.ubicacion().getLongitud(), 300);
	}
	
	@Test
	void testNivelVerificacionBajo() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals(Bajo.class, muestra1.getNivelVerificacion().getClass());
	}

}
