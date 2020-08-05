package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Simon Cheng && Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * @see spaeshapes.Painter.fillRect.
	 */
	@Override
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.getColor.
	 */
	@Override
	public Color getColor() {
		return _g.getColor();
	}

	/**
	 * @see spaeshapes.Painter.setColor.
	 */
	@Override
	public void setColor(Color c) {
		_g.setColor(c);
	}

	/**
	 * @see spaeshapes.Painter.translate.
	 */
	public void translate(int x, int y) {
		_g.translate(x, y);
	}

	/**
	 * draws text at the center of a shape
	 */
	public void drawCentredText(String str, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		FontMetrics font_metric = _g.getFontMetrics();
		int ascent = font_metric.getAscent();
		int descent = font_metric.getDescent();
		int modified_y = y + (ascent - descent) / 2 + height / 2;
		int modified_x = x - font_metric.stringWidth(str) / 2 + width / 2;
		_g.drawString(str, modified_x, modified_y);
	}

	@Override
	public void drawImage(Image img, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		_g.drawImage(img, x, y, width, height, null);
	}

}
