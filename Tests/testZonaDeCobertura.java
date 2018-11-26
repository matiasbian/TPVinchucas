import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.BaseDeDatos;
import Vinchucas.OperacionesUbicacion;
import Vinchucas.Organizacion;
import Vinchucas.Organizacion.TipoOrganizacion;
import Vinchucas.Ubicacion;
import Vinchucas.ZonaDeCobertura;

class testZonaDeCobertura {
	ZonaDeCobertura zc;
	Ubicacion ubi;
	BaseDeDatos db;
	@BeforeEach
	void Init() {
		ubi = Mockito.mock(Ubicacion.class);
		zc = new ZonaDeCobertura("Zona Sur",ubi,50);
		db = Mockito.mock(BaseDeDatos.class);
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
		BaseDeDatos.addZona(zc);
		BaseDeDatos.addZona(zc2);
		BaseDeDatos.addZona(zc3);
		assertEquals(zc.Solapantes(BaseDeDatos.getZonas()).size(),2);
		BaseDeDatos.ResetZonas();
	}
	
	@Test
	void testNotificarMuestraAOrganizaciones() {
		Organizacion UNICEF = Mockito.spy(new Organizacion(ubi,TipoOrganizacion.Asistencia,5000));
		Organizacion Caritas = Mockito.spy(new Organizacion(ubi,TipoOrganizacion.Asistencia,5000));
		

		zc.registrarse(UNICEF);
		zc.registrarse(Caritas);
		zc.notificarMuestra();
		Mockito.verify(UNICEF).updateMuestra();
		Mockito.verify(Caritas).updateMuestra();
		
	}
	
	@Test
	void testNotificarVerificacionAOrganizaciones() {
		Organizacion UNICEF = Mockito.spy(new Organizacion(ubi,TipoOrganizacion.Asistencia,5000));
		Organizacion Caritas = Mockito.spy(new Organizacion(ubi,TipoOrganizacion.Asistencia,5000));
		

		zc.registrarse(UNICEF);
		zc.registrarse(Caritas);
		zc.notificarVerificacion();
		Mockito.verify(UNICEF).updateVerificacion();
		Mockito.verify(Caritas).updateVerificacion();
		
	}

}
