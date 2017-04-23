package ejerciciosArboles;

import ColaGenerica.ColaGenerica;
import ejercicio1.ArbolBinario;

/*******
 * Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como
 * variable de instancia un árbol binario de números enteros y un método de
 * instancia sumaElementosProfundidad(int p):int el cuál devuelve la suma de
 * todos los nodos del árbol que se encuentren a la profundidad pasada como
 * argumento.
 * 
 * 
 * 
 */
public class ProfundidadDeArbolBinario {

	public static int sumaDeElementosProfundidad(ArbolBinario<Integer> a, int p) {
		ColaGenerica<ArbolBinario<Integer>> q = new ColaGenerica<ArbolBinario<Integer>>();
		int suma = 0;
		int max = -999;
		int nivel = 0;
		if (a != null) {
			q.encolar(a);
			q.encolar(null);
			while (!q.esVacia() && nivel <= p) {
				ArbolBinario<Integer> elemento = q.desencolar();
				if (elemento != null) {
					suma = suma + elemento.getDatoRaiz();
					if (!elemento.getHijoIzquierdo().esVacio()) {
						q.encolar(elemento.getHijoIzquierdo());
					}
					if (!elemento.getHijoDerecho().esVacio()) {
						q.encolar(elemento.getHijoDerecho());
					}
				} else {
					if (elemento == null && !q.esVacia()) {
						nivel++;
						q.encolar(null);
						if (suma > max && nivel == p) {
							max = suma;
							suma = 0;
						}
					}
				}
			}
		}
		return suma;
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

		int p = 2;
		System.out.println(sumaDeElementosProfundidad(arbolBinario0, p));
	}

}
