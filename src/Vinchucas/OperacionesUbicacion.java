package integrador;

import java.util.ArrayList;
import java

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

public ArrayList<Ubicacion> ubicacionesAMenosDe(ArrayList<Ubicacion> Ubicaciones, distancia) {
	return ArrayList.
}

public ArrayList<Muestra> muestrasAMenosDe(ArrayList<Muestra> Muestras, distancia) {
	return 
}
	
	
	
}