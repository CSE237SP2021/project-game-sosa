package sosa;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{

	public JButton onePlayer = new JButton("1 Player");
	public JButton twoPlayer = new JButton("2 Player");
	public JButton quit = new JButton("Quit");

	//this class is used for the display and functionality of the main menu
	public MyFrame(){
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		addPongTitle();
		addOnePlayerButton();
		addTwoPlayerButton();
		addQuitButton();
		addDifficultyRadioButtons();
	}

	//adds the title for the game on the main menu
	public void addPongTitle() {
		JLabel pongTitle = new JLabel();
		pongTitle.setText("PONG");
		pongTitle.setSize(140, 140);
		pongTitle.setLocation(205, 100);
		pongTitle.setVisible(true);
		pongTitle.setFont(new Font("Serif", Font.PLAIN, 40));
		repaint();      
		this.add(pongTitle);
	}

	//creates a button and allows for the button to direct to the one player version of the game
	public void addOnePlayerButton() {
		onePlayer.setBounds(40, 250, 120, 30);
		onePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GameFrame game = new GameFrame();
				game.setVisible(true);
				onePlayer.setVisible(false);
			}
		});
		this.add(onePlayer);
	}

	//creates a button and allows for the button to direct to the two player version of the game
	public void addTwoPlayerButton() {
		twoPlayer.setBounds(340, 250, 120, 30);
		twoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame2Player game = new GameFrame2Player();
				game.setVisible(true);
				twoPlayer.setVisible(false);
			}
		});
		this.add(twoPlayer);
	}

	//creates a button and allows for the user to close the application by clicking the button
	public void addQuitButton() {
		quit.setBounds(190, 400, 120, 30);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit.setVisible(false);
				System.exit(0);
			}
		});
		this.add(quit);
	}

	//radio buttons to help determine the difficulty of the game
	public void addDifficultyRadioButtons() {
		JLabel difficultyLabel = new JLabel();
		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton regular= new JRadioButton("Regular");
		JRadioButton hard = new JRadioButton("Hard");
		difficultyLabel.setText("Difficulty:");
		difficultyLabel.setSize(100, 30);
		difficultyLabel.setLocation(50, 350);
		difficultyLabel.setVisible(true);
		repaint();
		easy.setBounds(150, 350, 100, 30);
		regular.setBounds(240, 350, 100, 30);
		hard.setBounds(350, 350, 100, 30);
		ButtonGroup difficultyPick = new ButtonGroup();
		difficultyPick.add(easy);
		difficultyPick.add(regular);
		difficultyPick.add(hard);
		this.add(easy);
		this.add(regular);
		this.add(hard);
		this.add(difficultyLabel);
	}

}
