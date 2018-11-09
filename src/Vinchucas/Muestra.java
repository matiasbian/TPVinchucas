package Vinchucas;

import java.util.ArrayList;

public class Muestra {
	public enum Vinchuca
	{
	    Vinchuca, ChincheFoliada, PhtiaChinche, Ninguna, ImagenPocoClara
	}
	
	Vinchuca tipoVinchuca;
	String fotoVinchuca;
	Participante user;
	Ubicacion ubi;
	private NivelVerificacion nivelVerificacion;
	private ArrayList<Verificacion> verificaciones = new ArrayList<Verificacion>();
	
	public Muestra (Vinchuca vin, String fotoVin, Ubicacion ubi,Participante usuario) {
		this.tipoVinchuca = vin;
		this.fotoVinchuca = fotoVin;
		this.user = usuario;
		this.ubi = ubi;
		this.nivelVerificacion = new Bajo();
	}
	
	public Vinchuca tipoVinchucaFotog() {
		return tipoVinchuca;
	}
	
	public String fotoVinchuca() {
		return fotoVinchuca;
	}
	
	public String aliasUsuario() {
		return user.nickName();
	}
	
	public Ubicacion ubicacion() {
		return ubi;
	}

	public NivelVerificacion getNivelVerificacion() {
		nivelVerificacion.calcular(this);
		return nivelVerificacion;
	}

	public ArrayList<Verificacion> verificaciones() {
		return verificaciones ;
	}
	
	public void addVerificaciones(Verificacion v) {
		verificaciones.add(v) ;
	}

	public NivelVerificacion getNivelVerificacion(NivelVerificacion n) {
		return nivelVerificacion ;
	}
	
	public void setNivelVerificacion(NivelVerificacion n) {
		nivelVerificacion = n;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubi;
	}
}
