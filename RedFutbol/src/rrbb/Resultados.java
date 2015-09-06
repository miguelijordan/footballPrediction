package rrbb;

import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Resultados extends JPanel {

	private static final Color[] coloresResultados = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
	private static final Color[] coloresGoles = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.YELLOW};
	private static final Color[] coloresSignos = {Color.BLUE, Color.YELLOW, Color.RED};
	private static final String[] sResultados = {"0-0  ", "1-0  ", "2-0  ", "M2-0 ", "0-1  ", "1-1  ", "2-1  ", "M2-1 ", "0-2  ", "1-2  ", "2-2  ", "M2-2 ", "0-M2 ", "1-M2 ", "2-M2 ", "M2-M2"};
	private static final String[] sSignos = {"1", "X", "2"};
	private static final String[] sGoles = {"0 ", "1 ", "2 ", "3 ", "4 ", "5 ", "+5"};
	
	private JLabel lNombreEquipoLocal;
	private JLabel lNombreEquipoVisitante;
	
	private PanelPronostico resultados;
	private PanelPronostico signos;
	private PanelPronostico golesL;
	private PanelPronostico golesV;
	
	private JLabel lGolesL;
	private JLabel lGolesV;
	private JLabel lResultados;
	private JLabel lSigno;
	
	private GridBagConstraints constraints;
	
	public Resultados () {
		// Creamos los componentes
		lNombreEquipoLocal = new JLabel("Equipo Local");
		lNombreEquipoVisitante = new JLabel("Equipo Visitante");
		// cojo la fuente que usa actualmente.
		Font auxFont = lNombreEquipoLocal.getFont();
		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		lNombreEquipoLocal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		lNombreEquipoVisitante.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
	
		resultados = new PanelPronostico(coloresResultados, sResultados);
		signos = new PanelPronostico(coloresSignos, sSignos);
		golesL = new PanelPronostico(coloresGoles, sGoles);
		golesV = new PanelPronostico(coloresGoles, sGoles);
		
		
		lGolesL = new JLabel("Número de goles:");
		lGolesV = new JLabel("Número de goles:");
		lResultados = new JLabel("Resultado:");
		lSigno = new JLabel("Signo: ");
		
		
		// Aplicamos el gestor de esquemas
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		
		// Situamos los componentes.
		ajustarComponente(0,0,1,1, 0, 0);
		add(lNombreEquipoLocal, constraints);
		ajustarComponente(6,0,1,1, 0, 0);
		add(lNombreEquipoVisitante, constraints);
		ajustarComponente(0,1,1,1, 0, 0);
		add(lGolesL, constraints);
		ajustarComponente(6,1,1,1, 0, 0);
		add(lGolesV, constraints);
		ajustarComponente(0,2,1,1, 0, 0);
		add(golesL, constraints);
		ajustarComponente(6,2,1,1, 0, 0);
		add(golesV, constraints);

		ajustarComponente(3,4,1,1, 1, 0);
		add(lResultados, constraints);
		ajustarComponente(3,5,1,3, 1, 1);
		add(resultados, constraints);
		ajustarComponente(2,9,1,1, 0, 0);
		add(lSigno, constraints);
		ajustarComponente(3,9,1,1, 0, 0);
		add(signos, constraints);
		
	}

	private void ajustarComponente(int posX, int posY, int ancho, int alto, int estirarX, int estirarY) {
		constraints.gridx = posX;
		constraints.gridy = posY;
		constraints.gridwidth = ancho;
		constraints.gridheight = alto;
		constraints.weightx = estirarX;
		constraints.weighty = estirarY;
		constraints.fill = GridBagConstraints.BOTH;
	}

	public void actualizarResultados(double[] v) {
		resultados.actualizarValores(v);
	}
	
	public void actualizarGolesL(double[] v) {
		golesL.actualizarValores(v);
	}
	
	public void actualizarGolesV(double[] v) {
		golesV.actualizarValores(v);
	}
	
	public void actualizarSignos(double[] v) {
		signos.actualizarValores(v);
	}
	
	/**
	 * @param lNombreEquipoLocal the lNombreEquipoLocal to set
	 */
	public void setlNombreEquipoLocal(String lNombreEquipoLocal) {
		this.lNombreEquipoLocal.setText(lNombreEquipoLocal);
	}


	/**
	 * @param lNombreEquipoVisitante the lNombreEquipoVisitante to set
	 */
	public void setlNombreEquipoVisitante(String lNombreEquipoVisitante) {
		this.lNombreEquipoVisitante.setText(lNombreEquipoVisitante);
	}

}
