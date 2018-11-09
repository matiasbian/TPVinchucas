package integrador;

public class Ubicacion {

	private double latitud;
	private double longitud;
	
public Ubicacion (double lat, double lon) {
	this.latitud = lat;
	this.longitud = lon;
}


public double latitud() {
	return this.latitud;
}

public double longitud() {
	return this.longitud;
}

}