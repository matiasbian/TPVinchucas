import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Muestra;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.Participante;
import Vinchucas.Verificacion;

class TestVerificacion {
	Participante p;
	Muestra m;
	Muestra.Vinchuca tv;
	Verificacion v;
	
	@BeforeEach
	void SetUp() {
		p = Mockito.mock(Participante.class);
		m = Mockito.mock(Muestra.class);
		Mockito.when(m.tipoVinchucaFotog()).thenReturn(Muestra.Vinchuca.ChincheFoliada);
		tv = Muestra.Vinchuca.ChincheFoliada;
		Mockito.when(p.calidadValoracion()).thenReturn(1);
		v = new Verificacion(p, m, tv);
	}
	
	@Test 
	void getParticipante(){
		Participante p2 = p;
		v.setParticipante(p2);
		assertEquals(v.getParticipante(),p2);
	}
	
	@Test
	void setGetMuestra() {
		Muestra m2 = Mockito.mock(Muestra.class);
		v.setMuestra(m2);
		assertEquals(v.getMuestra(), m2);
	}
	
	@Test
	void setGetVinchucaDetectada() {
		v.setVinchucaDetectada(Vinchuca.ImagenPocoClara);
		assertEquals(v.getVinchucaDetectada(),Vinchuca.ImagenPocoClara);
	}
	
	@Test
	void getDate() {
		Date d = new Date();
		assertEquals(v.getDate().getClass(),d.getClass());
	}
	
	@Test
	void testNivelVerificacion() {
		assertEquals(v.nivelVerif(),1);
	}
	

}
