package sosa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameFrame2Player extends JFrame{
    //creating racket on left side
    MyGraphics2Player myGraphics2Player = new MyGraphics2Player();
    private boolean isPlay;

    public GameFrame2Player(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(myGraphics2Player);
      
        this.setVisible(true);
       

    }

}
