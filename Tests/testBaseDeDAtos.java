import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.PortalWeb;
import Vinchucas.FiltroDeBusqueda;
import Vinchucas.Muestra;
import Vinchucas.Verificacion;
import Vinchucas.ZonaDeCobertura;

class testPortalWeb {
	Muestra m1,m2,m3;
	Verificacion v1,v2,v3;
	ZonaDeCobertura z1,z2,z3;
	@BeforeEach
	void Init() {
		m1 = Mockito.mock(Muestra.class);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		
		z1 = Mockito.mock(ZonaDeCobertura.class);
		z2 = Mockito.mock(ZonaDeCobertura.class);
		z3 = Mockito.mock(ZonaDeCobertura.class);
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

}
