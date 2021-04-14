package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket2 {

    private int xVal;
    private int yVal;
    private int velocity;
    private Graphics graphic;
    private final int UPPER_BOUNDS;
    private final int LOWER_BOUNDS;
    private final int SPEED;
    
    public Racket2() {
        this.xVal = 480;
        this.yVal = 225;
        this.velocity = 1;
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
    

    
    //this handles moving the automated 
    public void move(){
        
        if(this.yVal >= UPPER_BOUNDS || this.yVal <= LOWER_BOUNDS){
            this.velocity = -this.velocity;
        }
        
        this.yVal+= this.velocity;
    }
}
