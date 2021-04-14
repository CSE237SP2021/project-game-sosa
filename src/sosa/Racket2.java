package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket2 {

    private int xVal;
    private int yVal;
    private int velocity;
    private Graphics graphic;
    private int score;
    private final int UPPER_BOUNDS;
    private final int LOWER_BOUNDS;
    private final int SPEED;
    private final int INIT_Y;
    
    public Racket2() {
    	INIT_Y = 225;
        this.xVal = 480;
        this.yVal = INIT_Y;
        this.velocity = (Math.random() < 0.5 ? 1 : -1);
        this.score = 0;
        UPPER_BOUNDS = 425;
        LOWER_BOUNDS = 0;
        SPEED = 1;
    }
    
    //gets the x value of the paddle
    public int getXVal() {
        return xVal;
    }
    
    //gets the y value of the paddle
    public int getYVal() {
        return yVal;
    }
    
 // for testing purposes
    public int getInitY() {
    	return INIT_Y;
    }
    
    public int getScore() {
		return score;
	}
    
    //this handles moving the automated 
    public void move(){
        
        if(this.yVal >= UPPER_BOUNDS || this.yVal <= LOWER_BOUNDS){
            this.velocity = -this.velocity;
        }
        
        this.yVal+= this.velocity;
    }
    
    public int scorePoint() {
    	return ++score;
    }
    
    public void reset() {
    	yVal = INIT_Y;
    	velocity = (Math.random() < 0.5 ? 1 : -1);
    }
}
