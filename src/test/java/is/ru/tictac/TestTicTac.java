package is.ru.tictac;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTicTac{

  @Test
	public void testAddToBoard(){
	  	TicTac game = new TicTac();
      game.addToBoard(2);
      Board board = new Board(3, new char[][] {{'1', 'X', '3'}, {'4', '5', '6'}, {'7', '8', '9'}});
      assertEquals(true, board.checkCellOccupied(0, 1));
  }

  @Test
  public void testToggle(){
      TicTac game = new TicTac();
      assertEquals('O', game.togglePlayer());
      assertEquals('X', game.togglePlayer());
  }

  @Test
  public void testWin(){
    TicTac game = new TicTac();
    game.addToBoard(1); // X inputs
    game.togglePlayer(); 
    game.addToBoard(4); // O inputs
    game.togglePlayer(); 
    game.addToBoard(2); // X inputs
    game.togglePlayer(); 
    game.addToBoard(5); // O inputs
    game.togglePlayer(); 
    game.addToBoard(3); // X inputs
    assertEquals('X', game.isWinner());
  }

  @Test
  public void newBoard(){
    TicTac game = new TicTac();
    game.addToBoard(1);
    game.addToBoard(7);
    Board board = game.getCurrBoard();
    board.reset();
       for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          assertEquals(false, board.checkCellOccupied(i, j));          
        }
      }
  }

  @Test
  public void checkCellOccupied(){
    TicTac game = new TicTac();
    game.addToBoard(1);
    game.togglePlayer();
    assertEquals(false, game.addToBoard(1));
  }

  @Test
  public void checkDraw(){
    TicTac game = new TicTac();
    game.addToBoard(1);
    game.addToBoard(2);
    game.addToBoard(3);
    game.addToBoard(4);
    assertEquals(false, game.isDraw());
    game.addToBoard(5);
    game.addToBoard(6);
    assertEquals(false, game.isDraw());
    game.addToBoard(7);
    game.addToBoard(8);
    game.addToBoard(9);
    assertEquals(true, game.isDraw());
  }
}