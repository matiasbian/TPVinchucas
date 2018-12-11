package Vinchucas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZonaDeCobertura {
	String nombre;
	Ubicacion epicentro;
	float radio;
	List<Organizacion> organizaciones = new ArrayList<Organizacion>();
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, float radio) {
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
	}
	public void setEpicentro(Ubicacion ub) {
		this.epicentro = ub;
		
	}
	public Ubicacion getEpicentro() {
		return epicentro;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setRadio(float i) {
		this.radio = i;
	}
	public float getRadio() {
		return radio;
	}
	public void registrarse(Organizacion o) {
		organizaciones.add(o);
	}
	public List<Organizacion> getOrganizaciones() {
		return organizaciones;
	}
	public void desRegistrarse(Organizacion o) {
		organizaciones.remove(o);
	}
	
	public List<ZonaDeCobertura> Solapantes(ArrayList<ZonaDeCobertura> zonas) {
		Stream <ZonaDeCobertura> zonasSolapantes = 	zonas.stream().filter(z -> this.epicentro.distanciaEntreDosUbicaciones(z.epicentro) < z.getRadio() + this.getRadio() && z!= this );
		return (ArrayList<ZonaDeCobertura>) zonasSolapantes.collect(Collectors.toList());
	}
	public void notificarMuestra(Muestra m) {
		for (Organizacion o : organizaciones) {
			o.updateMuestra(this, m);
		}
	}
	
	public void notificarVerificacion(Muestra m) {
		for (Organizacion o : organizaciones) {
			o.updateVerificacion(this, m);
		}
	}
	
}
