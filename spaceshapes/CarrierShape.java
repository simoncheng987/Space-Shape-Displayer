package spaceshapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a carrier space-shape. A CarrierShape instance is unique
 * in that it contains zero or more Shapes that bounce around inside it. The
 * children of a CarrierShape instance can be either simple Shapes, like
 * RectangleShape and OvalShape objects, or other CarrierShape instances.
 * 
 * @author Simon Cheng
 *
 */
public class CarrierShape extends Shape {

	// List of children of a carrier shape
	List<Shape> _children = new ArrayList<>();

	/**
	 * Default constructor that creates a CarrierShape instance whose instance
	 * variables are set to default values.
	 */
	public CarrierShape() {
		super();
	}

	/**
	 * Creates a CarrierShape object with a specified x and y position.
	 */
	public CarrierShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a CarrierShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates a CarrierShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param width  width of a carrier shape.
	 * @param height height of a carrier shape.
	 * 
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width,
			int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	/**
	 * Creates a CarrierShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param width  width of a carrier shape.
	 * @param height height of a carrier shape.
	 * @param text   the text of a carrier shape
	 * 
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width,
			int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}

	/**
	 * Moves a CarrierShape like RectangleShape. And sets its width and height
	 * as the bound to its children
	 */
	public void move(int width, int height) {
		super.move(width, height);
		for (Shape shape : _children) {
			shape.move(_width, _height);
		}
	}

	/**
	 * Paints the CarrierShape object and its children. Its children will move
	 * inside of the rectangle bound set by the CarrierShape
	 */
	protected void doPaint(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		painter.translate(_x, _y);
		for (Shape shape : _children) {
			shape.paint(painter);
		}
		painter.translate(-_x, -_y);
	}

	/**
	 * Attempts to add a Shape to a CarrierShape object. If successful, a
	 * two-way link is established between the CarrierShape and the newly added
	 * Shape.
	 * 
	 * @param Shape the Shape to be added.
	 * @throws IllegalArgumentException if an attempt is made to add a Shape to
	 *                                  a CarrierShape instance where the Shape
	 *                                  argument is already a child within a
	 *                                  CarrierShape instance. An
	 *                                  IllegalArgumentException is also thrown
	 *                                  when an attempt is made to add a Shape
	 *                                  that will not fit within the bounds of
	 *                                  the proposed CarrierShape object.
	 */
	void add(Shape shape) throws IllegalArgumentException {
		// check whether the child of a carrier shape does not fit
		// also check whether there is an exisitng parent to the current adding
		// child
		if ((shape._x < _x) || (shape._y < _y) || (shape._width > _width)
				|| (shape._height > _height) || (shape._x + shape._width > _x + _width)
				|| (shape._y + shape._height > _y + _height)) {
			throw new IllegalArgumentException();
		} else if (shape._parent != null) {
			throw new IllegalArgumentException();
		} else {
			// add shape to the children list and set the current carrier shape
			// as its parent
			_children.add(shape);
			shape._parent = this;
		}
	}

	/**
	 * Removes a particular Shape from a CarrierShape instance. Once removed,
	 * the two-way link between the CarrierShape and its former child is
	 * destroyed. This method has no effect if the Shape specified to remove is
	 * not a child of the CarrierShape.
	 * 
	 * @param Shape the Shape to be removed.
	 */
	void remove(Shape shape) {
		_children.remove(this.indexOf(shape));
		shape._parent = null;
	}

	/**
	 * Returns the Shape at a specified position within a CarrierShape. If the
	 * position specified is less than zero or greater than the number of
	 * children stored in the CarrierShape less one this method throws an
	 * IndexOutOfBoundsException.
	 * 
	 * @param index the specified index position.
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > _children.size() - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			return _children.get(index);
		}

	}

	/**
	 * Returns the number of children contained within a CarrierShape object.
	 */
	public int shapeCount() {
		return _children.size();

	}

	/**
	 * Returns the index of a specified child within a CarrierShape object. If
	 * the Shape specified is not actually a child of the CarrierShape this
	 * method returns -1; otherwise the value returned is in the range 0 ..
	 * ShapeCount() - 1.
	 * 
	 * @param Shape the Shape whose index position within the CarrierShape is
	 *              requested.
	 */
	public int indexOf(Shape shape) {
		return _children.indexOf(shape);
	}

	/**
	 * Returns true if the Shape argument is a child of the CarrierShape object
	 * on which this method is called, false otherwise.
	 */
	public boolean contains(Shape shape) {
		if (this.indexOf(shape) == -1) {
			return false;
		}
		return true;
	}

}
