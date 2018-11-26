package Vinchucas;

public class NivelDeValidacion extends FiltroDeBusqueda {
	NivelVerificacion n;
	public NivelDeValidacion(NivelVerificacion nv) {
		this.n = nv;
	}

	@Override
	public Boolean filtro(Muestra m) {
		return n.getClass() == m.getNivelVerificacion().getClass();
	}

}
