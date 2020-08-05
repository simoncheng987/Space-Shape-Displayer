package spaceshapes;

import java.awt.Color;

/**
 * Class to represent a dynamic space-shape; which it gets filled colored once
 * it hits the horizontal bound and became a normal retangle space shape once it
 * hits the vertical bounds.
 * 
 * @author Simon
 *
 */
public class DynamicShape extends Shape {

	Color _color = new Color(212, 212, 212);
	boolean fill_boolean = false;

	/**
	 * Default constructor that creates a DynamicShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicShape() {
		super();
	}

	/**
	 * Creates a DynamicShape object with a specified x and y position.
	 */
	public DynamicShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal
	 *               axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical
	 *               axis.
	 * @param width  width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width,
			int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal
	 *               axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical
	 *               axis.
	 * @param width  width in pixels.
	 * @param height height in pixels.
	 * @param text   text of a dynamic shape
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width,
			int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal
	 *               axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical
	 *               axis.
	 * @param width  width in pixels.
	 * @param height height in pixels.
	 * @param color  hits boundary and filled color.
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width,
			int height, Color color) {
		super(x, y, deltaX, deltaY, width, height);
		_color = color;
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal
	 *               axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical
	 *               axis.
	 * @param width  width in pixels.
	 * @param height height in pixels.
	 * @param color  its boundary and filled color.
	 * @param text   text of a dynamic shape
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width,
			int height, String text, Color color) {
		super(x, y, deltaX, deltaY, width, height, text);
		_color = color;
	}

	/**
	 * Method that detects horizontal edges
	 */
	public void detectHorizontalEdge(int frameWidth) {
		int nextX = _x + _deltaX;
		if ((nextX <= 0) || (nextX + _width >= frameWidth)) {
			fill_boolean = true;
		}
	}

	/**
	 * Method that detects vertical edges
	 */
	public void detectVerticalEdge(int frameHeight) {
		int nextY = _y + _deltaY;
		if ((nextY <= 0) || (nextY + _height >= frameHeight)) {
			fill_boolean = false;
		}
	}

	/**
	 * Method that detects horizontal edges and vertical edge then calls the
	 * move method from its super class
	 */
	public void move(int width, int height) {
		detectHorizontalEdge(width);
		detectVerticalEdge(height);
		super.move(width, height);
	}

	/**
	 * Paints this DynamicShape object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {
		if (fill_boolean) {
			Color temp_color = painter.getColor();
			painter.setColor(_color);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(temp_color);
		} else {
			painter.drawRect(_x, _y, _width, _height);
		}

	}


}
