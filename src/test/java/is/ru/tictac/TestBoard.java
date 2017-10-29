package is.ru.tictac;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBoard{

	@Test
	public void TestCheckRowTrue(){
		Board b = new Board();
		char[] row = {'x', 'x', 'x'};
		assertEquals(true, b.checkRow(row));
	}

	@Test
	public void TestCheckRowFalse(){
		Board b = new Board();
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

	@Test
	public void TestHorizontalFalse(){
		Board b = new Board(3, new char[][] {{'X', '2', 'X'}, {'4', '5', '6'}, {'7', '8', '9'}});
		assertEquals(false, b.checkHorizontal());
	}

	@Test
	public void TestDiagonalLeftToRight(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'4', 'X', '6'}, {'7', '8', 'X'}});
		assertEquals(true, b.checkDiagonal());
	}

	@Test
	public void TestDiagonalRightToLeft(){
		Board b = new Board(3, new char[][] {{'1', '2', 'X'}, {'4', 'X', '6'}, {'X', '8', '9'}});
		assertEquals(true, b.checkDiagonal());
	}

	@Test
	public void TestDiagonalFalse(){
		Board b = new Board(3, new char[][] {{'1', '2', 'X'}, {'4', '5', '6'}, {'X', '8', '9'}});
		assertEquals(false, b.checkDiagonal());
	}

	@Test
	public void TestCellIsOccupiedTrue(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'4', 'X', '6'}, {'7', '8', '9'}});
		assertEquals(true, b.checkCellOccupied(1, 1));
	}

	@Test
	public void TestCellIsOccupiedFalse(){
		Board b = new Board(3, new char[][] {{'O', 'X', 'O'}, {'X', '5', 'O'}, {'X', 'X', 'X'}});
		assertEquals(false, b.checkCellOccupied(1, 1));
	}

	@Test
	public void TestPosToCoord(){
		Board b = new Board();
		assertEquals(1, b.posToCoord(6)[0]);
		assertEquals(2, b.posToCoord(6)[1]);
		assertEquals(2, b.posToCoord(8)[0]);
		assertEquals(1, b.posToCoord(8)[1]);
	}

	@Test
	public void TestAddTooLargeNumber(){
		Board b = new Board();
		Player p = new Player('X');
		assertEquals(false, b.add(42, p));
	}

	@Test
	public void TestAddTooOccupiedNumber(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'4', 'X', '6'}, {'7', '8', '9'}});
		Player p = new Player('X');
		assertEquals(false, b.add(5, p));
	}

	@Test
	public void TestAddTrue(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'4', 'X', '6'}, {'7', '8', '9'}});
		Player p = new Player('X');
		assertEquals(true, b.add(3, p));
		assertEquals('X', b.getBoard()[0][2]);
	}

	@Test
	public void TestCheckFullFalse(){
		Board b = new Board();
		Player p = new Player('X');
		for(int i = 1; i <= 8; i++){
			b.add(i, p);
		}
		assertEquals(false, b.checkFullBoard());
	}

	@Test
	public void TestCheckFullTrue(){
		Board b = new Board();
		Player p = new Player('X');
		for(int i = 1; i <= 9; i++){
			b.add(i, p);
		}
		assertEquals(true, b.checkFullBoard());
	}

	@Test
	public void testCheckWinnerFalse(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'4', '5', '6'}, {'X', '8', '9'}});
		Player p = new Player('X');
		assertEquals(false, b.checkWinner(p));
	}

	@Test
	public void testCheckWinnerTrue(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'4', 'X', '6'}, {'7', '8', 'X'}});
		Player p = new Player('X');
		assertEquals(true, b.checkWinner(p));
	}

	
}
