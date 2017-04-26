import arbolGeneral.ArbolGeneral;
import listasGenericas.ListaEnlazadaGenerica;
import listasGenericas.ListaGenerica;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
		ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
		ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
		ListaGenerica<ArbolGeneral<String>> hijos=
		new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos.agregarFinal(a1); 
		hijos.agregarFinal(a2);
		hijos.agregarFinal(a3);
		ArbolGeneral<String> a = new ArbolGeneral<String>("0", hijos);
		System.out.println("Datos del Arbol: "+a.preOrden());
	}

}
