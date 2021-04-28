package sosa;

import java.awt.*;

import java.awt.event.*;
import java.util.function.BooleanSupplier;

import javax.swing.*;

public class MyGraphics extends JPanel implements ActionListener{

	Timer timer = new Timer(4, this);


	int frameWidth = 500;
	int frameHeight = 500;
	Racket1 racket1;
    KeyListen keyListen;
    
    Racket2 racket2;
    Ball pongBall;
    int score1=0;
    int score2=0;
    
    public MyGraphics(){
        timer.start();
        this.racket1 = new Racket1(10, 1);
        this.racket2 = new Racket2(1);
        this.pongBall = new Ball(1.5);
        keyListen = new KeyListen();
        this.setFocusable(true);
        this.addKeyListener(keyListen);
    }




	//paint graphics in the frame
	public void paintComponent(Graphics graphic){
		super.paintComponent(graphic);
		this.setBackground(Color.GREEN);

		Graphics2D graphic2D = (Graphics2D) graphic;
		Graphics2D graphicScore = (Graphics2D) graphic;

		graphic2D.setColor(Color.WHITE);

		graphic2D.fillRect(racket2.getXVal(), racket2.getYVal(), 10, 50);
		graphic2D.fillRect(racket1.getXVal(), racket1.getYVal(), 10, 50);

		graphic2D.fillOval( (int)pongBall.getXVal(), (int)pongBall.getYVal(), pongBall.getRadius()*2, pongBall.getRadius()*2);

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
		racket2.compareToBallY(pongBall.getYVal());
		racket2.move();
		racket1.move();

		collision();

		hitWall();

		if (pongBall.outOfBoundsLeft()) {
			score2=racket2.scorePoint();
			resetPositions();
		} else if (pongBall.outOfBoundsRight()) {
			score1=racket1.scorePoint();
			resetPositions();
		}

		repaint();
	}

	//handles if the ball hits the paddle
	public Boolean collision() {
		int ballRadius = pongBall.getRadius();
		double ballTop = pongBall.getYVal(); //295
		double ballBottom = pongBall.getYVal() + (ballRadius * 2); //305
		double ballLeft = pongBall.getXVal(); //485
		double ballRight = pongBall.getXVal() + (ballRadius * 2); //495

		double racket1Top = racket1.getYVal();
		double racket1Bottom = racket1Top + racket1.getHeight();
		double racket1Left = racket1.getXVal();
		double racket1Right = racket1Left + racket1.getWidth();

		double racket2Top = racket2.getYVal(); //250
		double racket2Bottom = racket2Top + racket2.getHeight(); //300
		double racket2Left = racket2.getXVal(); //480
		double racket2Right = racket2Left + racket2.getWidth(); //490

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
		return racket1;
	}

	// For testing purposes
	public Racket2 getRacket2() {
		return racket2;
	}

	public void resetPositions() {
		pongBall.reset();
		racket1.reset();
		racket2.reset();
	}

	class KeyListen implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				racket1.pressUp();
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				racket1.pressDown();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				racket1.release(true);
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				racket1.release(false);
			}
		}

	}

}
