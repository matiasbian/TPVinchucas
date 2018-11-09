package Vinchucas;

public class Organizaciones{
	@Override
	
	String tipoOrgnizacion;
	int cantPersonal;
	Ubicacion ubi;
	
	public Organizaciones(String tipoOrgnizacion, int cantPersonal, Ubicacion ubi){
		this.tipoOrgnizacion = tipoOrgnizacion;
		this.cantPersonal = cantPersonal;
		this.ubi = ubi;
	}
	
	public Ubicacion ubicacion(){
		return ubi;
	}
	
	public tipoOrgnizacion tipoOrgnizacion(){
		return tipoOrgnizacion;
	}
	
	public cantPersonal personal(){
		return cantPersonal;
	}
}