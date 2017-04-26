package arbolGeneral;

import ColaGenerica.ColaGenerica;
import listasGenericas.ListaEnlazadaGenerica;
import listasGenericas.ListaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);
		
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());
			
		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}


	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	
	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));
			
		}

		return lista;
	}

	
	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	
	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);
				
			}
		}	

		
	}
	
    
    
	public Integer altura() {	 
		//Falta implementar..
		
		
		
	   return 0;
	}

	
	public Integer nivel( T dato){
		//falta implementar
	   return -1;
	}


	public Integer ancho(){
	   //Falta implementar..
	   return 0;
	}

	public Boolean esHoja(){
		//Falta implementar..
		return false;
	}
	
	public Boolean esVacio(){
		//Falta implementar..
		return false;
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		// Método que retorna una lista con los elementos del Árbol receptor, en
		// orden de recorrido por
		// niveles de arriba hacia abajo y de izquierda a derecha, incluyendo
		// algún elemento que indique el
		// fin de cada nivel
		// código
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		preOrden(lis);
		return lis;

	}

	private void preOrden(ListaGenerica<T> l) {
		l.agregarFinal(this.getDatoRaiz());
		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
		lHijos.comenzar();
		while (!lHijos.fin()) {
			lHijos.proximo().preOrden(l);
		}
	}

}
