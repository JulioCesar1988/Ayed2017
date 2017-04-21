package src.tp03.ejercicio6;


public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

	private NodoBinario<T> raiz;

	
	public ArbolBinarioDeBusqueda(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinarioDeBusqueda(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoDerecho());
	}
	
	private NodoBinario<T> buscar(Comparable<T> x, NodoBinario<T> t) {
		if (t != null) {
			if (x.compareTo(t.getDato()) < 0) {
				t = this.buscar(x, t.getHijoIzquierdo());
			} else if (x.compareTo(t.getDato()) > 0) {
				t = this.buscar(x, t.getHijoDerecho());
			} else
				; // Se encontro el nodo, asi que es t
			return t;
		} else {
			return null;
		}
	}
	
	public boolean incluye(Comparable<T> dato) {
		return buscar(dato, this.raiz) != null;
	}

	public T buscar(T dato){
    	NodoBinario<T> result = this.buscar(dato, this.getRaiz());
    	if (result != null){
    		return result.getDato();
    	}
    	return null;
    }


	public void eliminar(T dato) {
		// Falta implementar. Ejercicio 5a.
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}
	
	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	
	public void imprimirInOrden( )
    {
        if( this.esVacio())
            System.out.println( "Arbol Vacio" );
        else
        	imprimirInOrden(this.raiz);
    }
	
	private void imprimirInOrden( NodoBinario<T> t )
     {
         if( t != null )
         {
        	 imprimirInOrden( t.getHijoIzquierdo() );
             System.out.println( t.getDato());
             imprimirInOrden( t.getHijoDerecho());
         }
     }
	
	public void agregar(T dato) {
		if (raiz == null)
		   raiz = new NodoBinario<T>(dato);
		else
		   this.agregar(dato, raiz);
	}
	
	private void agregar(T dato, NodoBinario<T> r) {
		if (dato.compareTo(r.getDato()) < 0)
		  if (r.getHijoIzquierdo()==null)
		      r.setHijoIzquierdo(new NodoBinario<T>(dato));
		  else
		    this.agregar(dato, r.getHijoIzquierdo());
		else
		  if (dato.compareTo(r.getDato()) > 0)
		    if (r.getHijoDerecho()==null)
		       r.setHijoDerecho(new NodoBinario<T>(dato));
		    else
		      this.agregar(dato, r.getHijoDerecho());
	}	

	


}