package sosa;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{
  
	
	//this class is used for the display and functionality of the main menu
    public MyFrame(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //creates a label that says "PONG" and centers on the screen
        JLabel pongTitle = new JLabel();
        pongTitle.setText("PONG");
        pongTitle.setSize(140, 140);
        pongTitle.setLocation(205, 100);
        pongTitle.setVisible(true);
        pongTitle.setFont(new Font("Serif", Font.PLAIN, 40));
        repaint();      
        
        //creates a button and allows for the button to direct to the one player version of the game
       JButton onePlayer = new JButton("1 Player");
       onePlayer.setBounds(40, 250, 120, 30);
       onePlayer.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		
    		   GameFrame game = new GameFrame();
    		   game.setVisible(true);
    		   onePlayer.setVisible(false);
   
    		  
    		   
    	   }
       });
      
       //creates a button and allows for the button to direct to the two player version of the game
      JButton twoPlayer = new JButton("2 Player");
      twoPlayer.setBounds(340, 250, 120, 30);
      
      
      //creates a button and allows for the user to close the application by clicking the button
      JButton quit = new JButton("Quit");
      quit.setBounds(190, 400, 120, 30);
      quit.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  System.exit(0);
    	  }
      });
       
      //adding all of the bottons and label to the JFrame
       this.add(quit);
       this.add(onePlayer);
       this.add(twoPlayer);
       this.add(pongTitle);
       

    }

}
