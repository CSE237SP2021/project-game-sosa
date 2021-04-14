package sosa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGraphics extends JPanel implements ActionListener{
    
    Timer timer = new Timer(4, this);

    int frameWidth = 500;
    int frameHeight = 500;
    Racket1 racket1;

    KeyListen keyListen;
    
    Racket2 racket2;
    Ball pongBall;
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

        graphic2D.fillOval( (int)pongBall.getXVal(), (int)pongBall.getYVal(), 10, 10);
        
        

    }

    
    
    //method that is triggered after a certain amount of time is reached
    public void actionPerformed(ActionEvent e){

    	pongBall.move();
    	racket2.move();
    	racket1.move();
    	
    	//ricochets the ball off of the right racket if ball has same x val and y val in between the rackets bounds
    	if(((racket2.getXVal() -10) == pongBall.getXVal()) && (pongBall.getYVal() >= racket2.getYVal() - 25)
    			&& (pongBall.getYVal() <= racket2.getYVal() + 25)) {
    		System.out.println("doink");
    	
    		pongBall.hitPaddle();
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

