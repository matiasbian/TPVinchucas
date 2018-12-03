package Vinchucas;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Participante{

	
	String nickName;
	ArrayList<Muestra> muestras;
	ArrayList<Verificacion> verificaciones;
	private NivelParticipante nivelParticipante;
	Boolean ExpertoDeFormaExterna;

	
	public Participante(String nick, NivelParticipante knowledge){
		this.nickName = nick;
		this.nivelParticipante = knowledge;
		muestras = new ArrayList<Muestra>();
		verificaciones = new ArrayList<Verificacion>();
		if(this.nivelParticipante.getClass() == ParticipanteExperto.class) {
			this.ExpertoDeFormaExterna = true;
		}
	}
	
	public String nickName(){
		return nickName;
	}
	
	public boolean expertoPreviamente() {
		return this.ExpertoDeFormaExterna;
	}
	
	public NivelParticipante nConocimiento(){
		nivelParticipante.recalculoMiNivel(this);
		return nivelParticipante;
	}
	
	public void setNivelParticipante(NivelParticipante n) {
		nivelParticipante = n;
	}

	
	public int calidadValoracion() {
		return nivelParticipante.valorar();
	}
	
	
	public void addMuestra(Muestra m) {
		muestras.add(m);
	}
	
	public void addVerificacion(Verificacion v) {
		verificaciones.add(v);
		
	}
	
	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}
	
	public ArrayList<Verificacion> getVerificaciones() {
		return verificaciones;
	}
	
	public int vMensuales() {
		int total=0;
		Calendar fecha = Calendar.getInstance();
		int mes = fecha.get(Calendar.MONTH);
		Calendar fecha2 = Calendar.getInstance();
		
		for (Verificacion v : getVerificaciones()) {
			fecha2.setTime(v.getDate());
			int mes2 = fecha2.get(Calendar.MONTH);
			if(mes == mes2) {
				total ++;
			}
		}
		return total;
	}
	
	public int muestrasMensuales() {
		int total=0;
		Calendar fecha = Calendar.getInstance();
		int mes = fecha.get(Calendar.MONTH);
		Calendar fecha2 = Calendar.getInstance();
		
		for (Muestra m : getMuestras()) {
			fecha2.setTime(m.getFechaDeCreacion());
			int mes2 = fecha2.get(Calendar.MONTH);
			if(mes == mes2) {
				total ++;
			}
		}
		return total;
	}
}