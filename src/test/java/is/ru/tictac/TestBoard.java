package is.ru.tictac;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBoard{

	@Test
	public void TestCheckRowTrue(){
		Board b = new Board();
		b.setSize(3);
		char[] row = {'x', 'x', 'x'};
		assertEquals(true, b.checkRow(row));
	}
	
	@Test
	public void TestCheckRowFalse(){
		Board b = new Board();
		b.setSize(3);
		char[] row = {'x', 'o', 'x'};
		assertEquals(false, b.checkRow(row));	
	}
}
