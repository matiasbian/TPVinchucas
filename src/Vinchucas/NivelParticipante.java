package Vinchucas;

public abstract class NivelParticipante {
	
	public abstract int valorar();
	public void recalculoMiNivel(Participante p) {
		if((p.vMensuales() == 20 && p.muestrasMensuales() == 10) || p.expertoPreviamente()) {
			p.setNivelParticipante(new ParticipanteExperto());
		} else {
			p.setNivelParticipante(new ParticipanteBasico());
		}
	}
}
