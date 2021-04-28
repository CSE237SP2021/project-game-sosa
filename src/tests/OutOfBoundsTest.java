package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sosa.MyGraphics;

class OutOfBoundsTest {

	private MyGraphics graphics;
	
	@BeforeEach
	void setUpTestingObjects() {
		graphics = new MyGraphics();
	}
	
	@Test
	void checkOutOfBoundsLeft() {
		graphics.getPongBall().setXVal(graphics.getPongBall().getLeftwardBounds() - 20);
		assertTrue(graphics.getPongBall().outOfBoundsLeft());
	}
	
	@Test
	void checkOutOfBoundsRight() {
		graphics.getPongBall().setXVal(graphics.getPongBall().getRightwardBounds() + 20);
		assertTrue(graphics.getPongBall().outOfBoundsRight());
	}
	
	@Test
	void testRacket1Scored() {
		int scoreBefore = graphics.getRacket1().getScore();
		graphics.getPongBall().setXVal(graphics.getPongBall().getRightwardBounds() + 20);
		if (graphics.getPongBall().outOfBoundsRight()) {
			graphics.getRacket1().scorePoint();
		}
		int scoreAfter = graphics.getRacket1().getScore();
		assertEquals(scoreBefore + 1, scoreAfter);
	}
	
	@Test 
	void testRacket2Scored() {
		int scoreBefore = graphics.getRacket2().getScore();
		graphics.getPongBall().setXVal(graphics.getPongBall().getLeftwardBounds() - 20);
		if (graphics.getPongBall().outOfBoundsLeft()) {
			graphics.getRacket2().scorePoint();
		}
		int scoreAfter = graphics.getRacket2().getScore();
		assertEquals(scoreBefore + 1, scoreAfter);
	}
	
	@Test
	void checkResetOnOutOfBounds() {
		
		// Move the paddles
		graphics.getRacket1().pressDown();
		for (int i = 0; i < 20; i++) {
			graphics.getRacket1().move();
			graphics.getRacket2().move();
		}
		// Left out of bounds
		graphics.getPongBall().setXVal(graphics.getPongBall().getLeftwardBounds() - 20);
		// Move down a little bit
		graphics.getPongBall().setYVal(graphics.getPongBall().getYVal() + 25);
		graphics.resetPositions();
		assertEquals(graphics.getPongBall().getInitX(), graphics.getPongBall().getXVal(), 0.01);
		assertEquals(graphics.getPongBall().getInitY(), graphics.getPongBall().getYVal(), 0.01);
		assertEquals(graphics.getRacket1().getInitY(), graphics.getRacket1().getYVal(), 0.01);
		assertEquals(graphics.getRacket2().getInitY(), graphics.getRacket2().getYVal(), 0.01);
		
		// Move the paddles
		graphics.getRacket1().pressDown();
		for (int i = 0; i < 20; i++) {
			graphics.getRacket1().move();
			graphics.getRacket2().move();
		}
		// Right out of bounds
		graphics.getPongBall().setXVal(graphics.getPongBall().getRightwardBounds() + 20);
		// Move up a little bit
		graphics.getPongBall().setYVal(graphics.getPongBall().getYVal() - 25);
		graphics.resetPositions();
		assertEquals(graphics.getPongBall().getInitX(), graphics.getPongBall().getXVal(), 0.01);
		assertEquals(graphics.getPongBall().getInitY(), graphics.getPongBall().getYVal(), 0.01);
		assertEquals(graphics.getRacket1().getInitY(), graphics.getRacket1().getYVal(), 0.01);
		assertEquals(graphics.getRacket2().getInitY(), graphics.getRacket2().getYVal(), 0.01);
	}

}
