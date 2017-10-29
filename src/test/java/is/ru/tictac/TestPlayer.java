package is.ru.tictac;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPlayer{
	// Tests if the getSymbol function is returing the correct symbol corresponding to the player that is playing.
	@Test
	public void TestGetSymbol(){
		Player p = new Player('X');
		assertEquals('X', p.getSymbol());
	}
}