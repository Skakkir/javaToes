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

	public boolean addToBoard(int num){
		return board.add(num, currentPlayer);
	}

	public char togglePlayer(){
		currentPlayer.toggleMySymbol();
		return currentPlayer.getSymbol();
	}

	public static void main(String[] args) {
		TicTac game = new TicTac();

		int input = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to basic javaToe");
		System.out.println();
		game.getCurrBoard().print();
		System.out.println();
		System.out.println("To exit enter a negative number\n");
		System.out.println();
		System.out.print("\nPlayer " + game.getCurrPlayer() + ", please enter a number:");
		while((input = scanner.nextInt()) > 0) {
			if(game.addToBoard(input)) {
				if (game.isWinner() == 'X'){
					System.out.println("\nWINNER X");				
					game.newBoard();
					System.out.println("\nResetting the Board");
				}else if(game.isWinner() == 'O'){
					System.out.println("\nWINNER O!");
					game.newBoard();
					System.out.println("\nResetting the Board");
				}
				game.togglePlayer();
			}
			System.out.println();							
			game.getCurrBoard().print();
			System.out.print("\nPlayer " + game.getCurrPlayer() + ", please enter a number:");
		}
 	}
}