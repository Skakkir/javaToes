package is.ru.tictac;
public class Player {

	private char symbol = '\0';

	Player(){}

	Player(char symbol){
		this.symbol = symbol;
	}

	public char getSymbol(){
		return symbol;
	}

	public void toggleMySymbol(){
		if (this.symbol == 'X'){
			this.symbol = 'O';
		}else {
			this.symbol = 'X';
		}
	}
}