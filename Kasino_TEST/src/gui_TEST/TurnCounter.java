package gui_TEST;

import java.util.ArrayList;
import java.util.List;

public class TurnCounter {

	PlayerPanel[] player;
	
	public TurnCounter(PlayerPanel[] player) {
		this.player = player;
	}
	
	public int getCurrentPlayersTurn() {
		for (int i = 0; i < player.length; i++) {
			if(player[i].isThisPlayersTurn())
				return i;
		}
		return -1;
	}

	public void nextPlayerTurn() {
		int id = getCurrentPlayersTurn();
		player[id].setThisPlayersTurn(false);
		System.out.println("player.length : " +player.length);
		
		if((id + 1) > player.length - 1) {
			player[0].setThisPlayersTurn(true);
		}
			
		else {
			player[(id + 1)].setThisPlayersTurn(true);
		}
		
		for (int i = 0; i < player.length; i++) {
			player[i].updateState();
		}
	}
}
