import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Muestra;
import Vinchucas.NivelParticipante;
import Vinchucas.Participante;
import Vinchucas.ParticipanteBasico;
import Vinchucas.ParticipanteExperto;
import Vinchucas.Verificacion;

class TestParticipante {
	NivelParticipante n1,n2;
	Participante p;
	Muestra m1,m2,m3;
	Verificacion v1,v2,v3;
	@BeforeEach
	void Init() {
		n1 = new ParticipanteBasico();
		
	}
	@Test
	void testNickName() {
		p = new Participante("Joako221",n1);
		assertEquals(p.nickName(),"Joako221");
	}
	
	
	
	@Test
	void testAddMuestras() {
		p = new Participante("Joako221",n1);
		m1 = Mockito.mock(Muestra.class);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		p.addMuestra(m1);
		p.addMuestra(m2);
		p.addMuestra(m3);
		assertEquals(p.getMuestras().size(), 3);
	}
	
	@Test
	void testAddVerificaciones() {
		p = new Participante("Joako221",n1);
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		p.addVerificacion(v1);
		p.addVerificacion(v2);
		p.addVerificacion(v3);
		assertEquals(p.getVerificaciones().size(), 3);
	}
	
	@Test
	void tesCalidadValoracionNovato() {
		n1 = new ParticipanteBasico();
		p = new Participante("Joako221",n1);
		assertEquals(p.calidadValoracion(),1);
	}
	
	@Test
	void tesCalidadValoracionExperto() {
		n2 = new ParticipanteExperto();
		p = new Participante("Joako221",n2);
		assertEquals(p.calidadValoracion(),3);
	}
	

	@Test
	void verificoName(){
		p = new Participante("Joako221",n1);
		assertEquals("Joako221", p.nickName());
	}
	
	@Test
	void verificoNConocimientoDeBasico (){
		p = new Participante("NoName", new ParticipanteBasico());
		assertEquals(ParticipanteBasico.class, p.nConocimiento().getClass());
	}
	
	@Test
	void verificoNConocimientoDeExperto (){
		Participante p2 = new Participante("JOSE221", new ParticipanteExperto());
		assertEquals(new ParticipanteExperto().getClass(), p2.nConocimiento().getClass());
	}

	


}
