package integrador;

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

}