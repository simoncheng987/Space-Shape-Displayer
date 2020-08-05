package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/**
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Simon Cheng && Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);

	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);

	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);

	/**
	 * Fills a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void fillRect(int x, int y, int width, int height);

	/**
	 * Returns a java.awt.Color value
	 */
	public Color getColor();

	/**
	 * Sets a java.awt.Color value with c
	 */
	public void setColor(Color c);

	/**
	 * Translates the origin of the graphics context to the point (x, y) in the
	 * current coordinate system.
	 */
	public void translate(int x, int y);

	/**
	 * draws text in the center of a shape
	 */
	public void drawCentredText(String str, int x, int y, int width,
			int height);
	
	public void drawImage(Image img, int x, int y, int width, int height);
}
