package Vinchucas;

public class Muestra {
	public enum Vinchuca
	{
	    Vinchuca, ChincheFoliada, PhtiaChinche, Ninguna, ImagenPocoClara
	}
	
	Vinchuca tipoVinchuca;
	String fotoVinchuca;
	Usuario user;
	Ubicacion ubi;
	
	public Muestra (Vinchuca vin, String fotoVin, Ubicacion ubi,Usuario user) {
		this.tipoVinchuca = vin;
		this.fotoVinchuca = fotoVin;
		this.user = user;
		this.ubi = ubi;
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
	
	
}
