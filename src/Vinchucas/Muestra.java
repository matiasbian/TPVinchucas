package Vinchucas;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

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
	Date fechaCreacion;
	
	public Muestra (Vinchuca vin, String fotoVin, Ubicacion ubi,Participante usuario) {
		this.tipoVinchuca = vin;
		this.fotoVinchuca = fotoVin;
		this.user = usuario;
		this.ubi = ubi;
		this.nivelVerificacion = new Bajo();
		PortalWeb.notificarOrganizacionDeMuestra(this);
		PortalWeb.addMuestra(this);
		this.fechaCreacion = new Date();
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
		
		return nivelVerificacion.calcular(this);
	}

	public ArrayList<Verificacion> verificaciones() {
		return verificaciones ;
	}
	
	public void addVerificaciones(Verificacion v) {
		verificaciones.add(v) ;
	}

	
	public void setNivelVerificacion(NivelVerificacion n) {
		nivelVerificacion = n;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubi;
	}

	public Date getFechaDeCreacion() {
		return fechaCreacion;
	}
	
	public  ArrayList<Muestra> muestrasAMenosDe(ArrayList<Muestra> muestras,float distancia) {
		ArrayList<Muestra> muestrass = new ArrayList<Muestra>();
		for (Muestra m2 : muestras) {
			if (this !=  m2 && this.ubi.distanciaEntreDosUbicaciones( m2.getUbicacion()) < distancia) {
				muestrass.add(m2);
			}
		}
		return muestrass;
	}
	
}
