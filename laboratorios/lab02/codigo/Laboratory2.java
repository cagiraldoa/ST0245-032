/**
 * Laboratorio 2 de Estructuras de Datos 1
 * 
 * @author Mauricio Toro 
 * @version 1
 */

import java.util.Arrays;

public class Laboratory2
{

    // Sorts an array using Insertion Sort
    public static void InsertionSort(int[] A)
    {
        int temp,j;
        for (int i = 0; i < A.length; i++)
        {
            j = i;
            while (j > 0 && A[j-1] > A[j])
            {
                temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j = j-1;
            }           
        }
        //    System.out.println(Arrays.toString(A));
    }

    // Sorts an array using Merge Sort
    // Taken from www.cs.cmu.edu/
    public static void mergeSort(int [ ] a)
    {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    
    public static void tiempos(){

        System.out.println("Tiempo Ejercicio Merge\n");
        for(int i = 10000; i <= 200000; i+=10000){

            long startTime = System.currentTimeMillis();
            mergeSort(crearArray(i));
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(crearArray(i).length + " " + tiempo);
        }

        System.out.println("\n\nTiempo Ejercicio Insertion\n");

        for(int i = 10000; i <= 200000; i+=10000){
            long startTime = System.currentTimeMillis();
            InsertionSort(crearArray(i));
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

}