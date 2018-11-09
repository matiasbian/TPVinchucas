import Vinchucas.Organizacion;
import Vinchucas.Ubicacion;
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
    @Before
    public void setUp(){

        ubicacion = mock(Ubicacion.class);
        organizacion = new Organizacion(ubicacion, Organizacion.TipoOrganizacion.Asistencia,10);
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

}
