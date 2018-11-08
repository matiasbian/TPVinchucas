package Vinchucas;

import java.util.ArrayList;

public class Muestra {
	public enum Vinchuca
	{
	    Vinchuca, ChincheFoliada, PhtiaChinche, Ninguna, ImagenPocoClara
	}
	
	Vinchuca tipoVinchuca;
	String fotoVinchuca;
	Usuario user;
	Ubicacion ubi;
	private NivelVerificacion nivelVerificacion;
	private ArrayList<Verificacion> verificaciones = new ArrayList<Verificacion>();
	
	public Muestra (Vinchuca vin, String fotoVin, Ubicacion ubi,Usuario user) {
		this.tipoVinchuca = vin;
		this.fotoVinchuca = fotoVin;
		this.user = user;
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
		return user.getAlias();
	}
	
	public Ubicacion ubicacion() {
		return ubi;
	}

	public NivelVerificacion getNivelVerificacion() {
		return nivelVerificacion;
	}

	public ArrayList<Verificacion> verificaciones() {
		return verificaciones ;
	}

	public NivelVerificacion getNivelVerificacion(NivelVerificacion n) {
		return nivelVerificacion ;
	}
	
	public void setNivelVerificacion(NivelVerificacion n) {
		nivelVerificacion = n;
	}
	
	
}
