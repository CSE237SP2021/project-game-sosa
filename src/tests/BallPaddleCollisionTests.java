package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sosa.MyGraphics;
import sosa.MyGraphics2Player;

class BallPaddleCollisionTests {

	private MyGraphics graphics;
	private MyGraphics2Player graphics2;
	
	@BeforeEach
	void setUpTestingObjects() {
		graphics = new MyGraphics();
		graphics2 = new MyGraphics2Player();
	}

	@Test
	void noCollisionsSinglePlayer() {
		graphics.getPongBall().setXVal(250);
		graphics.getPongBall().setYVal(250);
		double ballXVel = graphics.getPongBall().getXVelocity();
		// check for collision
		assertFalse(graphics.collision());
		// check that velocity doesn't change
		assertEquals(ballXVel, graphics.getPongBall().getXVelocity());
	}
	
	@Test
	void noCollisionsTwoPlayer() {
		graphics2.getPongBall().setXVal(250);
		graphics2.getPongBall().setYVal(250);
		double ballXVel = graphics2.getPongBall().getXVelocity();
		// check for collision
		assertFalse(graphics2.collision());
		// check that velocity doesn't change
		assertEquals(ballXVel, graphics2.getPongBall().getXVelocity());
	}
	
	@Test
	void leftCollisionSinglePlayer() {
		graphics.getPongBall().setXVal(15);
		graphics.getPongBall().setYVal(275);
		graphics.getRacket1().setYVal(250);
		double ballXVel = graphics.getPongBall().getXVelocity();
		// check for collision
		assertTrue(graphics.collision());
		// check that velocity changes
		assertEquals(-ballXVel, graphics2.getPongBall().getXVelocity());
	}
	
	@Test
	void rightCollisionSinglePlayer() {
		graphics.getPongBall().setXVal(485);
		graphics.getPongBall().setYVal(255);
		graphics.getRacket2().setYVal(250);
		double ballXVel = graphics.getPongBall().getXVelocity();
		// check for collision
		assertTrue(graphics.collision());
		// check that velocity changes
		assertEquals(-ballXVel, graphics2.getPongBall().getXVelocity());
	}
	
	@Test
	void leftCollisionTwoPlayer() {
		graphics2.getPongBall().setXVal(15);
		graphics2.getPongBall().setYVal(285);
		graphics2.getRacket1().setYVal(250);
		double ballXVel = graphics2.getPongBall().getXVelocity();
		// check for collision
		assertTrue(graphics2.collision());
		// check that velocity changes
		assertEquals(-ballXVel, graphics2.getPongBall().getXVelocity());
	}
	
	@Test
	void rightCollisionTwoPlayer() {
		graphics2.getPongBall().setXVal(485);
		graphics2.getPongBall().setYVal(295);
		graphics2.getRacket2().setYVal(250);
		double ballXVel = graphics2.getPongBall().getXVelocity();
		// check for collision
		assertTrue(graphics2.collision());
		// check that velocity changes
		assertEquals(-ballXVel, graphics2.getPongBall().getXVelocity());
	}

}
