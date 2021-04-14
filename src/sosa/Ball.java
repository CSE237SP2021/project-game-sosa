package sosa;

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
	
	public Ball() {
		this.xVal = 250;
		this.yVal = 250;
		this.speed = 1;
		this.xVelocity = -1;
		this.yVelocity = 0;
		UPPER_BOUNDS = 425;
		LOWER_BOUNDS = 0;
		LEFTWARD_BOUNDS = 0;
		RIGHTWARD_BOUNDS = 425;
	}
	
	
	
    //gets the x value of the ball
    public double getXVal() {
        return xVal;
    }
    
    //gets the y value of the ball
    public double getYVal() {
        return yVal;
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
    
}
