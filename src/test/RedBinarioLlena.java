package test;/*******************

*
*Una red binaria es una red que posee una topolog�a de �rbol binario lleno. Por ejemplo:
Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cu�l es su retardo de reenv�o. El retardo de reenv�o se define como el per�odo comprendido entre
que un nodo recibe un mensaje y lo reenv�a a sus dos hijos.
Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la ra�z
hasta llegar a las hojas en una red binaria llena.
c) Indique qu� estrategia (recorrido en profundidad o por niveles) utilizar� para resolver el
problema.
d) Cree una clase Java llamada RedBinariaLlena donde implementar� lo solicitado en el m�todo
retardoReenvio():int
Defina la clase dentro del paquete tp03.ejercicio4 

*/

import ejercicio1.ArbolBinario;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class RedBinarioLlena {

	public static int retardoReenvio(ArbolBinario<Integer> a) {
		int retardo = 0;
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		lista.comenzar();
		procesar(a, lista, retardo);
		int MaxRetardo = -1;
		lista.comenzar();
		while (!(lista.fin())) {

			Integer n = lista.proximo();
			if (n > MaxRetardo) {
				MaxRetardo = n;
			}

		}

		return MaxRetardo;
	}

	public static void procesar(ArbolBinario<Integer> a, ListaDeEnterosEnlazada l, int sumar) {

		if (a.getDatoRaiz() != null) {

			sumar = sumar + a.getDatoRaiz();

			if (!a.getHijoDerecho().esVacio()) {

				procesar(a.getHijoDerecho(), l, sumar);
			}

			if (!a.getHijoIzquierdo().esVacio()) {

				procesar(a.getHijoIzquierdo(), l, sumar);
			}

			if (a.esHoja()) {
				l.agregarInicio(sumar);
			}

		}

	}

	public static void main(String[] args) {

		ArbolBinario<Integer> b1 = new ArbolBinario<Integer>(10);
		b1.agregarHijoDerecho(new ArbolBinario<Integer>(10));
		b1.agregarHijoIzquierdo(new ArbolBinario<Integer>(80));

		ArbolBinario<Integer> b2 = new ArbolBinario<Integer>(3);
		b2.agregarHijoDerecho(new ArbolBinario<Integer>(2));
		b2.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(10);
		a.agregarHijoDerecho(b1);
		a.agregarHijoIzquierdo(b2);
		System.out.println("resultado :" + retardoReenvio(a));

	}

}
