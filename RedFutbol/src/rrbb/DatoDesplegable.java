package rrbb;

import javax.swing.*;

import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class DatoDesplegable extends JPanel {

	private JLabel etiqueta;
	private JComboBox valor;
	
	public DatoDesplegable (JComponent panel, String et, List<String> opciones) {
		etiqueta = new JLabel(et);
	
		setLayout(new FlowLayout());
		add(etiqueta);
		valor = new JComboBox(opciones.toArray());
		add(valor);
		panel.add(this);
	}

	/**
	 * 
	 * @return Cadena o nulo;
	 */
	public String getValor () {
		String res;
		if (valor.getSelectedIndex() <= 0) {
			res = null;
		} else {
			res = (String) valor.getSelectedItem();
		}
		return res;
	}
	
}
