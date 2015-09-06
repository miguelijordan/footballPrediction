package rrbb;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BarraProbabilidad extends JPanel {

	private JLabel titulo;
	private BarraColor barra;
	private JLabel probabilidad;
	private GridBagConstraints constraints;
	
	public BarraProbabilidad(String tit, double prob, Color c) {
		this.titulo = new JLabel(tit);
		barra = new BarraColor((int)prob, c);
		this.probabilidad = new JLabel(prob + " %");
		
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font("Courier New", auxFont.getStyle(), 15));
		
		// Aplicamos el gestor de esquemas
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		
		// Situamos los componentes.
		ajustarComponente(0,0,1,1,0.1,0);
		add(titulo, constraints);
		ajustarComponente(1,0,3,1,1,0);
		add(barra, constraints);
		ajustarComponente(4,0,1,1,0.1,0);
		add(probabilidad, constraints);
		
		
	}

	public void cambiarProbabilidad(double p) {
		this.probabilidad.setText(new String(p+" %"));
		int longitud = (int) p;
		this.barra.cambiaLongitud(longitud);
	}
	
	private void ajustarComponente(int posX, int posY, int ancho, int alto, double estirarX, double estirarY) {
		constraints.gridx = posX;
		constraints.gridy = posY;
		constraints.gridwidth = ancho;
		constraints.gridheight = alto;
		constraints.weightx = estirarX;
		constraints.weighty = estirarY;
		constraints.fill = GridBagConstraints.BOTH;
	}
}
