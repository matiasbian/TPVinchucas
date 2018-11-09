package Vinchucas;

import java.util.ArrayList;

public class OperacionesUbicacion {

public static double distanciaEntreDosUbicaciones(Ubicacion ubi1, Ubicacion ubi2) {  
        double radioTierra = 6371; //en kilómetros
        double dLat = Math.toRadians(ubi2.latitud() - ubi1.latitud());
        double dLng = Math.toRadians(ubi2.longitud() - ubi1.longitud());  
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                     * Math.cos(Math.toRadians(ubi1.latitud())) * Math.cos(Math.toRadians(ubi2.latitud()));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distancia;
}

public ArrayList<Ubicacion> ubicacionesAMenosDe(ArrayList<Ubicacion> ubicaciones,float distancia) {
	ArrayList<Ubicacion> ubics = new ArrayList<Ubicacion>();
	for (Ubicacion u : ubicaciones) {
		ubics.addAll(this.ubicacionesCercanas(ubicaciones, u, distancia));
	}
	this.borroDuplicadosU(ubics);
	return ubics;
}

public ArrayList<Muestra> muestrasAMenosDe(ArrayList<Muestra> muestras,float distancia) {
	
	ArrayList<Muestra> muestrass = new ArrayList<Muestra>();
	for (Muestra m : muestras) {
		muestrass.addAll(this.muestrasCercanas(muestrass, m, distancia));
	}
	this.borroDuplicados(muestrass);
	return muestrass;
}
	


private ArrayList<Muestra> muestrasCercanas (ArrayList<Muestra> muestras, Muestra m,float distancia){
	ArrayList<Muestra> muestrass = new ArrayList<Muestra>();
	for (Muestra m2 : muestras) {
		if (m !=  m2 && this.distanciaEntreDosUbicaciones(m.getUbicacion(), m2.getUbicacion()) < distancia) {
			muestrass.add(m);
		}
	}
	return muestrass;
}

private ArrayList<Ubicacion> ubicacionesCercanas (ArrayList<Ubicacion> ubicaciones, Ubicacion ubi,float distancia){
	ArrayList<Ubicacion> ubics = new ArrayList<Ubicacion>();
	for (Ubicacion u : ubicaciones) {
		if (u !=  ubi && this.distanciaEntreDosUbicaciones(u, ubi) < distancia) {
			ubics.add(u);
		}
	}
	
	return ubics;
}

private void borroDuplicados(ArrayList<Muestra> l) {
	for(int i=0;i<l.size();i++){
		for(int j=0;j<l.size()-1;j++){
			if(i!=j){
				if(l.get(i)==l.get(j)){
					l.remove(i);
				}
			}
		}
	}
}

private void borroDuplicadosU(ArrayList<Ubicacion> l) {
	for(int i=0;i<l.size();i++){
		for(int j=0;j<l.size()-1;j++){
			if(i!=j){
				if(l.get(i)==l.get(j)){
					l.remove(i);
				}
			}
		}
	}
}


}
