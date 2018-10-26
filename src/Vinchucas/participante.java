package Vinchucas;

public class Participante{

	public enum nivelConocimiento{
		basico, experto;
	}
	
	String nickName;
	nivelConocimiento knowledge;
	String envios;
	String revisiones;
	String documentacion;
	
	public Participante(String nick, nivelConocimiento knowledge, String envios, String revisiones,String documentacion){
		this.nickName = nickName;
		this.nivelConocimiento = knowledge;
		this.envios = envios;
		this.revisiones = revisiones;
		this.documentacion = documentacion;
	}
	
	public String nickName(){
		return nickName;
	}
	
	public nivelConocimiento nConocimiento(){
		return nivelConocimiento;
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
}