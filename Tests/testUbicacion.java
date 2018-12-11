import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Muestra;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.Participante;
import Vinchucas.Ubicacion;
import Vinchucas.ZonaDeCobertura;

class testUbicacion {
	Ubicacion u1,u2,u3,u4;
	Muestra m1,m2,m3,m4;
	@BeforeEach
	void initUbicaciones() {
		u1 = new Ubicacion(100,100);
		u2 = new Ubicacion(99.5,99.9);
		u3 = new Ubicacion(100.2,100.1);
		u4 = new Ubicacion(102,105);

		InitMuestras();
	}
	
	void InitMuestras() {
		Participante p = Mockito.mock(Participante.class);
		m1 = new Muestra(Vinchuca.ChincheFoliada,"foto.raw",u1,p);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		m4 = Mockito.mock(Muestra.class);
		Mockito.when(m2.getUbicacion()).thenReturn(u2);
		Mockito.when(m3.getUbicacion()).thenReturn(u3);
		Mockito.when(m4.getUbicacion()).thenReturn(u4);
	}

	@Test
	void testGetLatitud() {
		u1 = new Ubicacion(150,200);
		assertEquals(u1.latitud(),150);
	}
	
	@Test
	void testGetLongitud() {
		u1 = new Ubicacion(150,200);
		assertEquals(u1.longitud(),200);
	}
	
	@Test
	void testDistanciaNulaEntreDosPuntos() {
		Ubicacion u1n = new Ubicacion(100,100);
		assertEquals(u1.distanciaEntreDosUbicaciones(u1n),0);
	}
	
	@Test
	void testDistanciaNormalEntreDosPuntos() {
	
		assertEquals(u1.distanciaEntreDosUbicaciones( u2),55.629323296421376);
	}
	
	@Test
	void testDosUbicacionesCercanas() {

		ArrayList<Ubicacion> lista = new ArrayList<Ubicacion>();
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		lista.add(u4);
		assertEquals(u1.ubicacionesAMenosDe(lista, 1000).size(),3);
	}
	
	@Test
	void testTresMuestrasCercanas() {

		
		ArrayList<Muestra> listaM = new ArrayList<Muestra>();
		listaM.add(m1);
		listaM.add(m2);
		listaM.add(m3);
		listaM.add(m4);
		
		assertEquals(m1.muestrasAMenosDe(listaM, 5000).size(),3);
	}
	

}
