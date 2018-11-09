import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Alto;
import Vinchucas.Bajo;
import Vinchucas.Medio;
import Vinchucas.Muestra;
import Vinchucas.NivelVerificacion;
import Vinchucas.Ubicacion;
import Vinchucas.Verificacion;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.Participante;
class testNivelVerificaciones {
	NivelVerificacion bajo,medio,alto;
	Muestra muestra1;
	Ubicacion ubi;
	Participante p;
	Verificacion v1,v2,v3;
	@Before
	void SetUp() {
		bajo = new Bajo();
		medio = new Medio();
		alto = new Alto();
		ubi = Mockito.mock(Ubicacion.class);
		p = Mockito.mock(Participante.class);
		
		
	}
	@Test
	void testMuestraNivelBajo() {
		muestra1 = new Muestra(Vinchuca.ChincheFoliada,"chinche.png",ubi,p);
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(0);
		Mockito.when(v3.nivelVerif()).thenReturn(0);
		muestra1.addVerificaciones(v1);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		assertEquals(muestra1.getNivelVerificacion().getClass(),Bajo.class);
	}
	
	@Test
	void testMuestraNivelMedio() {
		muestra1 = new Muestra(Vinchuca.ChincheFoliada,"chinche.png",ubi,p);
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(0);
		muestra1.addVerificaciones(v1);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		
		assertEquals(muestra1.getNivelVerificacion().getClass(),Medio.class);
	}
	
	@Test
	void testMuestraNivelAlto() {
		muestra1 = new Muestra(Vinchuca.ChincheFoliada,"chinche.png",ubi,p);
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(2);
		Mockito.when(v3.nivelVerif()).thenReturn(3);
		muestra1.addVerificaciones(v1);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		assertEquals(muestra1.getNivelVerificacion().getClass(),Alto.class);
	}

}
