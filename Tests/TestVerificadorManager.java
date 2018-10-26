import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Vinchucas.Verificacion;
import Vinchucas.VerificadorManager;
import Vinchucas.VerificadorManager.Nivel;

import static org.mockito.Mockito.*;

class TestVerificadorManager {
	
	
	VerificadorManager verificador;
	Verificacion verif1,verif2,verif3;
	@Before
	void init() {
		
		
	}
	@Test
	void testNivelVerificacionAlto() {
		verificador = new VerificadorManager();
		verif1 = mock(Verificacion.class);
		verif2 = mock(Verificacion.class);
		verif3 = mock(Verificacion.class);
		when(verif1.resultadoVerif()).thenReturn(1);
		when(verif2.resultadoVerif()).thenReturn(3);
		when(verif3.resultadoVerif()).thenReturn(0);
		
		verificador.agregarVerificacion(verif1);
		
		verificador.agregarVerificacion(verif2);
		
		verificador.agregarVerificacion(verif3);
		assertEquals(verificador.nivelVerificacion(),Nivel.Alto);
	}
	@Test
	void testNivelVerificacionMedio() {
		verificador = new VerificadorManager();
		verif1 = mock(Verificacion.class);
		verif2 = mock(Verificacion.class);
		verif3 = mock(Verificacion.class);
		when(verif1.resultadoVerif()).thenReturn(1);
		when(verif2.resultadoVerif()).thenReturn(1);
		when(verif3.resultadoVerif()).thenReturn(0);
		verificador.agregarVerificacion(verif1);
		
		verificador.agregarVerificacion(verif2);
		
		verificador.agregarVerificacion(verif3);
		assertEquals(verificador.nivelVerificacion(),Nivel.Medio);
	}
	@Test
	void testNivelVerificacionBajo() {
		verificador = new VerificadorManager();
		verif1 = mock(Verificacion.class);
		verif2 = mock(Verificacion.class);
		verif3 = mock(Verificacion.class);
		when(verif1.resultadoVerif()).thenReturn(1);
		when(verif2.resultadoVerif()).thenReturn(0);
		when(verif3.resultadoVerif()).thenReturn(0);
		verificador.agregarVerificacion(verif1);
		
		verificador.agregarVerificacion(verif2);
		
		verificador.agregarVerificacion(verif3);
		assertEquals(verificador.nivelVerificacion(),Nivel.Bajo);
	}

}
