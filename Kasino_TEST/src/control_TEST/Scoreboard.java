package control_TEST;

public class Scoreboard {
	
	private int[] scoreCounter;
	
	public Scoreboard(int nbrOfPlayers) {
		scoreCounter = new int[nbrOfPlayers];
		
		for (int i = 0; i < scoreCounter.length; i++) {
			scoreCounter[i] = 0;
		}
	}
	
	public void incrementScore(int indexOfScoreCounter, int extraPoints ) {
		scoreCounter[indexOfScoreCounter] += 1 + extraPoints;
	}
	
	public String getPlayerScores() {
		String s = "Spelare 1: " + scoreCounter[0] + " poäng.";
		for (int i = 0; i < scoreCounter.length; i++) {
			s+= "\nSpelare " + (i+1) + ": " + scoreCounter[i+1] + " poäng.";
		}
		return s;
	}
	
	public void resetScoreboard() {
		for (int i = 0; i < scoreCounter.length; i++) {
			scoreCounter[i] = 0;
		}
	}

}
