package is.ru.tictac;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.jetty.util.ReadLineInputStream;


public class TicTac {

	private Board board;
	private Player currentPlayer;
	private char noWinner;
	// Constructor, makes an empty board.
	public TicTac(){
		noWinner = 'N';	
		newBoard();
	}
	// Returns the symbol of the current player playing.
	public char getCurrPlayer(){
		return currentPlayer.getSymbol();
	}
	// Returns the board.
	public Board getCurrBoard(){
		return board;
	}

	// Makes an new empty board.
	public void newBoard(){
		board = new Board();
		currentPlayer = new Player('X');
	}

	// Returns the symbol of the player that won, if there is no winner it returns noWinner.
	public char isWinner(){
		if (board.checkWinner(currentPlayer)){
			return currentPlayer.getSymbol();
		}
		return noWinner;
	}

	//returns true if it was successful to add to the board.
	public boolean addToBoard(int num){
		return board.add(num, currentPlayer);
	}

	//returns true if the board is full.
	public boolean isDraw() {
		return board.checkFullBoard();
	}

	// Returns the symbol of the player that has the next turn.
	public char togglePlayer(){
		currentPlayer.toggleMySymbol();
		return currentPlayer.getSymbol();
	}
	// Runs the game while players enter a non negative number, resets if they game is won or a draw. Keeps asking players for
	// numbers to put ther symbols in and toogles the players after each round.
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
				else if (game.isDraw()) {
					System.out.println("\nIT'S A DRAW!");
					game.newBoard();
					System.out.println("\nResetting the Board");
				}
				else {
					game.togglePlayer();
				}
			}
			System.out.println();							
			game.getCurrBoard().print();
			System.out.print("\nPlayer " + game.getCurrPlayer() + ", please enter a number:");
		}
 	}
}