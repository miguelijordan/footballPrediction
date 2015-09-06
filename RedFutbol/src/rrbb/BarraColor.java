package rrbb;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BarraColor extends JPanel {

	private static final int ALTURA_BARRA = 15;
	
	private int longitud;
	private Color color;
	
	public BarraColor(int l, Color c) {
		this.longitud = l;
		this.color = c;
		setForeground(color);
	}
	
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, longitud, ALTURA_BARRA);
	}
	
	public void cambiaLongitud(int l) {
		this.longitud = l;
		repaint();
	}

}
