package Vinchucas;


import java.util.Collections;

import Vinchucas.Muestra.Vinchuca;

public class Medio extends NivelVerificacion {

	@Override
	public Vinchuca getTipoVinchuca(Muestra m) {
		return this.vinchucaQuePredomina(m);
		
	}

	

}
