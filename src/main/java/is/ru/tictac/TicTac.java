package is.ru.tictac;
import java.io.IOException;
import java.util.Scanner;


public class TicTac {

	private Board board = new Board();
	private Player currentPlayer = new Player('X');
	
	public void addToBoard(int num){
		board.add(num, currentPlayer);
	}

	public char togglePlayer(){
		currentPlayer.toggleMySymbol();
		return currentPlayer.getSymbol();
	}

	public static void main(String[] args) {
		TicTac game = new TicTac();
		game.addToBoard(2);
		game.addToBoard(3);
		game.addToBoard(6);
		System.out.println(game.togglePlayer());
		game.addToBoard(7);
		System.out.println(game.togglePlayer());
		game.board.print();
 	}

}