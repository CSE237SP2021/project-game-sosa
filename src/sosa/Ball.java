package sosa;

import java.util.function.BooleanSupplier;

public class Ball {

	private double xVal;
	private double yVal;
	double xVelocity;
	double yVelocity;
	private int speed;
	private final int UPPER_BOUNDS;
	private final int LOWER_BOUNDS;
	private final int LEFTWARD_BOUNDS;
	private final int RIGHTWARD_BOUNDS;
	private final double INIT_X;
	private final double INIT_Y;
	private final int RADIUS;
	
	public Ball() {
		INIT_X = 250;
		INIT_Y = 250;
		this.xVal = INIT_X;
		this.yVal = INIT_Y;
		this.speed = 1;
		this.xVelocity = (Math.random() > 0.5 ? 1 : -1);
		this.yVelocity = 0;
		UPPER_BOUNDS = 470;
		LOWER_BOUNDS = 0;
		LEFTWARD_BOUNDS = 0;
		RIGHTWARD_BOUNDS = 500;
		RADIUS = 5;
	}
	
    //gets the x value of the ball
    public double getXVal() {
        return xVal;
    }
    
    //gets the y value of the ball
    public double getYVal() {
        return yVal;
    }
    
    // for testing purposes
    public double getXVelocity() {
    	return xVelocity;
    }
    
 // for testing purposes
    public double getYVelocity() {
    	return yVelocity;
    }
    
    // for testing purposes
    public void setXVal(double newXVal) {
    	xVal = newXVal;
    }
    
    // for testing purposes
    public void setYVal(double newYVal) {
    	yVal = newYVal;
    }
    
    // for testing purposes
    public void setXVelocity(double newXVel) {
    	xVelocity = newXVel;
    }
    
    // for testing purposes
    public void setYVelocity(double newYVel) {
    	yVelocity = newYVel;
    }
    
    public void reset() {
    	xVal = INIT_X;
    	yVal = INIT_Y;
    	
    	xVelocity = (Math.random() > 0.5 ? 1 : -1);
    	yVelocity = 0;
    }
    
    // for testing purposes
    public double getInitX() {
    	return INIT_X;
    }
    
    // for testing purposes
    public double getInitY() {
    	return INIT_Y;
    }
    
    // for testing purposes
    public int getLeftwardBounds() {
    	return LEFTWARD_BOUNDS;
    }
    
    // for testing purposes
    public int getRightwardBounds() {
    	return RIGHTWARD_BOUNDS;
    }
    
 // for testing purposes
    public int getLowerBounds() {
    	return LOWER_BOUNDS;
    }
    
    // for testing purposes
    public int getUpperBounds() {
    	return UPPER_BOUNDS;
    }
    
    public int getRadius() {
    	return RADIUS;
    }
    
    //changes the direction of the ball after it hits a paddle
    public void hitPaddle() {
    	this.xVelocity = -this.xVelocity;
    	
    	double chooseDirection = Math.random();
    	double randomPlacement = Math.random();
    	
    	if(chooseDirection > 0.5) {
    		this.yVelocity = randomPlacement;
    	}
    	else {
    		this.yVelocity = -randomPlacement;
    	}
    }
    
    //changes the y direction of the ball after it hits the upper or lower boundary
    public void hitWall() {
    	this.yVelocity = -this.yVelocity;
    }
    
    //this moves the ball in the desired direction
    public void move() {
    	this.xVal += this.xVelocity;
    	this.yVal += this.yVelocity;
    }

	public Boolean outOfBoundsLeft() {
		return (xVal + RADIUS * 2) < (LEFTWARD_BOUNDS - (RADIUS * 4));
	}

	public Boolean outOfBoundsRight() {
		return xVal > (RIGHTWARD_BOUNDS + (RADIUS * 4));
	}
    
    
}
