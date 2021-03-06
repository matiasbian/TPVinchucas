import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.AtLeast;

import Vinchucas.BaseDeDatos;
import Vinchucas.Muestra;
import Vinchucas.OperacionesUbicacion;
import Vinchucas.Ubicacion;
import Vinchucas.ZonaDeCobertura;

class testOperacionesUbicacion {
	Ubicacion u1,u2,u3,u4;
	Muestra m1,m2,m3,m4;
	Ubicacion ubi;
	ZonaDeCobertura zc;
	
	void initUbicaciones() {
		u1 = Mockito.mock(Ubicacion.class);
		u2 = Mockito.mock(Ubicacion.class);
		u3 = Mockito.mock(Ubicacion.class);
		u4 = Mockito.mock(Ubicacion.class);
		Mockito.when(u1.latitud()).thenReturn(150.0);
		Mockito.when(u1.longitud()).thenReturn(20.0);
		Mockito.when(u2.latitud()).thenReturn(70.0);
		Mockito.when(u2.longitud()).thenReturn(25.0);

	}
	
	void InitMuestras() {
		m1 = Mockito.mock(Muestra.class);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		m4 = Mockito.mock(Muestra.class);
		Mockito.when(m1.getUbicacion()).thenReturn(u1);
		Mockito.when(m2.getUbicacion()).thenReturn(u2);
		Mockito.when(m3.getUbicacion()).thenReturn(u3);
		Mockito.when(m4.getUbicacion()).thenReturn(u4);
		ubi = new Ubicacion(120, 15);
	}
	

	@BeforeEach
	void Init() {
		OperacionesUbicacion ou = new OperacionesUbicacion();
	    zc= new ZonaDeCobertura("Quilmes", ubi, 10000);
	}
	
	@Test
	void testDistanciaNulaEntreDosPuntos() {
		u1 = Mockito.mock(Ubicacion.class);
		u2 = Mockito.mock(Ubicacion.class);
		Mockito.when(u1.latitud()).thenReturn(150.0);
		Mockito.when(u1.longitud()).thenReturn(200.0);
		Mockito.when(u2.latitud()).thenReturn(150.0);
		Mockito.when(u2.longitud()).thenReturn(200.0);
		assertEquals(OperacionesUbicacion.distanciaEntreDosUbicaciones(u1, u2),0);
	}
	
	@Test
	void testDistanciaNormalEntreDosPuntos() {
		u1 = Mockito.mock(Ubicacion.class);
		u2 = Mockito.mock(Ubicacion.class);
		Mockito.when(u1.latitud()).thenReturn(150.0);
		Mockito.when(u1.longitud()).thenReturn(200.0);
		Mockito.when(u2.latitud()).thenReturn(70.0);
		Mockito.when(u2.longitud()).thenReturn(25.0);
		assertEquals(OperacionesUbicacion.distanciaEntreDosUbicaciones(u1, u2),4458.95692447439);
	}
	
	@Test
	void testDosUbicacionesCercanas() {
		
		initUbicaciones();
		Mockito.when(u3.latitud()).thenReturn(71.0);
		Mockito.when(u3.longitud()).thenReturn(26.0);
		Mockito.when(u4.latitud()).thenReturn(690.0);
		Mockito.when(u4.longitud()).thenReturn(240.0);
		ArrayList<Ubicacion> lista = new ArrayList<Ubicacion>();
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		lista.add(u4);
		assertEquals(OperacionesUbicacion.ubicacionesAMenosDe(lista, 1000).size(),2);
	}
	
	@Test
	void testCeroMuestrasCercanas() {
		initUbicaciones();
		Mockito.when(u3.latitud()).thenReturn(71.0);
		Mockito.when(u3.longitud()).thenReturn(26.0);
		Mockito.when(u4.latitud()).thenReturn(69.0);
		Mockito.when(u4.longitud()).thenReturn(24.0);
		InitMuestras();
		
		ArrayList<Muestra> listaM = new ArrayList<Muestra>();
		listaM.add(m1);
		listaM.add(m2);
		listaM.add(m3);
		listaM.add(m4);
		
		assertEquals(OperacionesUbicacion.muestrasAMenosDe(listaM, 5000).size(),0);
	}
	
	@Test 
	void testEstaEnLaZona() {
		Ubicacion u = new Ubicacion(100,100);
		Ubicacion u2 = new Ubicacion(99.5,100);
		ZonaDeCobertura z = new ZonaDeCobertura("Varela",u2,1000.5f);

		assertEquals(OperacionesUbicacion.estaEnLaZona(u, z),true);
	}
	


	@Test
	void testCeroMuestrasCercanasYSinRepetidosYnotificar() {
		initUbicaciones();
		Mockito.when(u3.latitud()).thenReturn(71.0);
		Mockito.when(u3.longitud()).thenReturn(26.0);
		Mockito.when(u4.latitud()).thenReturn(69.0);
		Mockito.when(u4.longitud()).thenReturn(24.0);
		InitMuestras();
		
		ArrayList<Muestra> listaM = new ArrayList<Muestra>();
		listaM.add(m1);
		listaM.add(m2);
		listaM.add(m3);
		listaM.add(m4);
		
		Mockito.when(m4.ubicacion()).thenReturn(ubi);
		
		OperacionesUbicacion.notificarOrganizacionDeMuestra(m4);
		assertEquals(OperacionesUbicacion.muestrasAMenosDe(listaM, 5000).size(),0);
	}
	
	
}
