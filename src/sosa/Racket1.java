package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket1 {
    private int xVal;
    private int yVal;
    private int velocity;
    private Boolean pressUp;
    private Boolean pressDown;
    private Graphics graphic;
    private int score;
    private final int UPPER_BOUNDS;
    private final int LOWER_BOUNDS;
    private final int SPEED;
    private final int INIT_Y;
    private final int HEIGHT;
    private final int WIDTH; 

    public Racket1(int xVal, int speed) {
    	INIT_Y = 225;
        this.xVal = xVal;
        this.yVal = INIT_Y;
        this.velocity = 0;
        this.score = 0;
        UPPER_BOUNDS = 425;
        LOWER_BOUNDS = 0;
        SPEED = speed;
        HEIGHT = 50;
        WIDTH = 10;
        pressUp = false;
        pressDown = false;
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
    
    public int getWidth() {
    	return WIDTH;
    }
    
    public int getHeight() {
    	return HEIGHT;
    }
    
    // for testing purposes
    public void setYVal(int y) {
    	yVal = y;
    }
    
    //changes the velocity to handle moving the paddle up
    public void pressUp() {
    	velocity = -SPEED;
      pressUp = true;
    }

    
    //changes the velocity to handle moving the paddle down
    public void pressDown() {
    	velocity = SPEED;
      pressDown = true;
    }
    
    //changes the velocity to handle a idle state
     public void release(Boolean up) {
    	if (up) {
    		pressUp = false;
    		velocity = SPEED;
    	}
    	else {
    		pressDown = false;
    		velocity = -SPEED;
    	}
    	if (!pressUp && !pressDown) {
    		velocity = 0;
    	}
    }
    
    //checks if the paddle is going beyond the boundaries
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

    
    //moves the yposition of the paddle based on the current velocity amount
    public void move(){
        boundaryCheck();
        yVal += velocity;
    }
    
    public int scorePoint() {
    	return ++score;
    }
    
    public void reset() {
    	yVal = INIT_Y;
    }

}