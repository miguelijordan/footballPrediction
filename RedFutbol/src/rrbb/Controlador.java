package rrbb;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;



public class Controlador implements ComponentListener {

	private Interfaz vista;
	private RedBayesiana red;
	
	public Controlador (Interfaz v, RedBayesiana r) {
		vista = v;
		red = r;
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		String valor;
		InformacionGeneral info = vista.getInfo();
		InformacionEquipo local = vista.getLocal();
		InformacionEquipo visitante = vista.getVisitante();
		
		instanciarNodo("competicion", info.getCompeticion().getValor());
		instanciarNodo("faseTemporada", info.getFaseTemporada().getValor());
		instanciarNodo("derby", info.getDerby().getValor());
		instanciarNodo("estadioLleno", info.getEstadioLleno().getValor());
		instanciarNodo("distanciaEntreCiudades", info.getDistanciaEntreCiudades().getValor());
		
		valor = info.getMedioTransporteEquipoVisitante().getValor();
		if (valor != null) {
			if (valor.equals("Avión")) valor = "Avion";
			else if (valor.equals("Autobús")) valor = "Autobus";
		}
		instanciarNodo("medioTransporteEquipoVisitante", valor);
		instanciarNodo("arbitro", info.getArbitro().getValor());
		
		valor = info.getResultadosEntreEllos().getValor(); 
		if (valor != null) {
			if (valor.equals("Victorias locales")) {
				valor = "Victorias";
			} else if (valor.equals("Victorias visitantes")) {
				valor = "Derrotas";
			} else {
				valor = "Empates";
			}
		}
		instanciarNodo("resultadosEntreEllos", valor);
		
		valor = info.getEstacion().getValor();
		if (valor != null && valor.equals("Otoño")) {
			valor = "Otonio";
		}
		instanciarNodo("estacion", valor);
		instanciarNodo("lluvia", info.getLluvia().getValor());
		instanciarNodo("nieve", info.getNieve().getValor());
		instanciarNodo("viento", info.getViento().getValor());
		instanciarNodo("otroEfectoMeteorologico", info.getOtroEfectoMeteorologico().getValor());
		
		instanciarNodosEquipo(local, "L");
		instanciarNodosEquipo(visitante, "V");
		
		// Actualia la red.
		red.actualizarRed();
		
	//	String nLocal = info.gettNombreEquipoLocal();
	//	String nVisitante = info.gettNombreEquipoVisitante();
		mostrarResultados("Local", "Visitante");
	}
	
	private void mostrarResultados(String l, String v) {
		Resultados res = vista.getResultados();
		
		// Nombre de los equipos
		res.setlNombreEquipoLocal(l);
		res.setlNombreEquipoVisitante(v);
		
		// Goles de los equipos
		res.actualizarResultados(red.valoresNodo("resultadoPartido"));
		res.actualizarSignos(red.valoresNodo("signo"));
		res.actualizarGolesL(red.valoresNodo("golesLocal"));
		res.actualizarGolesV(red.valoresNodo("golesVisitante"));
	}
	
	private void instanciarNodosEquipo(InformacionEquipo e, String ne) {
		String valor = null;
		Integer v;
		
		v = e.getPresupuesto().getValor();	
		if (v != null) {
			if (v < 30) valor = "bajo";
			else if (v < 60) valor = "medio";
			else valor = "alto";
		} else valor = null;
		instanciarNodo("presupuesto" + ne, valor);
		
		v = e.getnJugadoresPlantilla().getValor();	
		if (v != null) {
			if (v < 20) valor = "menosDe20";
			else if (v < 25) valor = "entre20y25";
			else if (v <= 30) valor = "entre25y30";
			else valor = "masDe30";
		} else valor = null;
		instanciarNodo("jugadoresPlantilla" + ne, valor);
		
		v = e.getnJugadoresEstrella().getValor();	
		if (v != null) {
			if (v == 0) valor = "ninguno";
			else if (v <= 3) valor = "entre1y3";
			else valor = "mas3";
		} else valor = null;
		instanciarNodo("jugadoresEstrella" + ne, valor);

		valor = e.getTactica().getValor();
		if (valor != null) {
			if (valor.equals("4-4-2")) valor = "s4_4_2";
			else if (valor.equals("4-3-3")) valor = "s4_3_3";
			else if (valor.equals("4-2-3-1")) valor = "s4_2_3_1";
			else valor = "otra";
		}
		instanciarNodo("tactica" + ne, valor);
		instanciarNodo("entrenador" + ne, e.getEntrenador().getValor());

		v = e.getnJugadoresLesionados().getValor();	
		if (v != null) {
			if (v <= 2) valor = "entre0y2";
			else if (v <= 5) valor = "entre3y5";
			else valor = "mas5";
		} else valor = null;
		instanciarNodo("lesionados" + ne, valor);
		
		v = e.getnJugadoresSancionados().getValor();	
		if (v != null) {
			if (v <= 1) valor = "entre0y1";
			else if (v <= 3) valor = "entre2y3";
			else valor = "mas3";
		} else valor = null;
		instanciarNodo("sancionados" + ne, valor);
		
		instanciarNodo("partidoEntreSemana" + ne, e.getPartidoEntreSemana().getValor());
		instanciarNodo("motivado" + ne, e.getMotivado().getValor());
		instanciarNodo("seJuegaAlgo" + ne, e.getSeJuegaAlgo().getValor());
		instanciarNodo("estaEnRacha" + ne, e.getEstaEnRacha().getValor());
		instanciarNodo("seLeDaBienElEquipoContrario" + ne, e.getSeLeDaBienElEquipoContrario().getValor());
		
		v = e.getnTitulos().getValor();	
		if (v != null) {
			if (v == 0) valor = "ninguno";
			else if (v <= 4) valor = "entre1y4";
			else if (v <= 10) valor = "entre1y10";
			else valor = "masDe10";
		} else valor = null;
		instanciarNodo("titulos" + ne, valor);
		
		instanciarNodo("resultadosHistoricos" + ne, e.getResultadosHistoricos().getValor());
		
		v = e.getGolesPorPartido().getValor();	
		if (v != null) {
			if (v <= 5) valor = "g" + v;
			else valor = "mas5";
		} else valor = null;
		instanciarNodo("golesPorPartido" + ne, valor);
		
		v = e.getGolesAFavor().getValor();
		if (v != null) {
			if (v <= 3) valor = "g" + v;
			else valor = "masDe3";
		} else valor = null;
		instanciarNodo("golesAFavor" + ne, valor);
		
		instanciarNodo("resultadosTemporada" + ne, e.getResultadosTemporada().getValor());
		
		valor = e.getClasificacion().getValor();
		if (valor != null && valor.equals("Zona media")) {
			valor = "ZonaMedia";
		} 
		instanciarNodo("clasificacion" + ne, valor);
		
		instanciarNodo("faltasCometidas" + ne, e.getFaltasCometidas().getValor());
		instanciarNodo("faltasRecibidas" + ne, e.getFaltasRecibidas().getValor());
	}
	
	private void instanciarNodo (String nodo, String valor) {
		if (valor != null) {
			if (valor.equals("Sí")) valor = "si";
			else if (valor.equals("No")) valor = "no";
			red.anyadirEvidencia(nodo, valor);
		}
	}



}
