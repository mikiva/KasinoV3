package control_TEST;

import java.util.ArrayList;
import java.util.List;



public class PlayerList {

	private Player[] playerList;
	private int nbrOfPlayers;

	
	public PlayerList(int nbrOfHumanPlayers, int nbrOfComputerPlayers) {
		nbrOfPlayers = nbrOfHumanPlayers + nbrOfComputerPlayers;
		
		playerList = new Player[nbrOfPlayers];
		
		for (int i = 0; i < nbrOfHumanPlayers; i++) {
			playerList[i] = new PlayerUser(i);
		}
		for(int i = nbrOfHumanPlayers; i < nbrOfPlayers; i++) {
			playerList[i] = new PlayerAI(i);						
		}
	}
	
	public void setLogicToPlayers(GameLogic logic) {
		for (int i = 0; i < playerList.length; i++) {
			playerList[i].setLogic(logic);
		}
	}
	
	public void clearAllHands() {
		for (int i = 0; i < playerList.length; i++) {
			playerList[i].clearHand();
		}
	}
	
	public Player getPlayer(int index) {
		return playerList[index];
	}
	
	public int getNumberOfPlayers() {
		return nbrOfPlayers;
	}
	
	public boolean isAllPlayerHandEmpty() {
		for (int i = 0; i < playerList.length; i++) {
			if(!playerList[i].getHand().isEmpty())
				return false;
		}
		return true;
	}
	
//	public Player[] getPlayerList() {
//		return playerList;
//	}

}
