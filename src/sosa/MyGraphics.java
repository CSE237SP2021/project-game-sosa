package sosa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGraphics extends JPanel implements ActionListener{
    
    Timer timer = new Timer(3, this);
    int racket2XVal  = 480;
    int racket2YVal = 225;
    int yVelocity = 1;
    int frameWidth = 500;
    int frameHeight = 500;
    Racket1 racket1;
    KeyListen keyListen;
    
    public MyGraphics(){
        timer.start();
        this.racket1 = new Racket1();
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
        graphic2D.fillRect(racket2XVal, racket2YVal, 10, 50);

        graphic2D.fillRect(racket1.getXVal(), racket1.getYVal(), 10, 50);
        //this.racket1.draw();
    }

    
    
    //method that is triggered after a certain amount of time is reached
    public void actionPerformed(ActionEvent e){
        //changes direction if border hit
        if(racket2YVal >= 440 || racket2YVal <= 1){
            yVelocity = -yVelocity;
        }
        
        racket2YVal+= yVelocity;
        
        racket1.move();
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

