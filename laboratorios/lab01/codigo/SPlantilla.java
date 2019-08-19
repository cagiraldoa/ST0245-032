public class SPlantilla
{
    /**
     * Realiza el calculo de las formas en las cuales se pueden ubicar
     * los rectangulos 1x2 en otro 2xn ademas dibuja cada una de ellas
     * @param n es el largo del rectangulo que se debe de utilizar para calcular el numero de formas
     * de ubicar el rectangulo 1x2
     * @return int retorna un entero que representa las formas en las que se puede llenar el rectangulo 2xn
     */
    public static int nRectangulos(int n){
        if(n<=3)
            return n;
        else
            return nRectangulos(n-1)+nRectangulos(n-2);  
    }

    /**
     * Metodo principal, el cual ejecuta el programa e imprime el resulta   do
     * @param args un array de argumentos
     */
    public static void main(String[] args)
    {
        System.out.println("Tiempo Ejercicio \n");
        for(int i = 31; i <51 ; i++){

            long startTime = System.currentTimeMillis();
            nRectangulos(i);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(i + " " + tiempo);
        }
    }

}
