package rrbb;

import java.awt.event.ComponentListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Interfaz extends JTabbedPane {

	InformacionEquipo local;
	InformacionEquipo visitante;
	InformacionGeneral info;
	Resultados resultados;
	
	public Interfaz () {
		local = new InformacionEquipo();
		visitante = new InformacionEquipo();
		info = new InformacionGeneral();
		resultados = new Resultados();
		
		addTab("Información general", info);
		addTab("Equipo Local", local);
		addTab("Equipo Visitante", visitante);
		addTab("Pronóstico", resultados);
	}
	
	public void controlador(ComponentListener l) {
		resultados.addComponentListener(l);
	}

	/**
	 * @return the local
	 */
	public InformacionEquipo getLocal() {
		return local;
	}

	/**
	 * @return the visitante
	 */
	public InformacionEquipo getVisitante() {
		return visitante;
	}

	/**
	 * @return the info
	 */
	public InformacionGeneral getInfo() {
		return info;
	}

	/**
	 * @return the resultados
	 */
	public Resultados getResultados() {
		return resultados;
	}
	
	
	
	
}
