package is.ru.tictac;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTicTac{

	@Test
	public void TestAddToBoard(){
	  	TicTac game = new TicTac();
      game.addToBoard(2);
      Board board = new Board(3, new char[][] {{'1', 'X', '3'}, {'4', '5', '6'}, {'7', '8', '9'}});
      assertEquals(true, board.checkCellOccupied(0, 1));
   }
}