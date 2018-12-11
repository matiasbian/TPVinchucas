package Vinchucas;

import java.util.ArrayList;

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

public  double distanciaEntreDosUbicaciones(Ubicacion ubi2) {  
    double radioTierra = 6371; //en kil�metros
    double dLat = Math.toRadians(ubi2.latitud() - this.latitud());
    double dLng = Math.toRadians(ubi2.longitud() - this.longitud());  
    double sindLat = Math.sin(dLat / 2);
    double sindLng = Math.sin(dLng / 2);
    double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                 * Math.cos(Math.toRadians(this.latitud())) * Math.cos(Math.toRadians(ubi2.latitud()));  
    double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
    double distancia = radioTierra * va2;

    return distancia;
}


public  ArrayList<Ubicacion> ubicacionesAMenosDe(ArrayList<Ubicacion> ubicaciones,float distancia) {
	ArrayList<Ubicacion> ubics = new ArrayList<Ubicacion>();
	for (Ubicacion u : ubicaciones) {
		if (u !=  this && this.distanciaEntreDosUbicaciones( this) < distancia) {
			ubics.add(u);
		}
	}
	
	return ubics;
}

public  Boolean estaEnLaZona(  ZonaDeCobertura z) {
	return this.distanciaEntreDosUbicaciones( z.epicentro) < z.radio;
}


}
