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

	@Test
	public void TestVerticalTrue(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'X', '5', '6'}, {'X', '8', '9'}});
		assertEquals(true, b.checkVertical());
	}

	@Test
	public void TestVerticalFalse(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'X', '5', '6'}, {'X', '8', '9'}});
		assertEquals(false, b.checkVertical());
	}

	@Test
	public void TestHorizontalTrue(){
		Board b = new Board(3, new char[][] {{'X', 'X', 'X'}, {'4', '5', '6'}, {'7', '8', '9'}});
		assertEquals(true, b.checkHorizontal());
	}

}
