package is.ru.tictac;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTicTac{
  // Tests if the add to board function is working correctly, adds to cell number 2 and checks then if that cell is occupied.
  @Test
	public void testAddToBoard(){
	  	TicTac game = new TicTac();
      game.addToBoard(2);
      Board board = new Board(3, new char[][] {{'1', 'X', '3'}, {'4', '5', '6'}, {'7', '8', '9'}});
      assertEquals(true, board.checkCellOccupied(0, 1));
  }
  // Tests if the game toggles between players correctly, tests with both X and O, on the first toggle it should be O and second toggle should be X
  @Test
  public void testToggle(){
      TicTac game = new TicTac();
      assertEquals('O', game.togglePlayer());
      assertEquals('X', game.togglePlayer());
  }

  // Tests if IsWinner returns X if we add X in cells number 1, 2 and 3.
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
  // Tests if the reset function works correctly, first it adds to the board on cells 1 and 7 then it resets the board, and then 
  // Checks if any of the cells in the board are occupied and expects false from them all.
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
  // Tests if you can add to a cell that is already occupied.
  @Test
  public void checkCellOccupied(){
    TicTac game = new TicTac();
    game.addToBoard(1);
    game.togglePlayer();
    assertEquals(false, game.addToBoard(1));
  }
  // Tests if the draw function works correctly, first it adds to cells 1, 2, 3 and 4 and checks if the game is a draw, should return false.
  // Then it adds to cells 5 and 6 and checks if the game is a draw should return false. Then it adds 7, 8 and 9 and checks again and it should return true.
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