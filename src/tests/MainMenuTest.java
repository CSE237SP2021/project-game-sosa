package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sosa.GameFrame;
import sosa.GameFrame2Player;
import sosa.MyFrame;

class MainMenuTest {
	private MyFrame mainMenu;
	
	@BeforeEach
	void setUpTestingObjects() {
		mainMenu = new MyFrame();
	}
	
	@Test
	void onePlayerGameStarted() {
		mainMenu.onePlayer.doClick();
		//checks that the single player game is visibile by keeping track of button visibility
		assertEquals(false, mainMenu.onePlayer.isVisible());
		//checks that the two player scene is not visible by keeping track of button visibility
		assertEquals(true, mainMenu.twoPlayer.isVisible());
		
	}
	
	@Test
	void twoPlayerGameStarted() {
		mainMenu.twoPlayer.doClick();
		//checks that the two player game is visibile by keeping track of button visibility
		assertEquals(false, mainMenu.twoPlayer.isVisible());
		//checks that the single player scene is not visible by keeping track of button visibility
		assertEquals(true, mainMenu.onePlayer.isVisible());
		
	}
	
	@Test
	void quitButtonPresses() {
		mainMenu.quit.doClick();
		
		assertEquals(false, mainMenu.quit.isVisible());
	}
	
	
	
}

