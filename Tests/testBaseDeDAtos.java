import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.PortalWeb;
import Vinchucas.Ubicacion;
import Vinchucas.FiltroDeBusqueda;
import Vinchucas.Muestra;
import Vinchucas.NivelParticipante;
import Vinchucas.Participante;
import Vinchucas.ParticipanteBasico;
import Vinchucas.Verificacion;
import Vinchucas.ZonaDeCobertura;
import Vinchucas.Muestra.Vinchuca;

class testPortalWeb {
	Muestra m1,m2,m3;
	//Muestra muestra;
	Verificacion v1,v2,v3;
	ZonaDeCobertura z1,z2,z3;
	ZonaDeCobertura zona,zona2;
	Participante p;
	NivelParticipante n1;
	PortalWeb pw;
	Ubicacion ubi, ubi2;
	@BeforeEach
	void Init() {
		n1 = new ParticipanteBasico();
		m1 = Mockito.mock(Muestra.class);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		
		z1 = Mockito.mock(ZonaDeCobertura.class);
		z2 = Mockito.mock(ZonaDeCobertura.class);
		z3 = Mockito.mock(ZonaDeCobertura.class);
		p = new Participante("Joako221",n1);
		pw = new PortalWeb();
		ubi = new Ubicacion(120, 15);
		ubi2 = new Ubicacion(1, 15);
		zona = new ZonaDeCobertura("hola", ubi, 80);
		zona2 = new ZonaDeCobertura("hola", ubi2, 20);
		//muestra = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubi, p);
	}
	@Test
	void addRemoveGetMuestra() {
		PortalWeb.ResetMuestras();
		PortalWeb.addMuestra(m1);
		PortalWeb.addMuestra(m3);
		PortalWeb.addMuestra(m2);
		
		PortalWeb.removeMuestra(m2);
		assertEquals(PortalWeb.getMuestras().size(),2);
		
	}
	@Test
	void addRemoveGetVerificacion() {
		PortalWeb.ResetVerificaciones();
		PortalWeb.addVerificacion(v1);
		PortalWeb.addVerificacion(v2);
		PortalWeb.addVerificacion(v3);
		
		PortalWeb.removeVerificacion(v1);
		assertEquals(PortalWeb.getVerificaciones().size(),2);
	}
	@Test
	void addRemoveGetZona() {
		PortalWeb.ResetZonas();
		PortalWeb.addZona(z1);
		PortalWeb.addZona(z2);
		PortalWeb.addZona(z3);
		
		PortalWeb.removeZona(z3);
		PortalWeb.removeZona(z1);
		
		assertEquals(PortalWeb.getZonas().size(),1);
	}

	@Test
	void resetMuestras() {
		PortalWeb.ResetMuestras();
		assertEquals(PortalWeb.getMuestras().isEmpty(),true);
	}
	@Test
	void reesetVerificaciones() {
		PortalWeb.ResetVerificaciones();
		assertEquals(PortalWeb.getVerificaciones().isEmpty(),true);
	}
	@Test
	void resetZona() {
		PortalWeb.ResetZonas();
		assertTrue(PortalWeb.getZonas().isEmpty());
	}

	@Test
	void agregarParticipante() {
		PortalWeb.addParticipante(p);
		assertFalse(PortalWeb.getParticipantes().isEmpty());
	}
	
	@Test
	void agregarYremuevoParticipante() {
		PortalWeb.addParticipante(p);
		PortalWeb.removeParticipante(p);
		assertFalse(PortalWeb.getParticipantes().isEmpty());
	}
	
	@Test
	void reseteoParticipantesExistentes() {
		PortalWeb.addParticipante(p);
		PortalWeb.ResetParticipantes();
		assertTrue(PortalWeb.getParticipantes().isEmpty());
	}
	
	@Test
	void notificarMuestra() {
		PortalWeb.addParticipante(p);
		PortalWeb.ResetMuestras();
		PortalWeb.addMuestra(m1);
		PortalWeb.ResetZonas();
		PortalWeb.addZona(zona);
		Mockito.when(m1.getUbicacion()).thenReturn(zona.getEpicentro());
		PortalWeb.notificarOrganizacionDeMuestra(m1);
		assertEquals(PortalWeb.getMuestras().size(),1);
	}
	
	@Test
	void notificarVerificacion() {
		PortalWeb.addParticipante(p);
		PortalWeb.ResetMuestras();
		PortalWeb.addMuestra(m1);
		PortalWeb.addVerificacion(v1);
		PortalWeb.addZona(zona);
		Mockito.when(m1.getUbicacion()).thenReturn(zona.getEpicentro());
		PortalWeb.notificarOrganizacionDeVerificacion(m1);
		assertEquals(PortalWeb.getMuestras().size(),1);
	}
	
	@Test
	void testNoNotificarMuestra() {
		PortalWeb.addParticipante(p);
		PortalWeb.ResetMuestras();
		PortalWeb.addMuestra(m1);
		PortalWeb.addVerificacion(v1);
		PortalWeb.addZona(zona);
		Mockito.when(m1.getUbicacion()).thenReturn(zona2.getEpicentro());
		PortalWeb.notificarOrganizacionDeMuestra(m1);
		assertEquals(PortalWeb.getMuestras().size(),1);
	}
	
	@Test
	void testNoNotificarVerificacion() {
		PortalWeb.addParticipante(p);
		PortalWeb.ResetMuestras();
		PortalWeb.addMuestra(m1);
		PortalWeb.addVerificacion(v1);
		PortalWeb.addZona(zona);
		Mockito.when(m1.getUbicacion()).thenReturn(zona2.getEpicentro());
		PortalWeb.notificarOrganizacionDeVerificacion(m1);
		assertEquals(PortalWeb.getMuestras().size(),1);
	}
}
