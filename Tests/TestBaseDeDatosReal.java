import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Muestra;
import Vinchucas.NivelParticipante;
import Vinchucas.Participante;
import Vinchucas.ParticipanteBasico;
import Vinchucas.PortalWeb;
import Vinchucas.Ubicacion;
import Vinchucas.Verificacion;
import Vinchucas.ZonaDeCobertura;
import Vinchucas.BaseDeDatos;
import Vinchucas.FiltroDeBusqueda;

class TestBaseDeDatosReal {

	Muestra m1,m2,m3;
	Verificacion v1,v2,v3;
	ZonaDeCobertura z1,z2,z3;
	ZonaDeCobertura zona,zona2;
	Participante p;
	NivelParticipante n1;
	PortalWeb pw;
	Ubicacion ubi, ubi2;
	BaseDeDatos bd;
	@BeforeEach
	void Init() {
		n1 = new ParticipanteBasico();
		m1 = Mockito.mock(Muestra.class);
		m2 = Mockito.mock(Muestra.class);
		m3 = Mockito.mock(Muestra.class);
		
		v1 = Mockito.mock(Verificacion.class);
		v2 = Mockito.mock(Verificacion.class);
		v3 = Mockito.mock(Verificacion.class);
		
		z1 = Mockito.mock(ZonaDeCobertura.class);
		z2 = Mockito.mock(ZonaDeCobertura.class);
		z3 = Mockito.mock(ZonaDeCobertura.class);
		
		bd = new BaseDeDatos();
		p = new Participante("Joako221",n1);
		pw = new PortalWeb();
		ubi = new Ubicacion(120, 15);
		ubi2 = new Ubicacion(1, 15);
		zona = new ZonaDeCobertura("hola", ubi, 80);
		zona2 = new ZonaDeCobertura("hola", ubi2, 20);
	}
	
	@Test
	void agregarMuestra() {
		BaseDeDatos.ResetMuestras();
		BaseDeDatos.addMuestra(m1);
		assertEquals(BaseDeDatos.getMuestras().size(),1);
	}
	
	@Test
	void agregarMuestras() {
		BaseDeDatos.ResetMuestras();
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		assertEquals(BaseDeDatos.getMuestras().size(),3);
	}
	
	@Test
	void agregarVerificacion() {
		BaseDeDatos.ResetVerificaciones();
		BaseDeDatos.addVerificacion(v1);
		assertEquals(BaseDeDatos.getVerificaciones().size(),1);
	}
	
	@Test
	void agregarVerificaciones() {
		BaseDeDatos.ResetVerificaciones();
		BaseDeDatos.addVerificacion(v1);
		BaseDeDatos.addVerificacion(v2);
		BaseDeDatos.addVerificacion(v3);
		assertEquals(BaseDeDatos.getVerificaciones().size(),3);
	}
	
	@Test
	void agregarVerificacionesYReseteo() {
		
		BaseDeDatos.addVerificacion(v1);
		BaseDeDatos.addVerificacion(v2);
		BaseDeDatos.addVerificacion(v3);
		BaseDeDatos.ResetVerificaciones();
		assertEquals(BaseDeDatos.getVerificaciones().size(),0);
	}
	
	@Test
	void agregarMuestrasYReseteo() {
		
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.ResetMuestras();
		assertEquals(BaseDeDatos.getMuestras().size(),0);
	}
	
	@Test
	void agregarMuestrasYElimino1() {
		BaseDeDatos.ResetMuestras();
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.removeMuestra(m2);
		assertEquals(BaseDeDatos.getMuestras().size(),2);
	}
	
	@Test
	void agregarVerificacionesYElimino1() {
		BaseDeDatos.ResetVerificaciones();
		BaseDeDatos.addVerificacion(v1);
		BaseDeDatos.addVerificacion(v2);
		BaseDeDatos.addVerificacion(v3);
		BaseDeDatos.removeVerificacion(v2);
		assertEquals(BaseDeDatos.getVerificaciones().size(),2);
	}
	
	@Test
	void agregarZona() {
		BaseDeDatos.ResetZonas();
		BaseDeDatos.addZona(z1);
		assertEquals(BaseDeDatos.getZonas().size(),1);
	}
	
	@Test
	void agregarZonas() {
		BaseDeDatos.ResetZonas();
		BaseDeDatos.addZona(z1);
		BaseDeDatos.addZona(z2);
		BaseDeDatos.addZona(z3);
		assertEquals(BaseDeDatos.getZonas().size(),3);
	}
	
	@Test
	void agregarZonasYElimino1() {
		BaseDeDatos.ResetZonas();
		BaseDeDatos.addZona(z1);
		BaseDeDatos.addZona(z2);
		BaseDeDatos.addZona(z3);
		BaseDeDatos.removeZona(z2);
		assertEquals(BaseDeDatos.getZonas().size(),2);
	}
	
	@Test
	void agregarZonasYReseteoDespues() {
		BaseDeDatos.ResetZonas();
		BaseDeDatos.addZona(z1);
		BaseDeDatos.addZona(z2);
		BaseDeDatos.addZona(z3);
		assertEquals(BaseDeDatos.getZonas().size(),3);
		BaseDeDatos.ResetZonas();
		assertEquals(BaseDeDatos.getZonas().size(),0);
	}
	
	/*@Test
	void agregarMuestrasYElimino1YFiltroOtra() {
		BaseDeDatos.ResetMuestras();
		BaseDeDatos.addMuestra(m1);
		BaseDeDatos.addMuestra(m2);
		BaseDeDatos.addMuestra(m3);
		BaseDeDatos.removeMuestra(m2);
		assertEquals(BaseDeDatos.getMuestras().size(),2);
		List<Muestra> muestras= BaseDeDatos.getMuestras() ;
		assertEquals(BaseDeDatos.filtrar(FiltroDeBusqueda.filtro(m3)),m3);
	}*/
}
