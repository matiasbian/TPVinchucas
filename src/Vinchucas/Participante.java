package Vinchucas;

import java.util.ArrayList;

public class Participante{

	
	String nickName;
	NivelParticipante knowledge;
	ArrayList<Muestra> muestras;
	ArrayList<Verificacion> verificaciones;
	private NivelParticipante nivelParticipante;
	
	public Participante(String nick, NivelParticipante knowledge, String envios, String revisiones,String documentacion){
		this.nickName = nickName;
		this.knowledge = knowledge;
	}
	
	public String nickName(){
		return nickName;
	}
	
	public NivelParticipante nConocimiento(){
		return knowledge;
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
}