package is.ru.tictac;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.jetty.util.ReadLineInputStream;


public class TicTac {

	private Board board;
	private Player currentPlayer;
	private char noWinner;

	public TicTac(){
		noWinner = 'N';	
		newBoard();
	}
	
	public char getCurrPlayer(){
		return currentPlayer.getSymbol();
	}
	public Board getCurrBoard(){
		return board;
	}

	public void newBoard(){
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

		int input;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to basic javaToe");		
		while((input = scanner.nextInt()) > 0) {
			game.addToBoard(input);
			if (game.isWinner() == 'X'){
				System.out.println("WINNER X");				
				break;
			}else if(game.isWinner() == 'O'){
				System.out.println("WINNER O!");
				break;
			}
			game.togglePlayer();
			game.getCurrBoard().print();
		}
 	}
}