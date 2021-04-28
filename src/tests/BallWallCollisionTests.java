package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sosa.MyGraphics;
import sosa.MyGraphics2Player;

class BallWallCollisionTests {

	private MyGraphics graphics;
	private MyGraphics2Player graphics2;
	
	@BeforeEach
	void setUpTestingObjects() {
		graphics = new MyGraphics();
		graphics2 = new MyGraphics2Player();
	}
	
	@Test
	void noCollisionsSinglePlayer() {
		graphics.getPongBall().setYVal(250);
		double ballYVel = graphics.getPongBall().getYVelocity();
		// check for collision
		assertFalse(graphics.hitWall());
		// check that velocity doesn't change
		assertEquals(ballYVel, graphics.getPongBall().getYVelocity());
	}
	
	@Test
	void noCollisionsTwoPlayer() {
		graphics2.getPongBall().setYVal(300);
		double ballYVel = graphics2.getPongBall().getYVelocity();
		// check for collision
		assertFalse(graphics2.hitWall());
		// check that velocity doesn't change
		assertEquals(ballYVel, graphics2.getPongBall().getYVelocity());
	}
	
	@Test
	void topCollisionSinglePlayer() {
		graphics.getPongBall().setYVelocity(-1);
		graphics.getPongBall().setYVal(graphics.getPongBall().getLowerBounds());
		double ballYVel = graphics.getPongBall().getYVelocity();
		// check for collision
		assertTrue(graphics.hitWall());
		// check that velocity changes
		assertEquals(-1*ballYVel, graphics.getPongBall().getYVelocity());
	}
	
	@Test
	void bottomCollisionSinglePlayer() {
		graphics.getPongBall().setYVelocity(1);
		graphics.getPongBall().setYVal(graphics.getPongBall().getUpperBounds());
		double ballYVel = graphics.getPongBall().getYVelocity();
		// check for collision
		assertTrue(graphics.hitWall());
		// check that velocity changes
		assertEquals(-1*ballYVel, graphics.getPongBall().getYVelocity());
	}
	
	@Test
	void topCollisionTwoPlayer() {
		graphics2.getPongBall().setYVelocity(-1);
		graphics2.getPongBall().setYVal(graphics2.getPongBall().getLowerBounds());
		double ballYVel = graphics2.getPongBall().getYVelocity();
		// check for collision
		assertTrue(graphics2.hitWall());
		// check that velocity changes
		assertEquals(-1*ballYVel, graphics2.getPongBall().getYVelocity());
	}
	
	@Test
	void bottomCollisionTwoPlayer() {
		graphics2.getPongBall().setYVelocity(1);
		graphics2.getPongBall().setYVal(graphics2.getPongBall().getUpperBounds());
		double ballYVel = graphics2.getPongBall().getYVelocity();
		// check for collision
		assertTrue(graphics2.hitWall());
		// check that velocity changes
		assertEquals(-1*ballYVel, graphics2.getPongBall().getYVelocity());
	}

}
