package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket1 {
    private int xVal;
    private int yVal;
    private int velocity;
    private Graphics graphic;
    private int score;
    private final int UPPER_BOUNDS;
    private final int LOWER_BOUNDS;
    private final int SPEED;
    private final int INIT_Y;
    private final int HEIGHT;
    private final int WIDTH;

    public Racket1() {
    	INIT_Y = 225;
        this.xVal = 10;
        this.yVal = INIT_Y;
        this.velocity = 0;
        this.score = 0;
        UPPER_BOUNDS = 425;
        LOWER_BOUNDS = 0;
        SPEED = 1;
        HEIGHT = 50;
        WIDTH = 10;
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
    
    //changes the velocity to handle moving the paddle up
    public void pressUp() {
    	velocity = -SPEED;
    }

    
    //changes the velocity to handle moving the paddle down
    public void pressDown() {
    	velocity = SPEED;
    }
    
    //changes the velocity to handle a idle state
    public void release() {
    	velocity = 0;
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
