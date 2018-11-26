package Vinchucas;

import java.util.Date;

public class FechaDeCreacion extends FiltroDeBusqueda {
	Date fecha ;
	public FechaDeCreacion (Date d) {
		this.fecha = d;
	}

	@Override
	public Boolean filtro(Muestra m) {
		return m.getFechaDeCreacion().before(fecha);
	}
	

}
