package rrbb;

import smile.Network;
import smile.SMILEException;


public class RedBayesiana {

	private Network red;		// Red bayesiana.
	
	
	/**
	 * Constructor.
	 * Crear la red e inicializa probabilidades.
	 * 
	 * @param nombre Ruta del fichero que contiene la red bayesiana.
	 */
	public RedBayesiana (String nombre) {
		this.red = new Network();
		this.red.readFile(nombre);
		actualizarRed();
	}
	
	/**
	 * @return La red.
	 */
	public Network getRed() {
		return red;
	}

	/**
	 * Añade una evidencia.
	 * 
	 * @param nodo	Identificador del nodo a instanciar.
	 * @param valor	Identificador del valor del nodo que se instancia.
	 */
	public void anyadirEvidencia (String nodo, String valor) {
		try {
			getRed().setEvidence(nodo, valor);
		} catch (SMILEException e) {
			// Imposible instanciar el nodo.
		}
		actualizarRed();
	}
	
	/**
	 * Elimina una evidencia.
	 * 
	 * @param nodo Identificador del nodo.
	 */
	public void eliminarEvidencia (String nodo) {
		getRed().clearEvidence(nodo);
		actualizarRed();
	}
	
	/**
	 * Elimina todas las evidencias de la red.
	 */
	public void eliminarEvidencias () {
		getRed().clearAllEvidence();
		actualizarRed();
	}
	
	/**
	 * Actualiza las probabilidades de la red.
	 */
	public void actualizarRed() {
		getRed().updateBeliefs();
	}
	/**
	 * Muestra las probabilidades de un nodo.
	 * 
	 * @param nodo Identificador del nodo.
	 */
	public void mostrarNodo (String nodo) {
		String[] idsValoresNodo = getRed().getOutcomeIds(nodo); // Identificadores de los valores del nodo.
		double[] valores;										// Probabilidades del nodo.
		System.out.println(nodo + ": ");
		valores = getRed().getNodeValue(nodo);
		for (int i = 0; i < idsValoresNodo.length; i++) {
			System.out.println("P(\"" + nodo + "\" = " + idsValoresNodo[i] + ") = " + valores[i]);
		}
	}
	
	/**
	 * Devuelve las probabilidades de un nodo dado.
	 * 
	 * @param nodo	Nodo.
	 * @return	Probabilidades del nodo.
	 */
	public double[] valoresNodo(String nodo) {
		double[] valores = getRed().getNodeValue(nodo);
		double[] res = new double[valores.length];
		for (int i = 0; i < valores.length; i++) {
			res[i] = redondear(valores[i]*100);
		}
		return res;
	}
		
	private double redondear(double d) {
		return (Math.rint(d*100)/100);		// Redondea a dos decimales.
	}
	
}
