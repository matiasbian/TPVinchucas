package Vinchucas;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class FechaUltimaVerificacion extends FiltroDeBusqueda {

	private Date fecha;
	

	public FechaUltimaVerificacion(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public Boolean filtro(Muestra m) {
		Comparator<Verificacion> c = Comparator.comparing( Verificacion::getDate );
		Optional<Verificacion> v =  m.verificaciones().stream().max( c);
		
		if (v.isPresent()) { 
			return v.get().getDate().before(fecha);
        } 
        else { 
            return false;
        } 
		
	}

}
