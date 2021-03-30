package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket1 {
    private int xVal;
    private int yVal;
    private int velocity;
    private Graphics graphic;
    private final int UPPER_BOUNDS;
    private final int LOWER_BOUNDS;
    private final int SPEED;

    public Racket1() {
        this.xVal = 20;
        this.yVal = 225;
        this.velocity = 0;
        UPPER_BOUNDS = 425;
        LOWER_BOUNDS = 0;
        SPEED = 1;
    }
    /*
    public void KeyPressed(KeyEvent e){
        System.out.println("how");
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.yVal+= this.velocity;
            System.out.println("how");
        }
    }
*/
    
    public int getXVal() {
        return xVal;
    }

    public int getYVal() {
        return yVal;
    }
    
    public void pressUp() {
    	velocity = -SPEED;
    }
    
    public void pressDown() {
    	velocity = SPEED;
    }
    
    public void release() {
    	velocity = 0;
    }

    private void boundaryCheck() {
    	if (yVal > UPPER_BOUNDS) {
    		yVal = UPPER_BOUNDS;
    		velocity = 0;
    	}
    	else if (yVal < LOWER_BOUNDS) {
    		yVal = LOWER_BOUNDS;
    		velocity = 0;
    	}
    }

    public void move(){
        boundaryCheck();
        yVal += velocity;
    }

}
