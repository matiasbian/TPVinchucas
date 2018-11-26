package Vinchucas;

public class Organizacion {

	public enum TipoOrganizacion {
	    Salud, Educativa, Cultural, Asistencia
	}
	
	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantEmpleados;
	
public Organizacion(Ubicacion ubicacion, TipoOrganizacion tipo, int cantidad) {
	this.ubicacion = ubicacion;
	this.tipo = tipo;
        this.cantEmpleados = cantidad;
}

public Ubicacion ubicacion() {
	return this.ubicacion;
}

public TipoOrganizacion tipoDeOrganizacion() {
	return this.tipo;
}

public int cantidadDeEmpleados() {
	return this.cantEmpleados;
}

public void setCantEmpleados(int i) {
	this.cantEmpleados = i;
	
}

public void setUbicacion(Ubicacion ubicacion) {
	this.ubicacion = ubicacion;
	
}

public void setTipo(TipoOrganizacion tipo) {
	this.tipo = tipo;
	
}

public void updateMuestra() { //Completar
	// TODO Auto-generated method stub
	
}

public void updateVerificacion() { //Completar
	// TODO Auto-generated method stub
	
}

}
