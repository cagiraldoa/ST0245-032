/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return this.size;
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) { 
        if ( size ==  elements.length) {                // O(1)
            // creo arreglo del doble del tamaño
            int[] nuevo = new int[elements.length*2];    // O(1)
            // copio los del arreglo viejo al nuevo
            for (int i = 0; i < elements.length; i++)    // O(n)
                nuevo[i] = elements[i];                    // O(n)
            elements = nuevo;                            // O(1)
        }
        // inserto el elemento al final del arreglo nuevo
        elements[size] = e; // magia O(1)              // O(1)   
        size++;                                        // O(1)
    }      
    // _________
    //  T(n) es O(n)
    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {

        return elements[i];
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {

        int[] nuevo = new int[elements.length]; 
        for(int i =0 ; i<index; i++){
            nuevo[i] = elements[i]; 
        }
        if(index>0){
            for(int i =size ; i>=index; i--){

                nuevo[i] = elements[i-1]; 

            }
        }

        for(int i =size ; i>=1; i--){

                nuevo[i] = elements[i-1]; 

            }
        
        nuevo[index] = e;
        elements = nuevo;
        size++;
    } 

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        int[] nuevo = new int[elements.length]; 

        for(int i =0 ; i<index; i++){

            nuevo[i] = elements[i]; 

        }
        for(int i =size ; i>=index; i--){

            nuevo[i] = elements[i+1]; 

        }

        elements = nuevo;
        size--;
    }
}
