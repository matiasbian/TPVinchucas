import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Vinchucas.Bajo;
import Vinchucas.Muestra;
import Vinchucas.Muestra.Vinchuca;
import Vinchucas.Ubicacion;
import Vinchucas.Usuario;
import Vinchucas.Participante;
import Vinchucas.NivelParticipante;

import static org.mockito.Mockito.*;

class Participante{
	
	Participante participante1;
	NivelParticipante nivelParticipante1;
	
	@Before
	void Init() {
		participante1 = mock(Participante.class);
		nivelParticipante1 = mock(NivelParticipante.class);
	}
	
	@Test
	void verificoName(){
		participante1 = Participante("NoName", 1, "", "","");
		assertEquals("NoName", participante1.nickName());
	}
	
	@Test
	void verificoNConocimiento (){
		participante1 = Participante("NoName", 1, "", "","");
		assertEquals(1, participante1.nConocimiento());
	}
	
	@Test
	void verifico envios (){
		participante1 = Participante("NoName", 1, "VinchucaQuilmes.bmp", "","");
		assertEquals("vinchucaQuilmes.bmp", participante1.envios());
	}
	
	@Test
	void verificoRevisiones (){
		participante1 = Participante("NoName", 1, "VinchucaQuilmes.bmp", "VinchucaVarela.bmp,VinchucaZolano.bmp","");
		assertEquals("VinchucaVarela.bmp,VinchucaZolano.bmp", participante1.revisiones());
	}
	
	@Test
	void verificoDocumentacion(){
		participante1 = Participante("NoName", 1, "VinchucaQuilmes.bmp", "VinchucaVarela.bmp,VinchucaZolano.bmp","sinPresentar");
		assertEquals("sinPresentar", participante1.documentacion());
	}
	
	/*@Test
	void verificoValoracion(){
		participante1 = Participante("NoName", 1, "VinchucaQuilmes.bmp", "VinchucaVarela.bmp,VinchucaZolano.bmp","sinPresentar");
		assertEquals(0, participante1.calidadValoracion());
	}*/
	
}