package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket2 {

    private int xVal;
    private int yVal;
    private int midYVal;
    private int velocity;
    private Graphics graphic;
    private int score;
    private final int UPPER_BOUNDS;
    private final int LOWER_BOUNDS;
    private final int SPEED;
    private final int INIT_Y;
    private final int HALF_HEIGHT;
    
    public Racket2() {
    	INIT_Y = 225;
        this.xVal = 480;
        this.yVal = INIT_Y;
        this.velocity = (Math.random() < 0.5 ? 1 : -1);
        this.score = 0;
        UPPER_BOUNDS = 425;
        LOWER_BOUNDS = 0;
        SPEED = 1;
        HALF_HEIGHT = 25;
        this.midYVal = this.yVal + HALF_HEIGHT;
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
    public int getMidYVal() {
    	return midYVal;
    }
    
    // for testing purposes
    public int getInitY() {
    	return INIT_Y;
    }
    
    public int getScore() {
		return score;
	}
    
    // for testing purposes
    public void setYVal(int y) {
    	yVal = y;
    	midYVal = yVal + HALF_HEIGHT;
    }
    
    // for testing purposes
    public void setMidYVal(int y) {
    	midYVal = y;
    	yVal = midYVal - HALF_HEIGHT;
    }
    
    // for testing purposes
    public int getVelocity() {
    	return velocity;
    }
    
    // for testing purposes
    public int getHalfHeight() {
    	return HALF_HEIGHT;
    }
    
    //this handles moving the automated 
    public void move(){
    	
        if((yVal >= UPPER_BOUNDS && velocity > 0) || (yVal <= LOWER_BOUNDS && velocity < 0)) {
            velocity = 0;
        }
        
        yVal += velocity;
        midYVal += velocity;
        
    }
    
    public int scorePoint() {
    	return ++score;
    }
    
    public void reset() {
    	yVal = INIT_Y;
    	midYVal = yVal + HALF_HEIGHT;
    	velocity = (Math.random() < 0.5 ? 1 : -1);
    }
    
    public int compareToBallY(double ballYVal) {
    	if (ballYVal < midYVal) {
    		velocity = -1*SPEED;
    		return 1;
    	}
    	else if (ballYVal == midYVal) {
    		velocity = 0;
    		return 2;
    	}
    	else {
    		velocity = SPEED;
    		return 3;
    	}
    }
}
