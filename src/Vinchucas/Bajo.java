package Vinchucas;

public class Bajo extends NivelVerificacion {

	@Override
	public void calcular(Muestra m) {
		int ptsVerificacion = m.verificaciones().stream().mapToInt(v -> v.nivelVerif()).sum();
		if (ptsVerificacion == 2) {
			m.setNivelVerificacion(new Medio());
		}else if (ptsVerificacion >= 2) {
			m.setNivelVerificacion(new Alto());
		}
	}

}
