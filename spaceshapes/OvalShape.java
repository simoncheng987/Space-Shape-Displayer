package spaceshapes;

/**
 * Class to represent a simple oval space-shape.
 * 
 * @author Simon Cheng
 * 
 */
public class OvalShape extends Shape {
	/**
	 * Default constructor that creates a OvalShape instance whose instance
	 * variables are set to default values.
	 */
	public OvalShape() {
		super();
	}
	
	/**
	 * Creates a OvalShape object with a specified x and y position.
	 */
	public OvalShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a OvalShape instance with specified values for instance variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	/**
	 * Creates a HexagonShape instance with specified values for instance variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param width  width of a hexagon shape.
	 * @param height height of a hexagon shape.
	 * 
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	/**
	 * Creates a HexagonShape instance with specified values for instance variables.
	 * 
	 * @param x      x position.
	 * @param y      y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param width  width of a hexagon shape.
	 * @param height height of a hexagon shape.
	 * @param text	 text of an oval shape
	 * 
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}

	/**
	 * Paints this OvalShape object using the supplied Painter object.
	 */
	@Override
	protected void doPaint(Painter painter) {
		painter.drawOval(_x,_y,_width,_height);
	}


}
