package rrbb;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class DatoNumerico extends JPanel {

	private JLabel etiqueta;
	private JTextField valor;
	
	public DatoNumerico (JComponent panel, String et) {
		setLayout(new FlowLayout());
		etiqueta = new JLabel(et);
		valor = new JTextField(5);
		add(etiqueta);
		add(valor);
		panel.add(this);
	}
	
	public Integer getValor () {
		Double v;
		Integer res = null;
		try {
			v = Double.parseDouble(valor.getText());
		} catch (NumberFormatException e) {
			v = null;
		}
		if (v != null && v < 0) {
			v = null;
		}
		if (v != null) {
			res = v.intValue();
		}
		return res;
	}
	
}
