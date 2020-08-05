package spaceshapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements a
 * common movement algorithm. Shape subclasses must override method paint() to
 * handle shape-specific painting.
 * 
 * Design Pattern used: 
 * 1. Composite
 * 2. Template
 * 
 * @author Simon Cheng && Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;

	protected static final int DEFAULT_Y_POS = 0;

	protected static final int DEFAULT_DELTA_X = 5;

	protected static final int DEFAULT_DELTA_Y = 5;

	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;

	protected static final String DEFAULT_TEXT = "";
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	// ===

	// a shape's parent
	protected CarrierShape _parent = null;

	// a shape's text
	protected String _text = DEFAULT_TEXT;

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y,
				DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}

	/**
	 * Creates a Shape object with a specified x and y position. The text is
	 * remained default
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH,
				DEFAULT_HEIGHT, DEFAULT_TEXT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.The text is
	 * remained default
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values. The text is remained default
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		this(x, y, deltaX, deltaY, width, height, DEFAULT_TEXT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width,
	 * height and text values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height,
			String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_text = text;
	}

	/**
	 * Moves this Shape object within the specified bounds. On hitting a
	 * boundary the Shape instance bounces off and back into the two-
	 * dimensional world.
	 * 
	 * @param width  - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
	}

	/***
	 * Method that calls paintText() and paintShapeBorder()
	 */
	public final void paint(Painter painter) {
		paintText(painter);
		doPaint(painter);
	}

	/**
	 * Method that takes a Painter object which calls the drawCentredText method
	 * 
	 * @param painter the Painter object used for drawing the text at the centre
	 *                of a shape.
	 */
	protected void paintText(Painter painter) {
		painter.drawCentredText(_text, _x, _y, _width, _height);
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * 
	 * @param painter the Painter object used for drawing.
	 */
	protected abstract void doPaint(Painter painter);

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}

	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}

	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}

	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}

	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}

	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}

	/**
	 * Returns a String whose value is the fully qualified name of this class of
	 * object. E.g., when called on a RectangleShape instance, this method will
	 * return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}

	/**
	 * Returns the CarrierShape that contains the Shape that method parent is
	 * called on. If the callee object is not a child within a CarrierShape
	 * instance this method returns null.
	 */
	public CarrierShape parent() {
		return _parent;
	}

	/**
	 * Returns an ordered list of Shape objects. The first item within the list
	 * is the root CarrierShape of the containment hierarchy. The last item
	 * within the list is the callee object (hence this method always returns a
	 * list with at least one item). Any intermediate items are CarrierShapes
	 * that connect the root CarrierShape to the callee Shape. E.g., given:
	 *
	 * CarrierShape root = new CarrierShape(); CarrierShape intermediate = new
	 * CarrierShape(); Shape flying = new FlyingShape(); root.add(intermediate);
	 * intermediate.add(flying);
	 *
	 * a call to flying.path() yields: [root,intermediate,flying]
	 */
	public List<Shape> path() {
		ArrayList<Shape> path = new ArrayList<>();
		Shape temp_shape = this;
		while (temp_shape != null) {
			path.add(temp_shape);
			temp_shape = temp_shape.parent();
		}
		Collections.reverse(path);
		return path;
	}

	/***
	 * Method gets the text message of a shape
	 * 
	 * @return the text message
	 */
	public String getText() {
		return _text;
	}
	
	/***
	 * Method adds the text message of a shape
	 * 
	 * @return the text message
	 */
	public void addText(String text) {
		_text = text;
	}
}
