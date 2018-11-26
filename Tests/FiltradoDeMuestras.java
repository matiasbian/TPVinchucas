import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.AND;
import Vinchucas.Alto;
import Vinchucas.Bajo;
import Vinchucas.BaseDeDatos;
import Vinchucas.FechaDeCreacion;
import Vinchucas.FechaUltimaVerificacion;
import Vinchucas.FiltroDeBusqueda;
import Vinchucas.Medio;
import Vinchucas.Muestra;
import Vinchucas.NivelDeValidacion;
import Vinchucas.OR;
import Vinchucas.OperadorLogico;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.Participante;
import Vinchucas.TipoDeInsecto;
import Vinchucas.Ubicacion;
import Vinchucas.Verificacion;

class FiltradoDeMuestras {
	FiltroDeBusqueda f1,f2,f3,f4,ol1,ol2;
	Muestra m1,m2,m3,m4,m5;
	Verificacion v1,v2,v3;
	Participante p;
	@BeforeEach
	void Init() {
		//f3 = new TipoInsecto (Vinchuca.ChincheFoliada);
		//f4 = new NivelValidacion(new Medio());
		//ol1 = new OR();
		//ol2 = new AND();
		
		m1 = Mockito.mock(Muestra.class);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		m4 = Mockito.mock(Muestra.class);
		m5 = Mockito.mock(Muestra.class);
		
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		
		
				
	
	}

	@Test
	void filtroPorFechaDeCreacion() {
		
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m4);
		BaseDeDatos.addMuestra(m5);
		
		Mockito.when(m1.getFechaDeCreacion()).thenReturn(new Date(100));
		Mockito.when(m2.getFechaDeCreacion()).thenReturn(new Date(1000));
		Mockito.when(m3.getFechaDeCreacion()).thenReturn(new Date(3000));
		Mockito.when(m4.getFechaDeCreacion()).thenReturn(new Date(40000));
		Mockito.when(m5.getFechaDeCreacion()).thenReturn(new Date(50000));
		
		f1 = new FechaDeCreacion(new Date(10000));
	
		assertEquals(BaseDeDatos.filtrar(f1).size(), 3);
		BaseDeDatos.ResetMuestras();
	}
	
	@Test
	void filtroPorFechaUltimaVerificacion() {
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m4);
		BaseDeDatos.addMuestra(m5);
		
		
		ArrayList<Verificacion> vs = new ArrayList<Verificacion>();
		vs.add(v1);
		vs.add(v2);
		vs.add(v3);
		Mockito.when(v1.getDate()).thenReturn(new Date(500));
		Mockito.when(v2.getDate()).thenReturn(new Date(500));
		Mockito.when(v3.getDate()).thenReturn(new Date(5000));
		Mockito.when(m1.verificaciones()).thenReturn(vs);

		
		f2 = new FechaUltimaVerificacion(new Date(10000));
	
		assertEquals(BaseDeDatos.filtrar(f2).size(), 1);
		BaseDeDatos.ResetMuestras();
	}
	
	@Test
	void filtroPorTipoDeInsecto() {
		
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m4);
		BaseDeDatos.addMuestra(m5);

		Mockito.when(m1.tipoVinchucaFotog()).thenReturn(Vinchuca.ChincheFoliada);
		Mockito.when(m2.tipoVinchucaFotog()).thenReturn(Vinchuca.ImagenPocoClara);
		Mockito.when(m3.tipoVinchucaFotog()).thenReturn(Vinchuca.ChincheFoliada);
		Mockito.when(m4.tipoVinchucaFotog()).thenReturn(Vinchuca.Vinchuca);
		Mockito.when(m5.tipoVinchucaFotog()).thenReturn(Vinchuca.Ninguna);
	

		
		f3 = new TipoDeInsecto(Vinchuca.ChincheFoliada);
	
		assertEquals(BaseDeDatos.filtrar(f3).size(), 2);
		BaseDeDatos.ResetMuestras();
	}
	
	@Test
	void filtroPorNivelDeValoracion() {
		
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m4);
		BaseDeDatos.addMuestra(m5);


		Mockito.when(m1.getNivelVerificacion()).thenReturn(new Medio());
		Mockito.when(m2.getNivelVerificacion()).thenReturn(new Alto());
		Mockito.when(m3.getNivelVerificacion()).thenReturn(new Bajo());
		Mockito.when(m4.getNivelVerificacion()).thenReturn(new Medio());
		Mockito.when(m5.getNivelVerificacion()).thenReturn(new Medio());
		f4 = new NivelDeValidacion(new Medio());
	
		assertEquals(BaseDeDatos.filtrar(f4).size(), 3);
		BaseDeDatos.ResetMuestras();
	}
	
	@Test
	void filtroPorNivelDeValoracionANDTipoDeVinchuca() {
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m4);
		BaseDeDatos.addMuestra(m5);
		

		Mockito.when(m1.getNivelVerificacion()).thenReturn(new Medio());
		Mockito.when(m2.getNivelVerificacion()).thenReturn(new Alto());
		Mockito.when(m3.getNivelVerificacion()).thenReturn(new Bajo());
		Mockito.when(m4.getNivelVerificacion()).thenReturn(new Medio());
		Mockito.when(m5.getNivelVerificacion()).thenReturn(new Medio());
		
		Mockito.when(m1.tipoVinchucaFotog()).thenReturn(Vinchuca.ChincheFoliada);
		Mockito.when(m2.tipoVinchucaFotog()).thenReturn(Vinchuca.ImagenPocoClara);
		Mockito.when(m3.tipoVinchucaFotog()).thenReturn(Vinchuca.ChincheFoliada);
		Mockito.when(m4.tipoVinchucaFotog()).thenReturn(Vinchuca.Vinchuca);
		Mockito.when(m5.tipoVinchucaFotog()).thenReturn(Vinchuca.Ninguna);
		
		f3 = new TipoDeInsecto(Vinchuca.ChincheFoliada);
		f4 = new NivelDeValidacion(new Medio());
		ol1 = new AND(f3,f4);
		assertEquals(BaseDeDatos.filtrar(ol1).size(), 1);
		BaseDeDatos.ResetMuestras();
	}
	
	@Test
	void filtroPorNivelDeValoracionANDChincheOVinchuca() {
		
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m4);
		BaseDeDatos.addMuestra(m5);

		Mockito.when(m1.getNivelVerificacion()).thenReturn(new Medio());
		Mockito.when(m2.getNivelVerificacion()).thenReturn(new Alto());
		Mockito.when(m3.getNivelVerificacion()).thenReturn(new Bajo());
		Mockito.when(m4.getNivelVerificacion()).thenReturn(new Medio());
		Mockito.when(m5.getNivelVerificacion()).thenReturn(new Medio());
		
		Mockito.when(m1.tipoVinchucaFotog()).thenReturn(Vinchuca.ChincheFoliada);
		Mockito.when(m2.tipoVinchucaFotog()).thenReturn(Vinchuca.ImagenPocoClara);
		Mockito.when(m3.tipoVinchucaFotog()).thenReturn(Vinchuca.ChincheFoliada);
		Mockito.when(m4.tipoVinchucaFotog()).thenReturn(Vinchuca.Vinchuca);
		Mockito.when(m5.tipoVinchucaFotog()).thenReturn(Vinchuca.Ninguna);
		
		f3 = new TipoDeInsecto(Vinchuca.ChincheFoliada);
		f4 = new NivelDeValidacion(new Medio());
		f2 = new TipoDeInsecto(Vinchuca.Vinchuca);
		
		ol2 = new OR(f3,f2);
		ol1 = new AND(f4,ol2);
		assertEquals(BaseDeDatos.filtrar(ol1).size(), 2);
		BaseDeDatos.ResetMuestras();
	}

}
