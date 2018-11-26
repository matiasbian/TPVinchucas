package Vinchucas;

public class AND extends OperadorLogico {

	public AND(FiltroDeBusqueda c1, FiltroDeBusqueda c2) {
		super(c1, c2);
	}




	@Override
	public Boolean filtro(Muestra m) {
		return cond1.filtro(m) && cond2.filtro(m);
	}

}
