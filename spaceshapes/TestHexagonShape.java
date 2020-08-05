package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of classes HexagonShape
 * 
 * @author Simon Cheng
 * 
 */
public class TestHexagonShape {
	
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so that
	 * there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a small
	 * HexagonShape's position after the movement is correct.
	 */
	@Test
	public void testSmallHexagonSimpleMove() {
		HexagonShape shape = new HexagonShape(100, 100, 10, 20);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(line 100,117,112,100)(line 112,100,125,117)(line 125,117,112,135)(line 112,135,100,117)"
				+ "(line 110,137,122,120)(line 122,120,135,137)(line 135,137,122,155)(line 122,155,110,137)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to ensure
	 * that the small HexagonShape's position after the movement is correct.
	 */
	@Test
	public void testSmallHexagonMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 100, 100, 200);
		shape.paint(_painter);
		shape.move(150, 10000);
		shape.paint(_painter);
		assertEquals(
				"(line 100,117,112,100)(line 112,100,125,117)(line 125,117,112,135)(line 112,135,100,117)"
				+ "(line 125,317,137,300)(line 137,300,150,317)(line 150,317,137,335)(line 137,335,125,317)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to ensure
	 * that the small HexagonShape's position after the movement is correct.
	 */
	@Test
	public void testSmallHexagonMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(10, 20, -10, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals(
				"(line 10,37,22,20)(line 22,20,35,37)(line 35,37,22,55)(line 22,55,10,37)"
				+ "(line 0,52,12,35)(line 12,35,25,52)(line 25,52,12,70)(line 12,70,0,52)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to ensure
	 * that the small HexagonShape's position after the movement is correct.
	 */
	@Test
	// to be done
	public void testSmallHexagonMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(40, 10, 10, 10);
		shape.paint(_painter);
		shape.move(70, 50);
		shape.paint(_painter);
		shape.move(70, 50);
		shape.paint(_painter);
		assertEquals(
				"(line 40,27,52,10)(line 52,10,65,27)(line 65,27,52,45)(line 52,45,40,27)"
				+ "(line 45,32,57,15)(line 57,15,70,32)(line 70,32,57,50)(line 57,50,45,32)"
				+ "(line 35,22,47,5)(line 47,5,60,22)(line 60,22,47,40)(line 47,40,35,22)",
				_painter.toString());
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a regular
	 * HexagonShape's position after the movement is correct.
	 */
	@Test
	public void testRegularHexagonSimpleMove() {
		HexagonShape shape = new HexagonShape(200, 200, 2, 3, 50, 50);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(line 200,225,220,200)(line 220,200,230,200)(line 230,200,250,225)(line 250,225,230,250)(line 230,250,220,250)(line 220,250,200,225)"
				+ "(line 202,228,222,203)(line 222,203,232,203)(line 232,203,252,228)(line 252,228,232,253)(line 232,253,222,253)(line 222,253,202,228)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to ensure
	 * that the regular HexagonShape's position after the movement is correct.
	 */
	@Test
	public void testRegularHexagonMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(200, 200, 300, 3, 50, 50);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(line 200,225,220,200)(line 220,200,230,200)(line 230,200,250,225)(line 250,225,230,250)(line 230,250,220,250)(line 220,250,200,225)"
				+ "(line 450,228,470,203)(line 470,203,480,203)(line 480,203,500,228)(line 500,228,480,253)(line 480,253,470,253)(line 470,253,450,228)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to ensure
	 * that the regular HexagonShape's position after the movement is correct.
	 */
	@Test
	public void testRegularHexagonMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(200, 200, -300, 3, 50, 50);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(line 200,225,220,200)(line 220,200,230,200)(line 230,200,250,225)(line 250,225,230,250)(line 230,250,220,250)(line 220,250,200,225)"
				+ "(line 0,228,20,203)(line 20,203,30,203)(line 30,203,50,228)(line 50,228,30,253)(line 30,253,20,253)(line 20,253,0,228)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom left corner and to ensure
	 * that the regular HexagonShape's position after the movement is correct.
	 */
	@Test
	// to be done
	public void testRegularHexagonMoveWithBounceOffBottomAndLeft() {
		HexagonShape shape = new HexagonShape(200, 200, -300, 400, 50, 50);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(line 200,225,220,200)(line 220,200,230,200)(line 230,200,250,225)(line 250,225,230,250)(line 230,250,220,250)(line 220,250,200,225)"
				+ "(line 0,475,20,450)(line 20,450,30,450)(line 30,450,50,475)(line 50,475,30,500)(line 30,500,20,500)(line 20,500,0,475)",
				_painter.toString());
	}
}
