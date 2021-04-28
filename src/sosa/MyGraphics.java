package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import score.ScoreBoard;

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
        this.racket1 = new Racket1();
        this.racket2 = new Racket2();
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
        
        graphic2D.fillRect(racket2.getXVal(), racket2.getYVal(), 10, 50);
        graphic2D.fillRect(racket1.getXVal(), racket1.getYVal(), 10, 50);

        graphic2D.fillOval( (int)pongBall.getXVal(), (int)pongBall.getYVal(), pongBall.getRadius()*2, pongBall.getRadius()*2);
        //score.paint();
        
        Graphics2D g2 = (Graphics2D)graphic;
	      g2.setRenderingHint(
	         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      
	      Font font = new Font("Serif", Font.PLAIN, 25);
	      g2.setFont(font);
//	      g2.drawString("score1"+score2, 10, 400);
//	      g2.drawString("score2"+score1, 350, 400);
	      g2.drawString("Player 1: "+score1, 10, 400);
	      g2.drawString("Player 2: "+score2, 350, 400);
    }

    
    
    //method that is triggered after a certain amount of time is reached
    public void actionPerformed(ActionEvent e){

    	getPongBall().move();
    	racket2.move();
    	racket1.move();
    	//ricochets the ball off of the right racket if ball has same x val and y val in between the rackets bounds
    	if(((racket2.getXVal() -10) == pongBall.getXVal()) && (pongBall.getYVal() >= racket2.getYVal() - 25)
    			&& (pongBall.getYVal() <= racket2.getYVal() + 25)) {
    		System.out.println("doink");
    	
    		getPongBall().hitPaddle();
    	}
    	
    	//ricochets the ball off of the left racket if ball has same x val and y val in between the rackets bounds
    	if(((racket1.getXVal() + 10) == pongBall.getXVal()) && (pongBall.getYVal() >= racket1.getYVal() - 25)
    			&& (pongBall.getYVal() <= racket1.getYVal() + 25)){
    		System.out.println("dink");
    		
    		pongBall.hitPaddle();
    	}
    	
    	//ricochets the ball off of the wall if ball has an x val that goes passed the given boundary
    	if(pongBall.getYVal() <= 0 || pongBall.getYVal() >= 470) {
    		pongBall.hitWall();
    	}
    	
    	if (pongBall.outOfBoundsLeft()) {
    		System.out.println("Left out of bounds: " + pongBall.getXVal());
    		//score1=racket2.scorePoint();
    		score2=racket2.scorePoint();
    		System.out.println("score for racket2 "+ score2);
    		resetPositions();
    	} else if (pongBall.outOfBoundsRight()) {
    		System.out.println("Right out of bounds " + pongBall.getYVal());
    		//score2=racket1.scorePoint();
    		score1=racket1.scorePoint();
    		System.out.println("score for racket1 "+ score1);
    		resetPositions();
    	}

        repaint();
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
				System.out.println("up");
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				racket1.pressDown();
				System.out.println("down");
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			racket1.release();
			System.out.println("release");
		}
    	
    }
    
}

