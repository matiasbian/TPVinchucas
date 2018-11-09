import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Muestra;
import Vinchucas.Participante;
import Vinchucas.Verificacion;

class TestVerificacion {
	Participante p;
	Muestra m;
	Muestra.Vinchuca tv;
	Verificacion v;
	@Test
	void testNivelVerificacion() {
		p = Mockito.mock(Participante.class);
		m = Mockito.mock(Muestra.class);
		Mockito.when(m.tipoVinchucaFotog()).thenReturn(Muestra.Vinchuca.ChincheFoliada);
		tv = Muestra.Vinchuca.ChincheFoliada;
		Mockito.when(p.calidadValoracion()).thenReturn(1);
		v = new Verificacion(p, m, tv);
		assertEquals(v.nivelVerif(),1);
	}
	

}
