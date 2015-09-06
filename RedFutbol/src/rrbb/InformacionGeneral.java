package rrbb;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class InformacionGeneral extends JPanel {
/*
	private JLabel lNombreEquipoLocal;
	private JLabel lNombreEquipoVisitante;
	private JTextField tNombreEquipoLocal;
	private JTextField tNombreEquipoVisitante;
	*/
	private DatoDesplegable competicion;
	private DatoDesplegable faseTemporada;
	private DatoUnico derby;
	private DatoUnico estadioLleno;
	private DatoDesplegable distanciaEntreCiudades;
	private DatoDesplegable medioTransporteEquipoVisitante;
	private DatoUnico arbitro;
	private DatoDesplegable resultadosEntreEllos;
	private DatoDesplegable estacion;
	private DatoUnico lluvia;
	private DatoUnico nieve;
	private DatoUnico viento;
	private DatoUnico otroEfectoMeteorologico;
	
	public InformacionGeneral () {
		setLayout(new GridLayout(15,1));
	
		/*lNombreEquipoLocal = new JLabel("Equipo Local:");
		lNombreEquipoVisitante = new JLabel("Equipo visitante:");
		tNombreEquipoLocal = new JTextField("Local", 20);
		tNombreEquipoVisitante = new JTextField("Visitante", 20);*/
		/*JComponent panelEL = new JPanel();
		JComponent panelEV = new JPanel();
		panelEL.setLayout(new FlowLayout());
		panelEV.setLayout(new FlowLayout());
	//	panelEL.add(lNombreEquipoLocal);
	//	panelEL.add(tNombreEquipoLocal);
		add(panelEL);
	//	panelEV.add(lNombreEquipoVisitante);
	//	panelEV.add(tNombreEquipoVisitante);
		add(panelEV);
		*/
		datosPartido();
		datosMeteorologicos();	
	}
	
	
	/**
	 * @return the lNombreEquipoLocal
	 */
/*	public JLabel getlNombreEquipoLocal() {
		return lNombreEquipoLocal;
	}*/

	/**
	 * @return the lNombreEquipoVisitante
	 */
/*	public JLabel getlNombreEquipoVisitante() {
		return lNombreEquipoVisitante;
	}*/

	/**
	 * @return the tNombreEquipoLocal
	 */
/*	public String gettNombreEquipoLocal() {
		return tNombreEquipoLocal.getText();
	}*/

	/**
	 * @return the tNombreEquipoVisitante
	 */
/*	public String gettNombreEquipoVisitante() {
		return tNombreEquipoVisitante.getText();
	}*/

	/**
	 * @return the competicion
	 */
	public DatoDesplegable getCompeticion() {
		return competicion;
	}

	/**
	 * @return the faseTemporada
	 */
	public DatoDesplegable getFaseTemporada() {
		return faseTemporada;
	}

	/**
	 * @return the derby
	 */
	public DatoUnico getDerby() {
		return derby;
	}

	/**
	 * @return the estadioLleno
	 */
	public DatoUnico getEstadioLleno() {
		return estadioLleno;
	}

	/**
	 * @return the distanciaEntreCiudades
	 */
	public DatoDesplegable getDistanciaEntreCiudades() {
		return distanciaEntreCiudades;
	}

	/**
	 * @return the medioTransporteEquipoVisitante
	 */
	public DatoDesplegable getMedioTransporteEquipoVisitante() {
		return medioTransporteEquipoVisitante;
	}

	/**
	 * @return the arbitro
	 */
	public DatoUnico getArbitro() {
		return arbitro;
	}

	/**
	 * @return the resultadosEntreEllos
	 */
	public DatoDesplegable getResultadosEntreEllos() {
		return resultadosEntreEllos;
	}

	/**
	 * @return the estacion
	 */
	public DatoDesplegable getEstacion() {
		return estacion;
	}

	/**
	 * @return the lluvia
	 */
	public DatoUnico getLluvia() {
		return lluvia;
	}

	/**
	 * @return the nieve
	 */
	public DatoUnico getNieve() {
		return nieve;
	}

	/**
	 * @return the viento
	 */
	public DatoUnico getViento() {
		return viento;
	}

	/**
	 * @return the otroEfectoMeteorologico
	 */
	public DatoUnico getOtroEfectoMeteorologico() {
		return otroEfectoMeteorologico;
	}

	
	
	private void datosPartido() {
		ArrayList<JRadioButton> vs = new ArrayList<JRadioButton>();
		ArrayList<String> vst = new ArrayList<String>();
		
		JLabel etiqueta = new JLabel("Datos sobre el partido:");
		add(etiqueta);
		
		vst.clear();
		vst.add(new String("Otra/No lo sé")); vst.add(new String("Liga")); vst.add(new String("Eliminatoria")); vst.add(new String("Amistoso"));
		competicion = new DatoDesplegable(this, "¿A qué competición pertenece el partido?", vst);
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("Inicio")); vst.add(new String("Mitad")); vst.add(new String("Final"));
		faseTemporada = new DatoDesplegable(this, "Etapa de la temporada:", vst);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		derby = new DatoUnico(this, "¿Se trata de un derby?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		estadioLleno = new DatoUnico(this, "¿Está lleno el estadio?", vs);
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("Corta")); vst.add(new String("Media")); vst.add(new String("Larga"));
		distanciaEntreCiudades = new DatoDesplegable(this, "Distancia entre ciudades de los equipos:", vst);
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("Autobús")); vst.add(new String("Avión")); vst.add(new String("Otro"));
		medioTransporteEquipoVisitante = new DatoDesplegable(this, "Medio de transporte del equipo visitante:", vst);
		vs.clear();
		vs.add(new JRadioButton("Bueno")); vs.add(new JRadioButton("Malo")); vs.add(new JRadioButton("Ni fú ni fá/No lo sé", true));
		arbitro = new DatoUnico(this, "El árbitro se puede considerar:", vs);
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("Victorias locales")); vst.add(new String("Victorias visitantes")); vst.add(new String("Empates"));
		resultadosEntreEllos = new DatoDesplegable(this, "Los partidos entre ambos equipos suelen saldarse con:", vst);
	}
	
	private void datosMeteorologicos() {
		ArrayList<JRadioButton> vs = new ArrayList<JRadioButton>();
		ArrayList<String> vst = new ArrayList<String>();
		JLabel etiqueta = new JLabel("Condiciones meteorológicas:");
		add(etiqueta);
		
		
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("Primavera")); vst.add(new String("Verano")); vst.add(new String("Otoño")); vst.add(new String("Invierno"));
		estacion = new DatoDesplegable(this, "Estación del año:", vst);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		lluvia = new DatoUnico(this, "¿Se espera que llueva durante el partido?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		nieve = new DatoUnico(this, "¿El terreno de juego está nevado o se espera que nieve?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		viento = new DatoUnico(this, "¿Hay mucho viento?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		otroEfectoMeteorologico = new DatoUnico(this, "¿Hay otro fenómeno meteorológico que pueda afectar al partido?", vs);
	}	
}
