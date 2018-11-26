package Vinchucas;

import Vinchucas.Muestra.Vinchuca;

public class TipoDeInsecto extends FiltroDeBusqueda {
	Muestra.Vinchuca tipoVinchuca ;
	

	public TipoDeInsecto(Vinchuca tipoVinchuca) {
		this.tipoVinchuca = tipoVinchuca;
	}


	@Override
	public Boolean filtro(Muestra m) {
		return m.tipoVinchucaFotog() == tipoVinchuca;
	}

}
