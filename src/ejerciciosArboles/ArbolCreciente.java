package ejerciciosArboles;

import ColaGenerica.ColaGenerica;
import ejercicio1.ArbolBinario;

public class ArbolCreciente {
	/*****
	 * Implemente en la clase Arbol Binario el método esArbolCreciente() :
	 * boolean que devuelve true si el árbol es creciente, falso sino lo es. Un
	 * árbol binario es creciente si para cada nivel del arbol la cantidad de
	 * nodos que hay en ese nivel es igual al valor del nivel +1. Realice un
	 * recorrido por niveles.
	 * 
	 * 
	 */

	public static boolean esArbolCreciente(ArbolBinario<Integer> a) {
		ColaGenerica<ArbolBinario<Integer>> q = new ColaGenerica<ArbolBinario<Integer>>();
		boolean cumple = false;
		int cantidadNodo = 0;
		int nivel = 0;
		q.encolar(a);
		q.encolar(null);
		while (!q.esVacia() && !cumple) {
			ArbolBinario<Integer> e = q.desencolar();
			if (e != null) {
				cantidadNodo++;
				if (!e.getHijoIzquierdo().esVacio()) {
					q.encolar(e.getHijoIzquierdo());
				}
				if (!e.getHijoDerecho().esVacio()) {
					q.encolar(e.getHijoDerecho());
				}
			} else {
				if (e == null && !q.esVacia()) {
					q.encolar(null);
					nivel++;
					int aux = nivel + 1;
					if (cantidadNodo == aux) {
						cumple = false;
					}
					cantidadNodo = 0;
				}
				// Evaluando el ultimo nivel .
				int aux = nivel + 1;
				if (q.esVacia() && e == null) {
					cumple = (cantidadNodo == aux);
				}
			}
		}
		return cumple;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(50);
		a.agregarHijoDerecho(new ArbolBinario<Integer>(20));
		a.agregarHijoIzquierdo(new ArbolBinario<Integer>(80));
		if (esArbolCreciente(a)) {
			System.out.println("Es Creciente ");
		} else {

			System.out.println("NO  es Creciente ");
		}

	}

}
