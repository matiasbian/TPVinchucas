package Vinchucas;

public class Participante{

	
	String nickName;
	NivelParticipante knowledge;
	String envios;
	String revisiones;
	String documentacion;
	private NivelParticipante nivelParticipante;
	
	public Participante(String nick, NivelParticipante knowledge, String envios, String revisiones,String documentacion){
		this.nickName = nickName;
		this.knowledge = knowledge;
		this.envios = envios;
		this.revisiones = revisiones;
		this.documentacion = documentacion;
	}
	
	public String nickName(){
		return nickName;
	}
	
	public NivelParticipante nConocimiento(){
		return knowledge;
	}
	
	public String envios(){
		return envios;
	}
	
	public String revisiones(){
		return revisiones;
	}
	
	public String documentacion(){
		return documentacion;
	}

	public int calidadValoracion() {
		// TODO Auto-generated method stub
		return nivelParticipante.valorar();
	}
}