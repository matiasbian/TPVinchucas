import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.PortalWeb;
import Vinchucas.FuncionalidadExterna;
import Vinchucas.Muestra;
import Vinchucas.Organizacion;
import Vinchucas.Organizacion.TipoOrganizacion;
import Vinchucas.Ubicacion;
import Vinchucas.ZonaDeCobertura;

class testZonaDeCobertura {
	ZonaDeCobertura zc;
	Ubicacion ubi;
	PortalWeb db;
	FuncionalidadExterna funcMuestra;
	FuncionalidadExterna funcVerificacion;
	Muestra m;
	
	@BeforeEach
	void Init() {
		ubi = Mockito.mock(Ubicacion.class);
		zc = new ZonaDeCobertura("Zona Sur",ubi,50);
		db = Mockito.mock(PortalWeb.class);
		m  = Mockito.mock(Muestra.class);
	}
	@Test
	void testGetSetEpicentro() {
		Ubicacion ubi2 = Mockito.mock(Ubicacion.class);
		zc.setEpicentro(ubi2);
		assertEquals(zc.getEpicentro(),ubi2);
	}
	
	@Test
	void testGetSetNombre() {
		zc.setNombre("Florencio Varela");
		assertEquals(zc.getNombre(),"Florencio Varela");
	}
	
	@Test
	void testGetSetRadio() {
		zc.setRadio(100);
		assertEquals(zc.getRadio(),100);
	}
	@Test
	void testRegistrarse() {
		Organizacion o;
		o = Mockito.mock(Organizacion.class);
		zc.registrarse(o);
		assertEquals(zc.getOrganizaciones().size(),1);
	}
	@Test
	void testDesRegistrarse() {
		Organizacion o;
		o = Mockito.mock(Organizacion.class);
		zc.registrarse(o);
		zc.desRegistrarse(o);
		assertEquals(zc.getOrganizaciones().size(),0);
	}
	
	@Test
	void testEpicentrosSolapantes() {
		ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();
		Ubicacion ubi2 = Mockito.mock(Ubicacion.class);
		Ubicacion ubi3 = Mockito.mock(Ubicacion.class);
		Mockito.when(ubi.latitud()).thenReturn(50.0);
		Mockito.when(ubi.longitud()).thenReturn(50.0);
		Mockito.when(ubi2.latitud()).thenReturn(49.0);
		Mockito.when(ubi2.longitud()).thenReturn(49.0);
		Mockito.when(ubi3.latitud()).thenReturn(49.0);
		Mockito.when(ubi3.longitud()).thenReturn(51.0);
		ZonaDeCobertura zc2 = new ZonaDeCobertura("Quilmes",ubi2,90);
		ZonaDeCobertura zc3 = new ZonaDeCobertura("Berazategui",ubi3,150);
		PortalWeb.addZona(zc);
		PortalWeb.addZona(zc2);
		PortalWeb.addZona(zc3);
		assertEquals(zc.Solapantes(PortalWeb.getZonas()).size(),2);
		PortalWeb.ResetZonas();
	}
	
	@Test
	void testNotificarMuestraAOrganizaciones() {
		Organizacion UNICEF = Mockito.mock(Organizacion.class);
		Organizacion Caritas = Mockito.mock(Organizacion.class);
		

		zc.registrarse(UNICEF);
		zc.registrarse(Caritas);
		zc.notificarMuestra(m);
		Mockito.verify(UNICEF).updateMuestra(zc, m);
		Mockito.verify(Caritas).updateMuestra(zc, m);
		
	}
	
	@Test
	void testNotificarVerificacionAOrganizaciones() {
		Organizacion UNICEF = Mockito.mock(Organizacion.class);
		Organizacion Caritas = Mockito.mock(Organizacion.class);
		

		zc.registrarse(UNICEF);
		zc.registrarse(Caritas);
		zc.notificarVerificacion(m);
		Mockito.verify(UNICEF).updateVerificacion(zc, m);
		Mockito.verify(Caritas).updateVerificacion(zc, m);
		
	}

}
