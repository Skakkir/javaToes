package is.ru.tictac;
import java.io.IOException;
import java.util.Scanner;


public class TicTac {

	private Board board;
	private Player currentPlayer;
	private char noWinner;

	public TicTac(){
		noWinner = 'N';	
		board = new Board();
		currentPlayer = new Player('X');
	}
	
	public char isWinner(){
		if (board.checkWinner(currentPlayer)){
			return currentPlayer.getSymbol();
		}
		return noWinner;
	}

	public void addToBoard(int num){
		board.add(num, currentPlayer);
	}

	public char togglePlayer(){
		currentPlayer.toggleMySymbol();
		return currentPlayer.getSymbol();
	}

	public static void main(String[] args) {
		TicTac game = new TicTac();

		game.addToBoard(1);
		System.out.println(game.togglePlayer());
		game.addToBoard(4);
		System.out.println(game.togglePlayer());
		game.addToBoard(3);
		System.out.println(game.togglePlayer());
		game.addToBoard(5);
		System.out.println(game.togglePlayer());
		game.addToBoard(2);
		System.out.println("Winner: " + game.isWinner());
	
		game.board.print();
 	}

}