package sosa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    //creating racket on left side
    MyGraphics myGraphics = new MyGraphics();
    private boolean isPlay;

    public GameFrame(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(myGraphics);
      
        this.setVisible(true);
       

    }

}
