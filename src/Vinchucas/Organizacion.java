package Vinchucas;

public class Organizacion{

	public enum TipoOrganizacion {
	    Salud, Educativa, Cultural, Asistencia
	}
	
	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantEmpleados;
	private FuncionalidadExterna funcMuestra;
	private FuncionalidadExterna funcVerificacion;
	
public Organizacion(Ubicacion ubicacion, TipoOrganizacion tipo, int cantidad, FuncionalidadExterna funcMuestra, FuncionalidadExterna funcVerificaciones) {
	this.ubicacion = ubicacion;
	this.tipo = tipo;
    this.cantEmpleados = cantidad;
    this.funcMuestra = funcMuestra;
    this.funcVerificacion = funcVerificaciones;
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

public void updateMuestra(ZonaDeCobertura zona, Muestra muestra) { //Completar
	funcMuestra.NuevoEvento(this, zona, muestra);
}

public void updateVerificacion(ZonaDeCobertura zona, Muestra muestra) { //Completar
	funcVerificacion.NuevoEvento(this, zona, muestra);
}

}
