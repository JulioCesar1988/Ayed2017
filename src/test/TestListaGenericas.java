package test;

import ColaGenerica.ColaGenerica;


public class TestListaGenericas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColaGenerica<Integer> q = new ColaGenerica<Integer>();
        
		q.encolar(45);
		q.encolar(50);

		if (q.esVacia()) {
			System.out.println("Esta vacia");
			

		} else {

			System.out.println("NO esta vacia");
			while (!q.esVacia()) {

				Integer n = q.desencolar();
				System.out.println("Elemento :" + n);
			}
		}

	}

}
