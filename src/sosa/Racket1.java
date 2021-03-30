package sosa;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Racket1{
    int xVal;
    int yVal;
    int velocity;
    Graphics graphic;

    public Racket1(){
        this.xVal = 20;
        this.yVal = 225;
        this.velocity = 1;


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
    public void KeyPressed(KeyEvent e){
        System.out.println("how");
    }
    public int getXVal(){
        return xVal;
    }

    public int getYVal(){
        return yVal;
    }


    public void move(){
        if(this.yVal >= 440 || this.yVal <= 0){
            this.velocity = -this.velocity;
        }

        this.yVal+=this.velocity;
    }

}
