import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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
	@BeforeEach
	void SetUp() {
		bajo = new Bajo();
		medio = new Medio();
		alto = new Alto();
		ubi = Mockito.mock(Ubicacion.class);
		p = Mockito.mock(Participante.class);
		muestra1 = new Muestra(Vinchuca.ChincheFoliada,"chinche.png",ubi,p);
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		muestra1.addVerificaciones(v1);
		muestra1.addVerificaciones(v2);
		muestra1.addVerificaciones(v3);
		
	}
	@Test
	void vinchucaQuePredomina() {
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(3);
		Mockito.when(v1.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		Mockito.when(v2.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		Mockito.when(v3.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		

		assertEquals(muestra1.getNivelVerificacion().vinchucaQuePredomina(muestra1),Muestra.Vinchuca.PhtiaChinche);
	}
	
	@Test
	void getTipoVinchucaCuandoEsNivelAlto() {
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(3);
		Mockito.when(v1.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		Mockito.when(v2.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		Mockito.when(v3.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		assertEquals(muestra1.getNivelVerificacion().getTipoVinchuca(muestra1),Muestra.Vinchuca.PhtiaChinche);
	}
	
	@Test
	void getTipoVinchucaCuandoEsNivelMedio() {
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(0);
		Mockito.when(v1.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.ChincheFoliada);
		Mockito.when(v2.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		Mockito.when(v3.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.ChincheFoliada);
		assertEquals(muestra1.getNivelVerificacion().getTipoVinchuca(muestra1),Muestra.Vinchuca.ChincheFoliada);
	}
	
	
	@Test
	void getTipoVinchucaCuandoEsNivelBajo() {
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(0);
		Mockito.when(v3.nivelVerif()).thenReturn(0);
		Mockito.when(v1.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.PhtiaChinche);
		Mockito.when(v2.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.ImagenPocoClara);
		Mockito.when(v3.getVinchucaDetectada()).thenReturn(Muestra.Vinchuca.Vinchuca);
		assertEquals(muestra1.getNivelVerificacion().getTipoVinchuca(muestra1),Muestra.Vinchuca.ChincheFoliada);
	}
	
	@Test
	void testMuestraNivelBajo() {
		
		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(0);
		Mockito.when(v3.nivelVerif()).thenReturn(0);

		assertEquals(muestra1.getNivelVerificacion().getClass(),Bajo.class);
	}
	
	@Test
	void testMuestraNivelMedio() {

		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(1);
		Mockito.when(v3.nivelVerif()).thenReturn(0);

		
		assertEquals(muestra1.getNivelVerificacion().getClass(),Medio.class);
	}
	
	@Test
	void testMuestraNivelAlto() {

		Mockito.when(v1.nivelVerif()).thenReturn(1);
		Mockito.when(v2.nivelVerif()).thenReturn(2);
		Mockito.when(v3.nivelVerif()).thenReturn(3);

		assertEquals(muestra1.getNivelVerificacion().getClass(),Alto.class);
	}

}
