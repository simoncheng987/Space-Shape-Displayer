package spaceshapes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of classes DynamicShape
 * 
 * @author Simon Cheng
 * 
 */
public class TestDynamicShape {
	// Fixture object that is used by the tests.
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
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * DynamicShape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		DynamicShape shape = new DynamicShape(10, 10, 10, 10, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 10,10,10,10)"
				+ "(rectangle 20,20,10,10)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		DynamicShape shape = new DynamicShape(485, 10, 10, 10, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 485,10,10,10)"
				+ "(color_before: java.awt.Color[r=212,g=212,b=212])(color_set_to: java.awt.Color[r=12,g=12,b=12])(fill rectangle 490,20,10,10)(color_set_to: java.awt.Color[r=212,g=212,b=212])",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		DynamicShape shape = new DynamicShape(5, 10, -10, 10, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 5,10,10,10)"
				+ "(color_before: java.awt.Color[r=212,g=212,b=212])(color_set_to: java.awt.Color[r=12,g=12,b=12])(fill rectangle 0,20,10,10)(color_set_to: java.awt.Color[r=212,g=212,b=212])",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the top boundary and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTop() {
		DynamicShape shape = new DynamicShape(10, 10, 10, -100, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 10,10,10,10)"
				+ "(rectangle 20,0,10,10)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom boundary and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottom() {
		DynamicShape shape = new DynamicShape(10, 410, 10, 100, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 10,410,10,10)"
				+ "(rectangle 20,490,10,10)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom left corner and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		DynamicShape shape = new DynamicShape(180, 440, -100, 100, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 180,440,10,10)"
				+ "(rectangle 80,490,10,10)"
				+ "(color_before: java.awt.Color[r=212,g=212,b=212])(color_set_to: java.awt.Color[r=12,g=12,b=12])(fill rectangle 0,390,10,10)(color_set_to: java.awt.Color[r=212,g=212,b=212])",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(380, 440, 100, 100, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 380,440,10,10)"
				+ "(rectangle 480,490,10,10)"
				+ "(color_before: java.awt.Color[r=212,g=212,b=212])(color_set_to: java.awt.Color[r=12,g=12,b=12])(fill rectangle 490,390,10,10)(color_set_to: java.awt.Color[r=212,g=212,b=212])",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the Top right corner and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndRight() {
		DynamicShape shape = new DynamicShape(380, 40, 100, -100, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 380,40,10,10)"
				+ "(rectangle 480,0,10,10)"
				+ "(color_before: java.awt.Color[r=212,g=212,b=212])(color_set_to: java.awt.Color[r=12,g=12,b=12])(fill rectangle 490,100,10,10)(color_set_to: java.awt.Color[r=212,g=212,b=212])",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the Top left corner and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndLeft() {
		DynamicShape shape = new DynamicShape(180, 40, -100, -100, 10, 10, new Color(12, 12, 12));
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals(
				"(rectangle 180,40,10,10)"
				+ "(rectangle 80,0,10,10)"
				+ "(color_before: java.awt.Color[r=212,g=212,b=212])(color_set_to: java.awt.Color[r=12,g=12,b=12])(fill rectangle 0,100,10,10)(color_set_to: java.awt.Color[r=212,g=212,b=212])",
				_painter.toString());
	}
}
