package is.ru.tictac;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBoard{
	// Tests if checkRow returns true if all symbols in that row are x.
	@Test
	public void TestCheckRowTrue(){
		Board b = new Board();
		char[] row = {'x', 'x', 'x'};
		assertEquals(true, b.checkRow(row));
	}
	// Tests if checkRow returns false if not all symbols in that row are the same.
	@Test
	public void TestCheckRowFalse(){
		Board b = new Board();
		char[] row = {'x', 'o', 'x'};
		assertEquals(false, b.checkRow(row));	
	}
	// Tests if checkVertical returns true if all symbols in that vertical line are x.
	@Test
	public void TestVerticalTrue(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'X', '5', '6'}, {'X', '8', '9'}});
		assertEquals(true, b.checkVertical());
	}
	// Tests if checkVertical returns false if not all symbols in that vertical line are  the same.
	@Test
	public void TestVerticalFalse(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'X', '5', '6'}, {'X', '8', '9'}});
		assertEquals(false, b.checkVertical());
	}
	// Test if checkHorizontal returns true if all symbols in that horizontal line are x.
	@Test
	public void TestHorizontalTrue(){
		Board b = new Board(3, new char[][] {{'X', 'X', 'X'}, {'4', '5', '6'}, {'7', '8', '9'}});
		assertEquals(true, b.checkHorizontal());
	}
	// Tests if checkHorizontal returns false if not all symbols in that horizontal line are  the same.
	@Test
	public void TestHorizontalFalse(){
		Board b = new Board(3, new char[][] {{'X', '2', 'X'}, {'4', '5', '6'}, {'7', '8', '9'}});
		assertEquals(false, b.checkHorizontal());
	}

	// Tests if checkDiagonal returns true if all symbols in that Diagonal line are X from left to right.
	@Test
	public void TestDiagonalLeftToRight(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'4', 'X', '6'}, {'7', '8', 'X'}});
		assertEquals(true, b.checkDiagonal());
	}

	// Tests if checkDiagonal returns true if all symbols in that Diagonal line are X from right to left.
	@Test
	public void TestDiagonalRightToLeft(){
		Board b = new Board(3, new char[][] {{'1', '2', 'X'}, {'4', 'X', '6'}, {'X', '8', '9'}});
		assertEquals(true, b.checkDiagonal());
	}
	// Tests if checkDiagonal returns false if not all symbols in that diagonal line are the same.
	@Test
	public void TestDiagonalFalse(){
		Board b = new Board(3, new char[][] {{'1', '2', 'X'}, {'4', '5', '6'}, {'X', '8', '9'}});
		assertEquals(false, b.checkDiagonal());
	}
	// Tests if checkSellOccupied returns true if there is an X in the cell that is checked.
	@Test
	public void TestCellIsOccupiedTrue(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'4', 'X', '6'}, {'7', '8', '9'}});
		assertEquals(true, b.checkCellOccupied(1, 1));
	}
	// Tests if checkCellOccupied returns false if there is not an X or an O in the cell that is checked.
	@Test
	public void TestCellIsOccupiedFalse(){
		Board b = new Board(3, new char[][] {{'O', 'X', 'O'}, {'X', '5', 'O'}, {'X', 'X', 'X'}});
		assertEquals(false, b.checkCellOccupied(1, 1));
	}
	// Tests if posToCoord returns the correct number from certain inputs.
	@Test
	public void TestPosToCoord(){
		Board b = new Board();
		assertEquals(1, b.posToCoord(6)[0]);
		assertEquals(2, b.posToCoord(6)[1]);
		assertEquals(2, b.posToCoord(8)[0]);
		assertEquals(1, b.posToCoord(8)[1]);
	}
	// Tests if the add function allows players to put numbers in that are bigger than the board, should return false.
	@Test
	public void TestAddTooLargeNumber(){
		Board b = new Board();
		Player p = new Player('X');
		assertEquals(false, b.add(42, p));
	}
	// Tests if the add function allows players to put in cells that are occupied, should return false.
	@Test
	public void TestAddTooOccupiedNumber(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'4', 'X', '6'}, {'7', '8', '9'}});
		Player p = new Player('X');
		assertEquals(false, b.add(5, p));
	}
	// Tests if the add function works properly, by adding into a cell that is not occupied and then checking if that
	// cell has an X in it.
	@Test
	public void TestAddTrue(){
		Board b = new Board(3, new char[][] {{'1', '2', '3'}, {'4', 'X', '6'}, {'7', '8', '9'}});
		Player p = new Player('X');
		assertEquals(true, b.add(3, p));
		assertEquals('X', b.getBoard()[0][2]);
	}
	// Tests if checkFullBoard returns false if cells from 1-8 are occupied.
	@Test
	public void TestCheckFullFalse(){
		Board b = new Board();
		Player p = new Player('X');
		for(int i = 1; i <= 8; i++){
			b.add(i, p);
		}
		assertEquals(false, b.checkFullBoard());
	}
	// Tests if checkFullBoard returns true if all cells are occupied.
	@Test
	public void TestCheckFullTrue(){
		Board b = new Board();
		Player p = new Player('X');
		for(int i = 1; i <= 9; i++){
			b.add(i, p);
		}
		assertEquals(true, b.checkFullBoard());
	}
	// Tests if checkWinner returns false when there is no winner.
	@Test
	public void testCheckWinnerFalse(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'4', '5', '6'}, {'X', '8', '9'}});
		Player p = new Player('X');
		assertEquals(false, b.checkWinner(p));
	}
	// Tests if checkWinner returns true when there is a winner.
	@Test
	public void testCheckWinnerTrue(){
		Board b = new Board(3, new char[][] {{'X', '2', '3'}, {'4', 'X', '6'}, {'7', '8', 'X'}});
		Player p = new Player('X');
		assertEquals(true, b.checkWinner(p));
	}

	
}
