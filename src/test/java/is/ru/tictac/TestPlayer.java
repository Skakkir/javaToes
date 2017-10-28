package is.ru.tictac;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPlayer{

	@Test
	public void TestGetSymbol(){
		Player p = new Player('X');
		assertEquals('X', p.getSymbol());
	}
}