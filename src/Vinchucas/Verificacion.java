package Vinchucas;

public class Verificacion {

	Participante participante;
	Muestra m;
	Muestra.Vinchuca vinchucaDetectada;

	public int nivelVerif() {
		return (m.tipoVinchuca == vinchucaDetectada) ? participante.calidadValoracion() : 0;
	}

}
