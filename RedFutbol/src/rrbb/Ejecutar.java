package rrbb;

import javax.swing.JFrame;

public class Ejecutar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("user.dir"));
		RedBayesiana r = new RedBayesiana("redFutbol.xdsl");
		
		Interfaz v = new Interfaz();
		Controlador ctr = new Controlador(v, r);
		v.controlador(ctr);
		JFrame ventana = new JFrame("Pronóstico fútbol");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(v);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
