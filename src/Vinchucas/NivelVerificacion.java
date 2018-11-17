package Vinchucas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import Vinchucas.Muestra.Vinchuca;

public abstract class NivelVerificacion {
	public NivelVerificacion calcular(Muestra m) {
		int ptsVerificacion = this.puntosVerificacion(m);
		if (ptsVerificacion == 2) {
			return new Medio();
		}else if (ptsVerificacion >= 2) {
			return new Alto();
		}else {
			return new Bajo();
		}
	}
	
	int puntosVerificacion(Muestra m) {
		return m.verificaciones().stream().mapToInt(v -> v.nivelVerif()).sum();
	}
	
	public Muestra.Vinchuca vinchucaQuePredomina(Muestra m){
		Muestra.Vinchuca tipoTemp = Muestra.Vinchuca.Ninguna;
		ArrayList<Muestra.Vinchuca> tiposVinchucas = m.verificaciones().stream().map(v -> v.getVinchucaDetectada()).collect(Collectors.toCollection(ArrayList::new));
		
		
		
		for (Verificacion v : m.verificaciones()) {
			int cant = Collections.frequency(tiposVinchucas,v.getVinchucaDetectada());
			int cantTipoAnterior = Collections.frequency(tiposVinchucas,tipoTemp);
			if (cant > cantTipoAnterior) {
				tipoTemp = v.getVinchucaDetectada();
			}
		}
		
		return tipoTemp;
	}
	
	
	public abstract Muestra.Vinchuca getTipoVinchuca(Muestra m) ;
	
	
}
