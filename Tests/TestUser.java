import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Vinchucas.Usuario;;
class TestUser {
	Usuario user;
	
	@Test
	void testAlias() {
		user = new Usuario();
		assertEquals(user.getAlias(), "");
	}
	
}
