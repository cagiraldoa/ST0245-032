public class Taller5 {  

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma (int[]array){

        int a= 0;

        for(int i = 0; i < array.length; i++){

            a+= array[i];
        }

        return a;
    }

    /**
     * @param num es el numero el cual se utiliza para ser multiplicado.
     * El método mul tiene la intención de hacer la multiplicación
     * de 1 a n por el numero mul
     * mediante una funcion cíclica (while/for/...)
     * 
     */
    public static int mul (int num){

        int a =0;
        for(int i=1;i<=num;i++){

            for(int j = 1; j <=num; j++){
                a = i*j;
            }
        }

        return a;
    }

    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     * 
     */
    public static int[] insertionSort (int[] array){

        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;

                }
            }
        }
        return array;
    }   

    public static void main(String[] args){
        
        System.out.println("Tiempo Ejercicio 1\n");
        for(int i = 10000; i < 200000; i+=10000){

        long startTime = System.currentTimeMillis();
        suma(crearArray(i));
        long tiempo = System.currentTimeMillis() - startTime;
        System.out.println(crearArray(i).length + " " + tiempo);
        }

        System.out.println("\n\nTiempo Ejercicio 2\n");

        for(int i = 10000; i < 200000; i+=10000){
        int[] numeros = new int[i];
        long startTime = System.currentTimeMillis();
        mul(i);
        long tiempo = System.currentTimeMillis() - startTime;
        System.out.println(i + " " + tiempo);
        }
         
        System.out.println("\n\nTiempo Ejercicio 3\n");
        for(int i = 10000; i < 200000; i+=10000){

            long startTime = System.currentTimeMillis();
            insertionSort(crearArray(i));
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(crearArray(i).length + " " + tiempo);
        }

    }

    public static int[] crearArray(int n){
        //int n = (int) (Math.random()*30000)+1000;

        int[] numeros = new int [n];

        for (int i=0; i<numeros.length; i++){
            for(int j = numeros.length; j>=0; j--){
                numeros[i] = j;
            }
        }

        return numeros;
    }

    public static int[] crearArray2(){

        int n = (int) (Math.random()*30000000)+100000;

        int[] numeros = new int [n];

        for (int i=0; i<numeros.length; i++){

            numeros[i] = 100000000;
        }

        return numeros;
    }

}
