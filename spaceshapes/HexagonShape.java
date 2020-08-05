package spaceshapes;

/**
 * Class to represent a simple hexagon space-shape.
 * 
 * @author Simon Cheng
 * 
 */
public class HexagonShape extends Shape {
	/**
	 * Default constructor that creates a HexagonShape instance whose instance
	 * variables are set to default values.
	 */
	public HexagonShape() {
		super();
	}

	/**
	 * Creates a HexagonShape object with a specified x and y position.
	 */
	public HexagonShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param width  width of a hexagon shape.
	 * @param height height of a hexagon shape.
	 * 
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width,
			int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param width  width of a hexagon shape.
	 * @param height height of a hexagon shape.
	 * @param text   text of a HexagonShape
	 * 
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width,
			int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}

	/**
	 * Paints this HexagonShape object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {

		if (this.width() >= 40) {
			painter.drawLine(_x, _y + _height / 2, _x + 20, _y);
			painter.drawLine(_x + 20, _y, _x + _width - 20, _y);
			painter.drawLine(_x + _width - 20, _y, _x + _width,
					_y + _height / 2);
			painter.drawLine(_x + _width, _y + _height / 2, _x + _width - 20,
					_y + _height);
			painter.drawLine(_x + _width - 20, _y + _height, _x + 20,
					_y + _height);
			painter.drawLine(_x + 20, _y + _height, _x, _y + _height / 2);
		} else {
			painter.drawLine(_x, _y + _height / 2, _x + _width / 2, _y);
			painter.drawLine(_x + _width / 2, _y, _x + _width,
					_y + _height / 2);
			painter.drawLine(_x + _width, _y + _height / 2, _x + _width / 2,
					_y + _height);
			painter.drawLine(_x + _width / 2, _y + _height, _x,
					_y + _height / 2);
		}

	}

}
