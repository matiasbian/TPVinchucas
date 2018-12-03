package Vinchucas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacionesUbicacion {

public static double distanciaEntreDosUbicaciones(Ubicacion ubi1, Ubicacion ubi2) {  
        double radioTierra = 6371; //en kil�metros
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

public static ArrayList<Ubicacion> ubicacionesAMenosDe(ArrayList<Ubicacion> ubicaciones,float distancia) {
	ArrayList<Ubicacion> ubics = new ArrayList<Ubicacion>();
	for (Ubicacion u : ubicaciones) {
		ubics.addAll(ubicacionesCercanas(ubicaciones, u, distancia));
	}
	borroDuplicadosU(ubics);
	return ubics;
}

public static ArrayList<Muestra> muestrasAMenosDe(ArrayList<Muestra> muestras,float distancia) {
	
	ArrayList<Muestra> muestrass = new ArrayList<Muestra>();
	for (Muestra m : muestras) {
		muestrass.addAll(muestrasCercanas(muestrass, m, distancia));
	}
	borroDuplicados(muestrass);
	return muestrass;
}

public static ArrayList<ZonaDeCobertura> zonasSolapantes (ZonaDeCobertura zc1,ArrayList<ZonaDeCobertura> zonas) {
	
	Stream <ZonaDeCobertura> zonasSolapantes = 	zonas.stream().filter(z -> distanciaEntreDosUbicaciones(zc1.epicentro,z.epicentro) < zc1.getRadio() + z.getRadio() && z!= zc1 );
	
	
	return (ArrayList<ZonaDeCobertura>) zonasSolapantes.collect(Collectors.toList());
}
	


private static ArrayList<Muestra> muestrasCercanas (ArrayList<Muestra> muestras, Muestra m,float distancia){
	ArrayList<Muestra> muestrass = new ArrayList<Muestra>();
	for (Muestra m2 : muestras) {
		if (m !=  m2 && distanciaEntreDosUbicaciones(m.getUbicacion(), m2.getUbicacion()) < distancia) {
			muestrass.add(m);
		}
	}
	return muestrass;
}

private static ArrayList<Ubicacion> ubicacionesCercanas (ArrayList<Ubicacion> ubicaciones, Ubicacion ubi,float distancia){
	ArrayList<Ubicacion> ubics = new ArrayList<Ubicacion>();
	for (Ubicacion u : ubicaciones) {
		if (u !=  ubi && distanciaEntreDosUbicaciones(u, ubi) < distancia) {
			ubics.add(u);
		}
	}
	
	return ubics;
}

private static void borroDuplicados(ArrayList<Muestra> l) {
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

private static void borroDuplicadosU(ArrayList<Ubicacion> l) {
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

public static void notificarOrganizacionDeVerificacion(Muestra m) {
	for (ZonaDeCobertura z : BaseDeDatos.getZonas()) {
		if (estaEnLaZona(m.ubicacion(),z)) {
			z.notificarVerificacion(m);
		}
	}
	
}

public static void notificarOrganizacionDeMuestra(Muestra m) {
	for (ZonaDeCobertura z : BaseDeDatos.getZonas()) {
		if (estaEnLaZona(m.ubicacion(),z)) {
			z.notificarMuestra(m);
		}
	}
	
}

private static Boolean estaEnLaZona(Ubicacion u, ZonaDeCobertura z) {
	return distanciaEntreDosUbicaciones(u, z.epicentro) < z.radio;
}


}
