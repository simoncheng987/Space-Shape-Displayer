package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's log can
 * be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Simon Cheng && Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();
	private Color _color = new Color(212, 212, 212);

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append(
				"(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	/**
	 * Logs the fillRect call.
	 */
	@Override
	public void fillRect(int x, int y, int width, int height) {
		_log.append("(fill rectangle " + x + "," + y + "," + width + ","
				+ height + ")");
	}

	/**
	 * Logs the getColor call.
	 */
	@Override
	public Color getColor() {
		_log.append("(color_before: " + _color + ")");
		return _color;
	}

	/**
	 * Logs the setColor call.
	 */
	@Override
	public void setColor(Color c) {
		_color = c;
		_log.append("(color_set_to: " + c + ")");
	}

	/**
	 * Leave empty as asked to
	 */
	@Override
	public void translate(int x, int y) {
		// TODO Auto-generated method stub

	}

	/**
	 * Leave empty as asked to
	 */
	@Override
	public void drawCentredText(String str, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawImage(Image img, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
}