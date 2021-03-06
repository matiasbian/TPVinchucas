import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import Vinchucas.Alto;
import Vinchucas.Bajo;
import Vinchucas.Medio;
import Vinchucas.Muestra;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.NivelVerificacion;
import Vinchucas.Ubicacion;
import Vinchucas.Verificacion;
import Vinchucas.Participante;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

class TestMuestras {
	Muestra muestra1;
	Ubicacion ubicacion1, ubicacion2;
	Participante usuario ;
	Verificacion v,v2,v3;
	NivelVerificacion nv;
	
	@BeforeEach
	void Init() {
		usuario = mock(Participante.class);
		ubicacion1 = new Ubicacion(120, 15);
		v = Mockito.mock(Verificacion.class);
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		ubicacion2 = new Ubicacion(130, 15);
	}
	

	@Test
	void testTipoVinchucaFotografiada() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals(Vinchuca.Vinchuca, muestra1.tipoVinchucaFotog());
	}
	
	@Test
	void getUbicacion() {
		assertEquals(muestra1.getUbicacion(),ubicacion1);
	}
	@Test
	void testFotoVinchucaFotografiada() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals("vinchuca.bmp", muestra1.fotoVinchuca());
	}
	
	@Test
	void testAliasUsuario() {
		usuario = mock(Participante.class);
		when(usuario.nickName()).thenReturn("MatiBian");
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals("MatiBian", muestra1.aliasUsuario());
	}
	
	@Test
	void getSetNivelVerif() {
		NivelVerificacion nv = Mockito.mock(Alto.class);
		Mockito.when(nv.calcular(muestra1)).thenReturn(new Alto());
		muestra1.setNivelVerificacion(nv);
		
		assertEquals(muestra1.getNivelVerificacion().getClass(),Alto.class);
	}
	
	@Test
	void getFechaCreacion() {
		assertEquals(muestra1.getFechaDeCreacion().getClass(),new Date().getClass());
	}
	
	@Test
	void testUbicacionVinchuca() {
		ubicacion1 = mock(Ubicacion.class);
		when(ubicacion1.latitud()).thenReturn(150.0);
		when(ubicacion1.longitud()).thenReturn(300.0);
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		assertEquals(muestra1.ubicacion().latitud(), 150.0);
		assertEquals(muestra1.ubicacion().longitud(), 300.0);
	}
	
	@Test
	void testNivelVerificacionBajo() {
		v = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		Mockito.when(v.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(0);
		Mockito.when(v3.nivelVerif()).thenReturn(0);
		
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		muestra1.addVerificaciones(v);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		assertEquals(Bajo.class, muestra1.getNivelVerificacion().getClass());
	}
	
	@Test
	void testNivelVerificacionMedio() {
		v = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		Mockito.when(v.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(0);
		
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		muestra1.addVerificaciones(v);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		assertEquals(Medio.class, muestra1.getNivelVerificacion().getClass());
	}
	
	@Test
	void testNivelVerificacionAlto() {
		v = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		Mockito.when(v.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(3);
		
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		muestra1.addVerificaciones(v);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		assertEquals(Alto.class, muestra1.getNivelVerificacion().getClass());
	}
	
	@Test
	void testAddVerificacion() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		muestra1.addVerificaciones(v);
		assertEquals(muestra1.verificaciones().size(),1);
	}
	
	@Test
	void testMuestrasLejanas() {
		muestra1 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion1,usuario);
		Muestra muestra2 = new Muestra(Vinchuca.Vinchuca,"vinchuca.bmp",ubicacion2,usuario);
		ArrayList <Muestra> muestrass = new ArrayList();
		ArrayList <Muestra> muestrass2 = new ArrayList();
		muestrass.add(muestra1);
		muestrass.add(muestra2);
		assertEquals(muestra1.muestrasAMenosDe(muestrass, 30), muestrass2);
	}
}
