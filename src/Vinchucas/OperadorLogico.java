package Vinchucas;

public abstract class OperadorLogico extends FiltroDeBusqueda {
	FiltroDeBusqueda cond1,cond2;
	public OperadorLogico(FiltroDeBusqueda c1,FiltroDeBusqueda c2) {
		this.cond1 = c1;
		this.cond2 = c2;
	}
}
