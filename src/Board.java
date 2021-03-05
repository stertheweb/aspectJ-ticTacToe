public class Board {

	private String[][] ticTacToe;
	private int rows = 3;
	private int columns = 3;
	private String playerOne = "X";
	private String playerTwo = "O";
	private String emptySpace = "\\s{3}";
	
	//default constructor
	public Board() {
		ticTacToe = new String[rows][columns];
		this.initialize();
	}
	
	//initialize the board
	public void initialize() {
		int i = 0;
		int j = 0;
		for(i = 0; i < rows; i++) {
			for(j = 0; j < columns; j++) {
				ticTacToe[i][j] = "   ";
			}
		}
	}
	
	//display the game board
	public String display() {
		String game = "";
		int i = 0;
		int j = 0;
		for(i = 0; i < rows; i++) {
			for(j = 0; j < columns; j++) {
				if(j == columns - 1) {
					game += ticTacToe[i][j];
				} else {
					game += ticTacToe[i][j] + "|";
				}
			}
			if(i != rows - 1) {
				game += "\n--- --- ---\n";
			}
		}
		return game;
	}
	
	//play turn
	public boolean play(int row, int column, int player) {
		String letter = "C";
		if(player == 1) {
			letter = playerOne;
		}
		else if(player == 2) {
			letter = playerTwo;
		}
		
		if(ticTacToe[row][column].matches(emptySpace)) {
			ticTacToe[row][column] = " " + letter + " ";
			return true;
		} else {
			System.out.println("ERROR: Cell full.");
			return false;
		}
	}
	
	//check for winner
	public boolean winCheck() {
		return winner() || endGame();
	}
	
	//verify win
	public boolean winner() {
		int i = 0;
		int j = 0;
    	for(i = 0; i < rows; i++) {
    		if(!ticTacToe[i][0].matches(emptySpace) && ticTacToe[i][0].equals(ticTacToe[i][1]) && ticTacToe[i][1].equals(ticTacToe[i][2])) {    			
    			return true; 
    		}   			 			
    	}

    	for(j = 0; j < columns; j++) {    		
    		if(!ticTacToe[0][j].matches(emptySpace) && ticTacToe[0][j].equals(ticTacToe[1][j]) && ticTacToe[1][j].equals(ticTacToe[2][j])) 
    			return true;  			
    	}
    	//checking diagonals
    	if(!ticTacToe[0][0].matches(emptySpace) && ticTacToe[0][0].equals(ticTacToe[1][1]) && ticTacToe[1][1].equals(ticTacToe[2][2]))
    		return true;
    	if(!ticTacToe[0][2].matches(emptySpace) && ticTacToe[0][2].equals(ticTacToe[1][1]) && ticTacToe[1][1].equals(ticTacToe[2][0]))
    		return true;
    	return false;	
	}
	
	//verify that the game is over
	public boolean endGame() {
		int i = 0;
		int j = 0;
		for(i = 0; i < rows; i++) {
			for(j = 0; j < columns; j++) {
				if(ticTacToe[i][j].matches(emptySpace)) {
					return false;
				}
			}
		}
		return true;
	}
}
