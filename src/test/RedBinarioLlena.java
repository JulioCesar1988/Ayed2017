package test;

import ejercicio1.ArbolBinario;
import src.tp03.ejercicio6.NodoBinario;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class RedBinarioLlena {

	public static int retardoReenvio(ArbolBinario<Integer> a) {
		int sumar = 0;
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		l.comenzar();
		procesar(a, l, sumar);

		System.out.println("tamaño de lista : " + l.tamanio());
		int max = -1;
		l.comenzar();
		while (!(l.fin())) {

			Integer n = l.proximo();
			if (n > max) {
				max = n;
			}
			System.out.println(n);

		}

		return max;
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

				System.out.println("suma vale : " + sumar);
				l.agregarInicio(sumar);
				System.out.println("soy hoja" + a.getDatoRaiz());
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
