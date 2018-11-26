package Vinchucas;

public class OR extends OperadorLogico {
	
	public OR(FiltroDeBusqueda c1, FiltroDeBusqueda c2) {
		super(c1, c2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean filtro(Muestra m) {
		// TODO Auto-generated method stub
		return this.cond1.filtro(m) || this.cond2.filtro(m);
	}

}
