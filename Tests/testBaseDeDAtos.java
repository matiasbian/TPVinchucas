import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.BaseDeDatos;
import Vinchucas.FiltroDeBusqueda;
import Vinchucas.Muestra;
import Vinchucas.Verificacion;
import Vinchucas.ZonaDeCobertura;

class testBaseDeDAtos {
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
		BaseDeDatos.ResetMuestras();
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.addMuestra(m2);
		
		BaseDeDatos.removeMuestra(m2);
		assertEquals(BaseDeDatos.getMuestras().size(),2);
		
	}
	@Test
	void addRemoveGetVerificacion() {
		BaseDeDatos.ResetVerificaciones();
		BaseDeDatos.addVerificacion(v1);
		BaseDeDatos.addVerificacion(v2);
		BaseDeDatos.addVerificacion(v3);
		
		BaseDeDatos.removeVerificacion(v1);
		assertEquals(BaseDeDatos.getVerificaciones().size(),2);
	}
	@Test
	void addRemoveGetZona() {
		BaseDeDatos.ResetZonas();
		BaseDeDatos.addZona(z1);
		BaseDeDatos.addZona(z2);
		BaseDeDatos.addZona(z3);
		
		BaseDeDatos.removeZona(z3);
		BaseDeDatos.removeZona(z1);
		
		assertEquals(BaseDeDatos.getZonas().size(),1);
	}

	@Test
	void resetMuestras() {
		BaseDeDatos.ResetMuestras();
		assertEquals(BaseDeDatos.getMuestras().isEmpty(),true);
	}
	@Test
	void reesetVerificaciones() {
		BaseDeDatos.ResetVerificaciones();
		assertEquals(BaseDeDatos.getVerificaciones().isEmpty(),true);
	}
	@Test
	void resetZona() {
		BaseDeDatos.ResetZonas();
		assertTrue(BaseDeDatos.getZonas().isEmpty());
	}

}
