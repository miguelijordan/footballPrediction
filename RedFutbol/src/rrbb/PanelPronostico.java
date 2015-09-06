package rrbb;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelPronostico extends JPanel {

	private ArrayList<BarraProbabilidad> resultados;
	
	public PanelPronostico(Color[] colores, String[] marcadores) {
		resultados = new ArrayList<BarraProbabilidad>();
		for (int i = 0; i < marcadores.length; i++) {
			resultados.add(new BarraProbabilidad(marcadores[i], 100, colores[i%colores.length]));
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (BarraProbabilidad b : resultados) {
			add(b);
		}
	}
	
	public void actualizarValores(double[] v) {
		int i = 0;
		for (BarraProbabilidad b : resultados) {
			b.cambiarProbabilidad(v[i]);
			i++;
		}
	}
	
}
