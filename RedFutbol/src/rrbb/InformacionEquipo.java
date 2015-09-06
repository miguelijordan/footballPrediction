package rrbb;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class InformacionEquipo extends JPanel {

	private DatoNumerico presupuesto;
	private DatoNumerico nJugadoresPlantilla;
	private DatoNumerico nJugadoresEstrella;
	private DatoDesplegable tactica;
	private DatoUnico entrenador;
	private DatoNumerico nJugadoresLesionados;
	private DatoNumerico nJugadoresSancionados;
	private DatoUnico partidoEntreSemana;
	private DatoUnico motivado;
	private DatoUnico seJuegaAlgo;
	private DatoUnico estaEnRacha;
	private DatoUnico seLeDaBienElEquipoContrario;
	private DatoNumerico nTitulos;
	private DatoUnico resultadosHistoricos;
	private DatoNumerico golesPorPartido;
	private DatoNumerico golesAFavor;
	private DatoUnico resultadosTemporada;
	private DatoUnico faltasCometidas;
	private DatoUnico faltasRecibidas;
	private DatoDesplegable clasificacion;
	
	public InformacionEquipo () {
		setLayout(new GridLayout(22,1));
		
		datosGenerales();
		datosConcretos();
		datosHistoricos();
	}
	
	/**
	 * @return the presupuesto
	 */
	public DatoNumerico getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @return the nJugadoresPlantilla
	 */
	public DatoNumerico getnJugadoresPlantilla() {
		return nJugadoresPlantilla;
	}

	/**
	 * @return the nJugadoresEstrella
	 */
	public DatoNumerico getnJugadoresEstrella() {
		return nJugadoresEstrella;
	}

	/**
	 * @return the tactica
	 */
	public DatoDesplegable getTactica() {
		return tactica;
	}

	/**
	 * @return the entrenador
	 */
	public DatoUnico getEntrenador() {
		return entrenador;
	}

	/**
	 * @return the nJugadoresLesionados
	 */
	public DatoNumerico getnJugadoresLesionados() {
		return nJugadoresLesionados;
	}

	/**
	 * @return the nJugadoresSancionados
	 */
	public DatoNumerico getnJugadoresSancionados() {
		return nJugadoresSancionados;
	}

	/**
	 * @return the partidoEntreSemana
	 */
	public DatoUnico getPartidoEntreSemana() {
		return partidoEntreSemana;
	}

	/**
	 * @return the motivado
	 */
	public DatoUnico getMotivado() {
		return motivado;
	}

	/**
	 * @return the seJuegaAlgo
	 */
	public DatoUnico getSeJuegaAlgo() {
		return seJuegaAlgo;
	}

	/**
	 * @return the estaEnRacha
	 */
	public DatoUnico getEstaEnRacha() {
		return estaEnRacha;
	}

	/**
	 * @return the seLeDaBienElEquipoContrario
	 */
	public DatoUnico getSeLeDaBienElEquipoContrario() {
		return seLeDaBienElEquipoContrario;
	}

	/**
	 * @return the nTitulos
	 */
	public DatoNumerico getnTitulos() {
		return nTitulos;
	}

	/**
	 * @return the resultadosHistoricos
	 */
	public DatoUnico getResultadosHistoricos() {
		return resultadosHistoricos;
	}

	/**
	 * @return the golesPorPartido
	 */
	public DatoNumerico getGolesPorPartido() {
		return golesPorPartido;
	}

	/**
	 * @return the golesAFavor
	 */
	public DatoNumerico getGolesAFavor() {
		return golesAFavor;
	}
	
	
	private void datosHistoricos() {
		ArrayList<JRadioButton> vs = new ArrayList<JRadioButton>();
		JLabel etiqueta = new JLabel("Datos históricos");
		add(etiqueta);
		
		nTitulos = new DatoNumerico(this, "Nº de títulos:");
		vs.add(new JRadioButton("Victorias")); vs.add(new JRadioButton("Empates")); vs.add(new JRadioButton("Derrotas")); vs.add(new JRadioButton("No lo sé", true));
		resultadosHistoricos = new DatoUnico(this, "Históricamente los resultados son:", vs);
		golesPorPartido = new DatoNumerico(this, "Goles por partido:");
	}
	
	private void datosGenerales() {
		ArrayList<JRadioButton> vs = new ArrayList<JRadioButton>();
		ArrayList<String> vst = new ArrayList<String>();
		JLabel etiqueta = new JLabel("Sobre el equipo:");
		add(etiqueta);
		
		presupuesto = new DatoNumerico(this, "Presupuesto (millones de €):");
		nJugadoresPlantilla = new DatoNumerico(this, "Nº de jugadores de la plantilla:");
		nJugadoresEstrella = new DatoNumerico(this, "Nº de jugadores estrella (galácticos):");
		vs.clear();
		vs.add(new JRadioButton("Bueno")); vs.add(new JRadioButton("Malo")); vs.add(new JRadioButton("No sé", true));
		entrenador = new DatoUnico(this, "¿Cómo es el entrenador del equipo?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		partidoEntreSemana = new DatoUnico(this, "¿Ha jugado partido entre semana?", vs);
		vs.clear();
		vs.add(new JRadioButton("Victorias")); vs.add(new JRadioButton("Empates")); vs.add(new JRadioButton("Derrotas")); vs.add(new JRadioButton("No lo sé", true));
		resultadosTemporada = new DatoUnico(this, "Esta temporada los resultados han sido mayoritariamente...", vs);
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("Champions")); vst.add(new String("Uefa")); vst.add(new String("Zona media")); vst.add(new String("Descenso")); 
		clasificacion = new DatoDesplegable(this, "El equipo está en puestos de:", vst);
		
	}
	
	private void datosConcretos() {
		ArrayList<JRadioButton> vs = new ArrayList<JRadioButton>();	
		ArrayList<String> vst = new ArrayList<String>();
		/*JLabel etiqueta = new JLabel("Sobre el partido:");
		add(etiqueta);*/
		
		vst.clear();
		vst.add(new String("No lo sé")); vst.add(new String("4-4-2")); vst.add(new String("4-3-3")); vst.add(new String("4-2-3-1")); vst.add(new String("Otra")); 
		tactica = new DatoDesplegable(this, "Sistema/Táctica:", vst);
		nJugadoresLesionados = new DatoNumerico(this, "Nº de jugadores lesionados:");
		nJugadoresSancionados = new DatoNumerico(this, "Nº de jugadores sancionados:");
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		motivado = new DatoUnico(this, "¿El equipo está especialmente motivado para este partido?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		seJuegaAlgo = new DatoUnico(this, "¿Se juega algo el equipo?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		estaEnRacha = new DatoUnico(this, "¿Está en racha?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		seLeDaBienElEquipoContrario = new DatoUnico(this, "¿Se le da bien el equipo contrario?", vs);
		golesAFavor = new DatoNumerico(this, "¿Cuántos goles le suele marcar al equipo contrario?");
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		faltasCometidas = new DatoUnico(this, "¿Suele cometer muchas faltas?", vs);
		vs.clear();
		vs.add(new JRadioButton("Sí")); vs.add(new JRadioButton("No")); vs.add(new JRadioButton("No lo sé", true));
		faltasRecibidas = new DatoUnico(this, "¿Suele recibir muchas faltas?", vs);
		
	}

	/**
	 * @return the faltasCometidas
	 */
	public DatoUnico getFaltasCometidas() {
		return faltasCometidas;
	}

	/**
	 * @return the faltasRecibidas
	 */
	public DatoUnico getFaltasRecibidas() {
		return faltasRecibidas;
	}

	/**
	 * @return the clasificacion
	 */
	public DatoDesplegable getClasificacion() {
		return clasificacion;
	}

	/**
	 * @return the resultadosTemporada
	 */
	public DatoUnico getResultadosTemporada() {
		return resultadosTemporada;
	}
	
}
