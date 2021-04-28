package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sosa.MyGraphics;
import sosa.Racket2;

class SmartComputerRacketTests {

	private MyGraphics graphics;
	private final int MOVE_UP = 1;
	private final int STAY_PUT = 2;
	private final int MOVE_DOWN = 3;
	
	@BeforeEach
	void setUpTestingObjects() {
		graphics = new MyGraphics();
	}
	
	@Test
	void racketMovesUpFar() {
		graphics.getPongBall().setYVal(100);
		graphics.getRacket2().setYVal(300);
		// check that racket will move up
		assertEquals(MOVE_UP, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is negative
		assertTrue(0 > graphics.getRacket2().getVelocity());
		// check that yVal is properly updated
		assertEquals(300 + graphics.getRacket2().getVelocity(), graphics.getRacket2().getYVal());
		// check that midYVal is properly updated
		assertEquals(graphics.getRacket2().getYVal() + graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getMidYVal());
	}
	
	@Test
	void racketMovesDownFar() {
		graphics.getPongBall().setYVal(400);
		graphics.getRacket2().setYVal(100);
		// check that racket will move down
		assertEquals(MOVE_DOWN, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is positive
		assertTrue(0 < graphics.getRacket2().getVelocity());
		// check that yVal is properly updated
		assertEquals(100 + graphics.getRacket2().getVelocity(), graphics.getRacket2().getYVal());
		// check that midYVal is properly updated
		assertEquals(graphics.getRacket2().getYVal() + graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getMidYVal());
	}
	
	@Test
	void racketStaysInPlace() {
		graphics.getPongBall().setYVal(200);
		graphics.getRacket2().setMidYVal(200);
		// check that racket stays in place
		assertEquals(STAY_PUT, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is 0
		assertEquals(0, graphics.getRacket2().getVelocity());
		// check that midYVal is properly updated
		assertEquals(200 + graphics.getRacket2().getVelocity(), graphics.getRacket2().getMidYVal());
		// check that yVal is properly updated
		assertEquals(graphics.getRacket2().getMidYVal() - graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getYVal());
	}
	
	@Test
	void racketMovesUpClose() {
		graphics.getPongBall().setYVal(100);
		graphics.getRacket2().setYVal(90);
		// check that racket will move up
		assertEquals(MOVE_UP, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is negative
		assertTrue(0 > graphics.getRacket2().getVelocity());
		// check that yVal is properly updated
		assertEquals(90 + graphics.getRacket2().getVelocity(), graphics.getRacket2().getYVal());
		// check that midYVal is properly updated
		assertEquals(graphics.getRacket2().getYVal() + graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getMidYVal());
	}
	
	@Test
	void racketMovesDownClose() {
		graphics.getPongBall().setYVal(300);
		graphics.getRacket2().setYVal(270);
		// check that racket will move down
		assertEquals(MOVE_DOWN, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is positive
		assertTrue(0 < graphics.getRacket2().getVelocity());
		// check that yVal is properly updated
		assertEquals(270 + graphics.getRacket2().getVelocity(), graphics.getRacket2().getYVal());
		// check that midYVal is properly updated
		assertEquals(graphics.getRacket2().getYVal() + graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getMidYVal());
	}
	
	@Test
	void ballAboveAtTopBoundary() {
		graphics.getPongBall().setYVal(1);
		graphics.getRacket2().setYVal(0);
		// check that racket tries to move up
		assertEquals(MOVE_UP, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is 0 (can't move up due to boundary)
		assertEquals(0, graphics.getRacket2().getVelocity());
		// check that yVal is properly updated
		assertEquals(0, graphics.getRacket2().getYVal());
		// check that midYVal is properly updated
		assertEquals(graphics.getRacket2().getYVal() + graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getMidYVal());
	}
	
	@Test
	void ballBelowAtBottomBoundary() {
		graphics.getPongBall().setYVal(469);
		graphics.getRacket2().setYVal(425);
		// check that racket tries move down
		assertEquals(MOVE_DOWN, graphics.getRacket2().compareToBallY(graphics.getPongBall().getYVal()));
		graphics.getRacket2().move();
		// check that velocity is 0 (can't move down due to boundary)
		assertEquals(0, graphics.getRacket2().getVelocity());
		// check that yVal is properly updated
		assertEquals(425, graphics.getRacket2().getYVal());
		// check that midYVal is properly updated
		assertEquals(graphics.getRacket2().getYVal() + graphics.getRacket2().getHalfHeight(), graphics.getRacket2().getMidYVal());
	}

}
