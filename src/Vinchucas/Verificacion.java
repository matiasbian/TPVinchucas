package Vinchucas;

import java.util.Collections;
import java.util.Date;

public class Verificacion {

	Participante participante;
	Muestra m;
	Muestra.Vinchuca vinchucaDetectada;
	Date fecha;
	
	public Verificacion(Participante p, Muestra m, Muestra.Vinchuca tv) {
		this.participante = p;
		this.m = m;
		this.vinchucaDetectada = tv;
		fecha = new Date();
		PortalWeb.notificarOrganizacionDeVerificacion(m);
		PortalWeb.addVerificacion(this);
	}

	public void setParticipante(Participante p) {
		this.participante =p;
	}
	
	public Participante getParticipante () {
		return this.participante;
	}
	
	public void setMuestra(Muestra m) {
		this.m = m;
	}
	
	public Muestra getMuestra() {
		return this.m;
	}
	
	public void setVinchucaDetectada(Muestra.Vinchuca v) {
		this.vinchucaDetectada = v;
	}
	
	public Muestra.Vinchuca getVinchucaDetectada(){
		return this.vinchucaDetectada;
	}
	public int nivelVerif() {
		int apareciones = Collections.frequency(m.verificaciones(), vinchucaDetectada);
		return (m.tipoVinchucaFotog() == this.getVinchucaDetectada() || apareciones > 1) ? participante.calidadValoracion() : 0; // si aparece mas de una vez en la lista, significa que otro opino igual que el, entonces deberia pasar a nivelMedio de verificacion
	}

	public Date getDate() {
		return fecha;
	}

	
}
