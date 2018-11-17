package Vinchucas;

import Vinchucas.Muestra.Vinchuca;

public class Alto extends NivelVerificacion {

	@Override
	public Vinchuca getTipoVinchuca(Muestra m) {
		return this.vinchucaQuePredomina(m);
		
	}

}
