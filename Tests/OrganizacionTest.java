import Vinchucas.FuncExtClass;
import Vinchucas.FuncionalidadExterna;
import Vinchucas.Muestra;
import Vinchucas.Organizacion;
import Vinchucas.Organizacion.TipoOrganizacion;
import Vinchucas.Ubicacion;
import Vinchucas.ZonaDeCobertura;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrganizacionTest {
    Ubicacion ubicacion;
    Organizacion organizacion;
    Ubicacion ubicacionTest;
    FuncionalidadExterna funcMuestra;
    FuncionalidadExterna funcVerificacion;
    	
    
    @Before
    public void setUp(){
    	
        ubicacion = mock(Ubicacion.class);
        organizacion = new Organizacion(ubicacion, Organizacion.TipoOrganizacion.Asistencia,10, funcMuestra, funcVerificacion);
        ubicacionTest = mock(Ubicacion.class);

    }

    @Test
    public void SetYGetUbicacion(){
        organizacion.setUbicacion(ubicacionTest);
        assertEquals(organizacion.ubicacion(),ubicacionTest);
    }

    @Test
    public void SetYGetTipoDeOrganizacion(){

    	
        organizacion.setTipo(Organizacion.TipoOrganizacion.Salud);
        assertEquals(organizacion.tipoDeOrganizacion(), Organizacion.TipoOrganizacion.Salud);

    }

    @Test
    public void SetYGetCantidadDeEmpleados(){
        organizacion.setCantEmpleados(20);
        assertEquals(organizacion.cantidadDeEmpleados(),20);
    }
    
    @Test
    public void testFuncExtMuestra() {
    	FuncionalidadExterna v = new FuncExtClass();
    	FuncionalidadExterna vSpy = Mockito.spy(v);
    	Ubicacion u = Mockito.mock(Ubicacion.class);
    	Muestra m = Mockito.mock(Muestra.class);
    	ZonaDeCobertura z = new ZonaDeCobertura("Varela", u, 100);
    	Organizacion org = new Organizacion(u, TipoOrganizacion.Asistencia, 10, vSpy, v);
    	org.updateMuestra(z, m);
    	Mockito.verify(vSpy).NuevoEvento(org, z, m);
    }
    
    @Test
    public void testFuncExtVerif() {
    	FuncionalidadExterna v = new FuncExtClass();
    	FuncionalidadExterna vSpy = Mockito.spy(v);
    	Ubicacion u = Mockito.mock(Ubicacion.class);
    	Muestra m = Mockito.mock(Muestra.class);
    	ZonaDeCobertura z = new ZonaDeCobertura("Varela", u, 100);
    	Organizacion org = new Organizacion(u, TipoOrganizacion.Asistencia, 10, v, vSpy);
    	org.updateVerificacion(z, m);
    	Mockito.verify(vSpy).NuevoEvento(org, z, m);
    }

}
