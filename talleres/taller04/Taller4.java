/**
 *La clase Taller4 dos tiene como objetivo dar solución al Taller4
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 */
public class Taller4 {

    public static int sumaArreglo(int[] array){

        return arrayMax(array, array.length);
    }

    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior 
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arrayMax(int[] array, int n) {

        if(n == 0)

            return 0;

        else 

            return array[n-1] + arrayMax(array, n-1);
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma 
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean groupSum(int start, int[] nums, int target) {

        if(start >= nums.length){
            return (target==0);
        }

        return (groupSum(start+1, nums, target - nums[start])) || (groupSum(start+1, nums, target));

    }

    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static int fibonacci(int n) { 

        if (n <= 1) 

            return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args){

        System.out.println("Tiempo Ejercicio 1\n");
        for(int i = 1; i < 20; i++){

            long startTime = System.currentTimeMillis();
            sumaArreglo(crearArray2());
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(crearArray2().length + " " + tiempo);
        }

        System.out.println("\n\nTiempo Ejercicio 2\n");

        for(int i = 1; i < 20; i++){
            int[] numeros = new int[i];
            long startTime = System.currentTimeMillis();
            groupSum(0, crearArray(), (int) (Math.random()*40));
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(crearArray().length + " " + tiempo);
        }

        System.out.println("\n\nTiempo Ejercicio 3\n");
        for(int i = 25; i < 45; i++){

            long startTime = System.currentTimeMillis();
            fibonacci(i);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(i + " " + tiempo);
        }

    }
    
    public static int[] crearArray(){
        int n = (int) (Math.random()*40)+1;
        int[] numeros = new int [n];
        for (int i=0; i<numeros.length; i++){
            numeros[i] = (int) (Math.random()*40);
        }

        return numeros;
    }

    public static int[] crearArray2(){

        int n = (int) (Math.random()*4000)+2000;

        int[] numeros = new int [n];

        for (int i=0; i<numeros.length; i++){

            numeros[i] = (int) (Math.random()*2);
        }

        return numeros;
    }
    
}

