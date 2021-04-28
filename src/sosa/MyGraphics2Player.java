package sosa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.BooleanSupplier;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import sosa.MyGraphics.KeyListen;

public class MyGraphics2Player extends JPanel implements ActionListener{

	Timer timer = new Timer(4, this);

	int frameWidth = 500;
	int frameHeight = 500;
	Racket1 player1;
	Racket1 player2;
	KeyListen keyListen;

	Ball pongBall;

	int score1=0;
	int score2=0;

	public MyGraphics2Player(){
		timer.start();
		this.player1 = new Racket1(10);
		this.player2 = new Racket1(480);
		this.pongBall = new Ball();
		keyListen = new KeyListen();
		this.setFocusable(true);
		this.addKeyListener(keyListen);

	}


	//paint graphics in the frame
	public void paintComponent(Graphics graphic){
		super.paintComponent(graphic);
		this.setBackground(Color.GREEN);

		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setColor(Color.WHITE);

		graphic2D.fillRect(player2.getXVal(), player2.getYVal(), 10, 50);
		graphic2D.fillRect(player1.getXVal(), player1.getYVal(), 10, 50);

		graphic2D.fillOval( (int)pongBall.getXVal(), (int)pongBall.getYVal(), 10, 10);

		Graphics2D graphicScore = (Graphics2D) graphic;
		graphicScore.setColor(Color.BLACK);
		Font font = new Font("Serif", Font.PLAIN, 20);
		graphicScore.setFont(font);
		graphicScore.drawString("Player 1: "+ score1, 10, 400);
		graphicScore.drawString("Player 2: "+ score2, 370, 400);
		createQuitButton();

	}


	//creates button that allows user to quit the game
	public void createQuitButton() {
		JButton quitButtonInPlay = new JButton("quit game");
		quitButtonInPlay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MyFrame mainMenu = new MyFrame();
				mainMenu.setVisible(true);

			}
		});

		this.add(quitButtonInPlay);
	}


	//method that is triggered after a certain amount of time is reached
	public void actionPerformed(ActionEvent e){

		pongBall.move();
		player2.move();
		player1.move();
		collision();
		hitWall();
		if (pongBall.outOfBoundsLeft()) {
			score2=player2.scorePoint();
			resetPositions();
		} else if (pongBall.outOfBoundsRight()) {
			score1=player1.scorePoint();
			resetPositions();
		}

		repaint();

	}
	//handles if the ball hits the paddle
	public Boolean collision() {
		int ballRadius = pongBall.getRadius();
		double ballTop = pongBall.getYVal();
		double ballBottom = pongBall.getYVal() + (ballRadius * 2);
		double ballLeft = pongBall.getXVal();
		double ballRight = pongBall.getXVal() + (ballRadius * 2);

		double racket1Top = player1.getYVal();
		double racket1Bottom = racket1Top + player1.getHeight();
		double racket1Left = player1.getXVal();
		double racket1Right = racket1Left + player1.getWidth();

		double racket2Top = player2.getYVal();
		double racket2Bottom = racket2Top + player2.getHeight();
		double racket2Left = player2.getXVal();
		double racket2Right = racket2Left + player2.getWidth();

		if (((ballRight >= racket1Left && ballRight <= racket1Right) || (ballLeft >=racket1Left && ballLeft <= racket1Right) 
				|| (ballRight >= racket1Right && ballLeft <= racket1Left))) {
			if ((ballBottom >= racket1Top && ballBottom <= racket1Bottom) || (ballTop >=racket1Top && ballTop <= racket1Bottom)) {
				pongBall.hitPaddle();
				return true;
			}
		}

		if (((ballRight >= racket2Left && ballRight <= racket2Right) || (ballLeft >=racket2Left && ballLeft <= racket2Right) 
				|| (ballRight >= racket2Right && ballLeft <= racket2Left))) {
			if ((ballBottom >= racket2Top && ballBottom <= racket2Bottom) || (ballTop >=racket2Top && ballTop <= racket2Bottom)) {
				pongBall.hitPaddle();
				return true;
			}
		}

		return false;
	}

	public boolean hitWall() {
		//ricochets the ball off of the wall if ball has an x val that goes passed the given boundary
		if(pongBall.getYVal() <= pongBall.getLowerBounds() || pongBall.getYVal() >= pongBall.getUpperBounds()) {
			pongBall.hitWall();
			return true;
		}
		return false;
	}

	// For testing purposes
	public Ball getPongBall() {
		return pongBall;
	}

	// For testing purposes
	public Racket1 getRacket1() {
		return player1;
	}

	// For testing purposes
	public Racket1 getRacket2() {
		return player2;
	}

	public void resetPositions() {
		pongBall.reset();
		player1.reset();
		player2.reset();
	}
	class KeyListen implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				player1.pressUp();
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				player1.pressDown();
			}


			if(e.getKeyCode() == KeyEvent.VK_UP) {
				player2.pressUp();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				player2.pressDown();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				player1.release(true);
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				player1.release(false);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				player2.release(true);
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				player2.release(false);
			}
		}

	}

}
