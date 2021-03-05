public aspect VerifyWin {
	pointcut endGameCheck(): call (public boolean Board.winCheck());
	
	after() returning(Object obj): endGameCheck() {
		if ((boolean) obj == true)
			System.out.println("ASPECT: GAME OVER!");
	}
}