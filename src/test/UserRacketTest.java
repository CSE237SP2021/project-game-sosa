package test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


//import Racket1.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UserRacketTest {

	  	private int xVal;
	   	private int yVal;
	    private int velocity;
	    private Graphics graphic;
	    private final int UPPER_BOUNDS = 425;
	    private final int LOWER_BOUNDS = 0;
	    private final int SPEED = 1;
	
	@BeforeEach
	public void setUp() {
		int xVal = 20;
        int yVal = 225;
        int velocity = 0;
       
	}
	
	@Test
	public void testPressUp() {
	    velocity = -SPEED;
	    assertTrue(velocity == -1);
	}
	
	@Test
     public void testPressDown() {
    	velocity = SPEED;
        assertTrue(velocity == 1);
    }

    @Test
    public void testRelease() {
    	velocity = 0;
        assertTrue(velocity == 0);
    }
    
    @Test
    public void testUpperBound(){
        if (yVal > UPPER_BOUNDS){
        	assertTrue(yVal == UPPER_BOUNDS);
        	assertTrue(velocity == 0);
        }
       
    }
    
    @Test
    public void testLowerBound() {
    	if (yVal < LOWER_BOUNDS) {
    		assertTrue(yVal == LOWER_BOUNDS);
    		assertTrue(velocity == 0);
    	}
    	
    }
    
    @Test
    public void testMove(){
    	int result =  yVal + velocity;
    	assertTrue(yVal == result);
       
    }
    
	

}
