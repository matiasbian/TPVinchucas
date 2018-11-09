package Vinchucas;

import java.util.ArrayList;

public class Participante{

	
	String nickName;
	ArrayList<Muestra> muestras;
	ArrayList<Verificacion> verificaciones;
	private NivelParticipante nivelParticipante;
	
	public Participante(String nick, NivelParticipante knowledge){
		this.nickName = nick;
		this.nivelParticipante = knowledge;
		muestras = new ArrayList<Muestra>();
		verificaciones = new ArrayList<Verificacion>();
	}
	
	public String nickName(){
		return nickName;
	}
	
	public NivelParticipante nConocimiento(){
		return nivelParticipante;
	}
	
	public ArrayList<Muestra> muestras(){
		return muestras;
	}
	
	public ArrayList<Verificacion> verificaciones(){
		return verificaciones;
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
}