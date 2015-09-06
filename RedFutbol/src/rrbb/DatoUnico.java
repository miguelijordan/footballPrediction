package rrbb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class DatoUnico extends JPanel {
	
	private JLabel etiqueta;
	private List<JRadioButton> valores;
	private ButtonGroup valor;
	
	public DatoUnico (JComponent panel, String et, List<JRadioButton> opciones) {
		etiqueta = new JLabel(et);
		valores = new ArrayList<JRadioButton>(opciones);
	
		setLayout(new FlowLayout());
		add(etiqueta);
		valor = new ButtonGroup();
		for (JRadioButton b : valores) {
			valor.add(b);
			add(b);
		}
		panel.add(this);
	}
	
	public String getValor () {
		String res = null;
		
		if (! valores.get(valores.size()-1).isSelected()) {
			Iterator<JRadioButton> iter = valores.iterator();
			boolean seleccionado = false;
			while (iter.hasNext() && !seleccionado) {
				JRadioButton b = iter.next();
				if (b.isSelected()) {
					seleccionado = true;
					res = b.getText();
				}
			}	
		}
		return res;
	}
}
