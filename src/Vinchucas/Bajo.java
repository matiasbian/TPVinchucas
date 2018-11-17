package Vinchucas;

import Vinchucas.Muestra.Vinchuca;

public class Bajo extends NivelVerificacion {

	@Override
	public Vinchuca getTipoVinchuca(Muestra m) {
		return m.tipoVinchucaFotog();
	}



}
