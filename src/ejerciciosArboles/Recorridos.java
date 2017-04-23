package ejerciciosArboles;

import ColaGenerica.ColaGenerica;
import ejercicio1.ArbolBinario;

public class Recorridos {

	/***
	 * 
	 * Preorden Se procesa primero la raíz y luego sus hijos, izquierdo y
	 * derecho.
	 */
	public static void preOrden(ArbolBinario<Integer> arbol) {
		if (arbol != null) {
			System.out.println(arbol.getDatoRaiz());
			if (!arbol.getHijoIzquierdo().esVacio()) {
				preOrden(arbol.getHijoIzquierdo());
			}
			if (!arbol.getHijoDerecho().esVacio()) {
				preOrden(arbol.getHijoDerecho());
			}

		}

	}

	/***
	 * Inorden Se procesa el hijo izquierdo, luego la raíz y último el hijo
	 * derecho
	 */
	public static void InOrden(ArbolBinario<Integer> arbol) {
		if (arbol != null) {
			if (!arbol.getHijoIzquierdo().esVacio()) {
				InOrden(arbol.getHijoIzquierdo());
			}
			System.out.println(arbol.getDatoRaiz());
			if (!arbol.getHijoDerecho().esVacio()) {
				InOrden(arbol.getHijoDerecho());
			}

		}

	}

	/***
	 * Postorden Se procesan primero los hijos, izquierdo y derecho, y luego la
	 * raíz
	 * 
	 ***/
	public static void postOrden(ArbolBinario<Integer> arbol) {
		if (arbol != null) {
			if (!arbol.getHijoIzquierdo().esVacio()) {
				postOrden(arbol.getHijoIzquierdo());
			}
			if (!arbol.getHijoDerecho().esVacio()) {
				postOrden(arbol.getHijoDerecho());
			}
			System.out.println(arbol.getDatoRaiz());
		}

	}

	/***
	 * Por niveles Se procesan los nodos teniendo en cuenta sus niveles, primero
	 * la raíz, luego los hijos, los hijos de éstos, etc.
	 ***/
	public static void porNiveles(ArbolBinario<Integer> arbol) {
		ColaGenerica<ArbolBinario<Integer>> q = new ColaGenerica<ArbolBinario<Integer>>();
		q.encolar(arbol);
		q.encolar(null);
		while (!q.esVacia()) {
			ArbolBinario<Integer> elemento = q.desencolar();
			if (elemento != null) {
				System.out.println(elemento.getDatoRaiz());
				if (!elemento.getHijoIzquierdo().esVacio()) {
					q.encolar(elemento.getHijoIzquierdo());
				}
				if (!elemento.getHijoDerecho().esVacio()) {
					q.encolar(elemento.getHijoDerecho());
				}
			} else {
				if (elemento == null && !q.esVacia()) {
					System.out.println("######");
					q.encolar(null);
				}

			}

		}
		System.out.println("fin del recorrido.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArbolBinario<Integer> arbolBinario1 = new ArbolBinario<Integer>(50);
		arbolBinario1.agregarHijoDerecho(new ArbolBinario<Integer>(30));
		arbolBinario1.agregarHijoIzquierdo(new ArbolBinario<Integer>(20));

		ArbolBinario<Integer> arbolBinario2 = new ArbolBinario<Integer>(60);
		arbolBinario2.agregarHijoDerecho(new ArbolBinario<Integer>(90));
		arbolBinario2.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));

		ArbolBinario<Integer> arbolBinario0 = new ArbolBinario<Integer>(100);
		arbolBinario0.agregarHijoDerecho(arbolBinario1);
		arbolBinario0.agregarHijoIzquierdo(arbolBinario2);
		// preOrden(arbolBinario);
		// InOrden(arbolBinario);
		porNiveles(arbolBinario0);

	}

}
