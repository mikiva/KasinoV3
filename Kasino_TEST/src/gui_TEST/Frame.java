package gui_TEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Position;

import com.sun.glass.events.KeyEvent;

import control_TEST.GameLogic;
import control_TEST.GameRules;
import control_TEST.PlayerList;
import data_TEST.Table;



public class Frame extends JFrame {

	private GameLogic logic;
	private ApplicationLogic appLogic;
	private GameRules rules;
	private PlayerList playerList;

	private JPanel mainPanel;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int frameWidth = (int)(screenSize.getWidth()*0.8);
	private int frameHeight = (int)(screenSize.getHeight()*0.8);

	private final static int CARD_HEIGHT = 120;
	private final static int CARD_WIDTH = 74;
	private final static int H_GAP = 10;
	private final static int V_GAP = 10;

	private final static String[] POSITION = {BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.EAST};

	public Frame(GameLogic logic, GameRules rules, PlayerList playerList, Table table) {
		super("KASINO");
		appLogic = new ApplicationLogic();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		mainPanel = new JPanel();

		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout());

		JPanel bottomPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel eastPanel = new JPanel();

		PlayerPanel[] playerPanel = new PlayerPanel[rules.getNbrOfPlayerUser() + rules.getNbrOfPlayerAI()];

		for (int i = 0; i < playerPanel.length; i++) {	
			playerPanel[i] = new PlayerPanel(playerList.getPlayer(i), appLogic);
			if((i+1) % 2 == 0) 
				playerPanel[i].setLayout(new GridLayout(4, 1, 0, V_GAP));
			else 
				playerPanel[i].setLayout(new GridLayout(1, 4, H_GAP, 0));		
		}

		bottomPanel.setPreferredSize(new Dimension( (CARD_WIDTH + H_GAP) * 5, CARD_HEIGHT));
		westPanel.setPreferredSize(new Dimension(CARD_WIDTH, (CARD_HEIGHT + V_GAP) * 5));
		topPanel.setPreferredSize(new Dimension( (CARD_WIDTH + H_GAP) * 4, CARD_HEIGHT));
		eastPanel.setPreferredSize(new Dimension(CARD_WIDTH, (CARD_HEIGHT + V_GAP) *5 ));

		bottomPanel.add(playerPanel[0]);
		westPanel.add(playerPanel[1]);
		topPanel.add(playerPanel[2]);
		eastPanel.add(playerPanel[3]);

		TablePanel tablePanel = new TablePanel(table, appLogic, rules.getCardsOnTable());
		MenuBar menuBar = new MenuBar(logic, playerPanel, tablePanel);
		menuBar.setApplicationLogic(appLogic);

		

		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(tablePanel, BorderLayout.CENTER);

		setJMenuBar(menuBar);
		pack();
		setLocationRelativeTo(null);
	}

}
