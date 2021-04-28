package sosa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    
    //Racket2 racket2;
    Ball pongBall;
    public MyGraphics2Player(){
    	System.out.println("in ther");
        timer.start();
        this.player1 = new Racket1();
        this.player2 = new Racket1();
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
        graphic2D.fillRect(480, player2.getYVal(), 10, 50);


        graphic2D.fillRect(player1.getXVal(), player1.getYVal(), 10, 50);

        graphic2D.fillOval( (int)pongBall.getXVal(), (int)pongBall.getYVal(), 10, 10);
        
        

    }

    
    
    //method that is triggered after a certain amount of time is reached
    public void actionPerformed(ActionEvent e){

    	pongBall.move();
    	player2.move();
    	player1.move();
    	
    	//ricochets the ball off of the right racket if ball has same x val and y val in between the rackets bounds
    	if(((player2.getXVal() -10) == pongBall.getXVal()) && (pongBall.getYVal() >= player2.getYVal() - 25)
    			&& (pongBall.getYVal() <= player2.getYVal() + 25)) {
    		System.out.println("doink");
    	
    		pongBall.hitPaddle();
    	}
    	
    	//ricochets the ball off of the left racket if ball has same x val and y val in between the rackets bounds
    	if(((player1.getXVal() + 10) == pongBall.getXVal()) && (pongBall.getYVal() >= player1.getYVal() - 25)
    			&& (pongBall.getYVal() <= player1.getYVal() + 25)){
    		System.out.println("dink");
    		
    		pongBall.hitPaddle();
    	}
    	
    	//ricochets the ball off of the wall if ball has an x val that goes passed the given boundary
    	if(pongBall.getYVal() <= 0 || pongBall.getYVal() >= 470) {
    		pongBall.hitWall();
    	}

        repaint();
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
				System.out.println("up");
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				player1.pressDown();
				System.out.println("down");
			}
			
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				player2.pressUp();
				System.out.println("up");
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				player2.pressDown();
				System.out.println("Down");
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_W) {
				player1.release(true);
				System.out.println("release player 1");
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				player1.release(false);
				System.out.println("release player 1");
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				player2.release(true);
				System.out.println("release player 2");
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				player2.release(false);
				System.out.println("release player 2");
			}
			
		}
    	
    }
    
}
