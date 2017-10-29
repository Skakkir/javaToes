package is.ru.tictac;
public class Player {

	private char symbol = '\0';

	Player(){}
	// initialize the symbol for the player.
	Player(char symbol){
		this.symbol = symbol;
	}
	// returns the symbol.
	public char getSymbol(){
		return symbol;
	}
	// Toggles the symbol, if its X its toggled to O and vise versa.
	public void toggleMySymbol(){
		if (this.symbol == 'X'){
			this.symbol = 'O';
		}else {
			this.symbol = 'X';
		}
	}
}