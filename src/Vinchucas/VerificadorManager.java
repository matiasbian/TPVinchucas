package Vinchucas;

import java.util.ArrayList;

public class VerificadorManager {
	ArrayList<Verificacion> verificaciones = new ArrayList<Verificacion>();
	
	public enum Nivel
	{
	    Alto, Medio, Bajo
	}
	public Nivel nivelVerificacion() {
		int lvlVerif =  verificaciones.stream().mapToInt( v -> v.resultadoVerif() ).sum() ;
		if (lvlVerif >= 3) {
			return Nivel.Alto;
		}else if (lvlVerif == 2) {
			return Nivel.Medio;
		}else {
			return Nivel.Bajo;
		}
	}

	public void agregarVerificacion(Verificacion verif) {
		verificaciones.add(verif);
	}

}
