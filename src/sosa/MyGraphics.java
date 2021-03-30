package sosa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGraphics extends JPanel implements ActionListener {
    
    Timer timer = new Timer(4, this);
    int racket2XVal  = 480;
    int racket2YVal = 225;
    int yVelocity = 1;
    int frameWidth = 500;
    int frameHeight = 500;
    Racket1 racket1;
    public MyGraphics(){
        timer.start();
        this.racket1 = new Racket1();

    }

    //paint graphics in the frame
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        this.setBackground(Color.GREEN);

        Graphics2D graphic2D = (Graphics2D) graphic;
        graphic2D.setColor(Color.WHITE);
        graphic2D.fillRect(racket2XVal, racket2YVal, 10, 50);

        graphic2D.fillRect(racket1.xVal, racket1.yVal, 10, 50);
        //this.racket1.draw();
    }


    
    //method that is triggered after a certain amount of time is reached
    public void actionPerformed(ActionEvent e){
        //changes direction if border hit
        if(racket2YVal >= 440 || racket2YVal <= 1){
            yVelocity = -yVelocity;
        }
        
        racket2YVal+= yVelocity;
        repaint();
    }
}
