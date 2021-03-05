import java.util.*;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		int playerCount = 1;
		int row = 0;
		char columnLetter = 'd';
		int column = 0;
		boolean playTurn = false;
		
		boolean gameActive = true;
		
		while(gameActive) {
			//print board
			System.out.println(board.display());
			System.out.println("It is Player " + playerCount +"'s turn.");
			
			//get column
			System.out.println("Please enter a column A - C.");
			columnLetter = sc.next().charAt(0);
			if(columnLetter == 'a' || columnLetter == 'A') {
				column = 0;
			}
			else if(columnLetter == 'b' || columnLetter == 'B') {
				column = 1;
			}
			else if(columnLetter == 'c' || columnLetter == 'C') {
				column = 2;
			}
			
			//get row
			System.out.println("Please enter a row 1 - 3.");
			row = sc.nextInt() - 1;
			
			//play turn
			playTurn = board.play(row, column, playerCount);
			if(!playTurn) {
				continue;
			}
			
			//check for winner
			if(board.winCheck()) {
				if(board.winner()) {
					System.out.println(board.display());
					System.out.println("WINNER: Player " + playerCount + "!");
				} else {
					System.out.println("DRAW!");
				}
				break;
			}
			
			if(playerCount == 1) {
				playerCount = 2;
			}
			else if(playerCount == 2) {
				playerCount = 1;
			}
			
		}
		sc.close();

	}

}
