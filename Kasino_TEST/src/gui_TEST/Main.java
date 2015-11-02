package gui_TEST;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import control_TEST.Dealer;
import control_TEST.GameLogic;
import control_TEST.GameRules;
import control_TEST.PlayerList;
import control_TEST.Scoreboard;
import data_TEST.Deck;
import data_TEST.Table;

public class Main {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		GameRules rules = new GameRules(4, 0);
		Dealer dealer = new Dealer(deck, rules);
		PlayerList playerList = new PlayerList(rules.getNbrOfPlayerUser(), rules.getNbrOfPlayerAI());
		Table table = new Table();
		GameLogic logic = new GameLogic(rules, dealer, playerList);
		
		logic.setTable(table);
		dealer.setPlayerList(playerList);
		dealer.setTable(table);
		
//		dealer.shuffleDeck();
//		dealer.dealToPlayers();
//		dealer.dealToTable();
		
		
		
		
		Frame frame = new Frame(logic, rules, playerList, table);
		frame.setVisible(true);
		

		
	
	}

}
