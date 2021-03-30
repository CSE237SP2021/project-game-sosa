package sosa;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{
    //creating racket on left side
    MyGraphics myGraphics = new MyGraphics();

    public MyFrame(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(myGraphics);
        this.setVisible(true);
    }

}
