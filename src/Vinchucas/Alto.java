package Vinchucas;

public class Alto extends NivelVerificacion {

	@Override
	public void calcular(Muestra m) {
		int ptsVerificacion = m.verificaciones().stream().mapToInt(v -> v.nivelVerif()).sum();
		if (ptsVerificacion == 1) {
			m.setNivelVerificacion(new Bajo());
		}else if (ptsVerificacion == 2) {
			m.setNivelVerificacion(new Medio());
		}

	}

}
