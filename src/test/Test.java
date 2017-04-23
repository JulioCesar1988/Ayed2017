package test;

import ejercicio1.ArbolBinario;
import src.tp03.ejercicio6.ArbolBinarioDeBusqueda;

public class Test {

	public static int cantidadPar(ArbolBinarioDeBusqueda<Integer> a) {
		int cant = 0;
		if (!a.esVacio()) {
			if (a.getDatoRaiz() % 2 == 0) {
				cant++;
				if (!a.getHijoDerecho().esVacio()) {
					cant = cant + cantidadPar(a.getHijoDerecho());
				}
				if (!a.getHijoIzquierdo().esVacio()) {
					cant = cant + cantidadPar(a.getHijoIzquierdo());
				}
			}

		}

		return cant;
	}

	public static int contarHojas(ArbolBinarioDeBusqueda<Integer> a) {
		int cant = 0;
		if (a != null) {

			if (!a.esVacio()) {
				if (a.esHoja()) {
					cant++;

				} else {
					if (!a.getHijoDerecho().esVacio()) {
						cant = cant + contarHojas(a.getHijoDerecho());
					}
					if (!a.getHijoIzquierdo().esVacio()) {
						cant = cant + contarHojas(a.getHijoIzquierdo());
					}

				}

				return cant;
			}

		}

		return cant;
	}

	public static ArbolBinario<Integer> espejo(ArbolBinario<Integer> a) {

		if (a != null) {

			if (!a.esVacio()) {

				if (!a.getHijoIzquierdo().esVacio()) {

					a.agregarHijoIzquierdo(a.getHijoDerecho());
					espejo(a.getHijoIzquierdo());

				}
				if (!a.getHijoDerecho().esVacio()) {
					// a.eliminarHijoDerecho();
					a.agregarHijoDerecho(a.getHijoIzquierdo());

					espejo(a.getHijoDerecho());
				}

			}

		}

		return a;
	}

	public static void recorrido(ArbolBinario<Integer> a) {
		if (a != null) {
			if (!a.esVacio()) {
				System.out.println(a.getDatoRaiz());
				if (!a.getHijoIzquierdo().esVacio()) {
					System.out.println("soy hijo Izquierdo : " + a.getHijoIzquierdo().getDatoRaiz());
					recorrido(a.getHijoIzquierdo());
				}
				if (!a.getHijoDerecho().esVacio()) {
					System.out.println("soy hijo derecho : " + a.getHijoDerecho().getDatoRaiz());

					recorrido(a.getHijoDerecho());
				}

			}

		}
	}

	public static void main(String[] args) {

		// CREARO EL ARBOL
		ArbolBinarioDeBusqueda<Integer> b = new ArbolBinarioDeBusqueda<Integer>(20);

		// LE MANDO
		b.agregar(6);
		b.agregar(5);
		b.agregar(8);
		b.agregar(3);
		b.agregar(9);

		// b.imprimirInOrden();
		// System.out.println("cantidad de pares : " + cantidadPar(b));

		// System.out.println("cantidad de hojas : " + contarHojas(b));

		// Sub Arboles con hijos
		ArbolBinario<Integer> arbolbinario1 = new ArbolBinario<Integer>(2);
		arbolbinario1.agregarHijoDerecho(new ArbolBinario<Integer>(5));
		arbolbinario1.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));

		// Sub Arboles con hijos
		ArbolBinario<Integer> arbolbinario2 = new ArbolBinario<Integer>(3);
		// arbolbinario2.agregarHijoDerecho(new ArbolBinario<Integer>(80));
		arbolbinario2.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));

		// Raiz y le engacho los hijos
		ArbolBinario<Integer> arbolbinario0 = new ArbolBinario<Integer>(1);
		arbolbinario0.agregarHijoDerecho(arbolbinario2);
		arbolbinario0.agregarHijoIzquierdo(arbolbinario1);

		recorrido(arbolbinario0);
		ArbolBinario<Integer> espejo = espejo(arbolbinario0);
		System.out.println("###########");
		recorrido(espejo);

	}

}
