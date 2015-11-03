package gui_TEST;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control_TEST.GameLogic;
import control_TEST.Player;
import data_TEST.Card;

public class MenuBar extends JMenuBar {

	private ApplicationLogic appLogic;
	private TurnCounter tCounter;

	private JButton btnNewGame;
	private JButton btnTakeCard;
	private JButton btnPlaceCard;

	public MenuBar(GameLogic logic, PlayerPanel[] playerPanel, TablePanel tablePanel) {
		super();
		tCounter = new TurnCounter(playerPanel);

		btnNewGame = new JButton("New Game");
		btnTakeCard = new JButton("Take Card(s)");
		btnPlaceCard = new JButton("Place Card");

		btnNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < playerPanel.length; i++)
					{
					playerPanel[i].setFaceDownCards();
					playerPanel[i].repaint();
					}
				
				logic.newGame();
				appLogic.clearAll();
				tablePanel.clearTable();
				tablePanel.addStartingCards();

				


				playerPanel[0].setThisPlayersTurn(true);
				
				for (int i = 0; i < playerPanel.length; i++) {
					playerPanel[i].setHandCards();
					playerPanel[i].updateState();
				}
			}

		});

		btnTakeCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int currentTurn = tCounter.getCurrentPlayersTurn();

				if(appLogic.getHandCardID() != null && !appLogic.getTableCardList().isEmpty()) {
					if(playerPanel[currentTurn].getPlayer().takeCard(appLogic.getTableCardList(), appLogic.getHandCardID())) {

						playerPanel[currentTurn].removeCardFromHand(appLogic.getHandCardID());

						for (int i = 0; i < appLogic.getTableCardList().size(); i++) {
							tablePanel.removeCardFromTable(appLogic.getTableCardList().get(i));
						}

						tCounter.nextPlayerTurn();

					}
				}
				appLogic.clearAll();
				//playerPanel[currentTurn].setAllToSelectable();
				tablePanel.setAllToSelectable();
				logic.setCurrentPlayer(tCounter.getCurrentPlayersTurn());
			}
		});

		btnPlaceCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(appLogic.getHandCardID() != null) {
					playerPanel[tCounter.getCurrentPlayersTurn()].getPlayer().placeCard(appLogic.getHandCardID());
					tablePanel.addCardToTable(appLogic.getHandCardID());
					playerPanel[tCounter.getCurrentPlayersTurn()].removeCardFromHand(appLogic.getHandCardID());
					tCounter.nextPlayerTurn();

				}
				appLogic.clearAll();
				logic.setCurrentPlayer(tCounter.getCurrentPlayersTurn());
			}

		});

		add(btnNewGame);
		add(btnTakeCard);
		add(btnPlaceCard);
	}

	public void setApplicationLogic(ApplicationLogic appLogic) {
		this.appLogic = appLogic;
	}

}
