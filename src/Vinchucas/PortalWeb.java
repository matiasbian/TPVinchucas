package Vinchucas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PortalWeb {
	
	static List<Muestra> muestras = new ArrayList<Muestra>();
	static List<Verificacion> verificaciones = new ArrayList<Verificacion>();
	static List<Participante> participantes = new ArrayList<Participante>();
	static ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();
	
	public static void addMuestra(Muestra m ) {
		muestras.add(m);
	}
	
	public static void addVerificacion(Verificacion v) {
		verificaciones.add(v);
	}
	
	public static void addParticipante(Participante participante) {
		participantes.add(participante);
	}
	
	public static void removeMuestra(Muestra m ) {
		muestras.remove(m);
	}
	
	public static void removeVerificacion(Verificacion v) {
		verificaciones.remove(v);
	}
	
	public static void removeParticipante(Participante p) {
		participantes.remove(p);
	}
	
	public static void addZona(ZonaDeCobertura z) {
		zonas.add(z);
	}
	
	public static void removeZona(ZonaDeCobertura z) {
		zonas.remove(z);
	}

	public static List<Muestra> filtrar(FiltroDeBusqueda f1) {
		return muestras.stream().filter(m -> f1.filtro(m)).collect(Collectors.toList());
	}

	
	public static List<Muestra> getMuestras() {
		return muestras;
	}
	
	public static List<Participante> getParticipantes(){
		return participantes;
	}

	public static List<Verificacion> getVerificaciones() {
		return verificaciones;
	}

	public static ArrayList<ZonaDeCobertura> getZonas() {
		return zonas;
	}

	public static void ResetMuestras() {
		muestras.clear();
	}
	
	public static void ResetVerificaciones() {
		verificaciones.clear();
	}
	
	public static void ResetZonas() {
		zonas.clear();
	}
	
	public static void ResetParticipantes() {
		participantes.clear();
	}
	


public static void notificarOrganizacionDeVerificacion(Muestra m) {
	for (ZonaDeCobertura z : getZonas()) {
		if (m.getUbicacion().estaEnLaZona(z)) {
			z.notificarVerificacion(m);
		}
	}
	
}

public static void notificarOrganizacionDeMuestra(Muestra m) {
	for (ZonaDeCobertura z : getZonas()) {
		if (m.getUbicacion().estaEnLaZona(z)) {
			z.notificarMuestra(m);
		}
	}
	
}


	

}
