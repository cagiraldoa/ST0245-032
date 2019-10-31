
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class Tiempos_Memoria

{
    public static void tiempos(String archivo){

        MarcoDeDatos mr = new MarcoDeDatos();
        LinkedList<Dato> ld;

        ld = mr.leerDatos(archivo);

        Analisis ar = new Analisis();

        System.out.println("Tiempo Lectura y Guardado en la Estructura de Datos del archivo " + archivo + " \n");

        System.out.println("Número de lineas  Tiempo MiliSegundos\n");

        long startTime = System.currentTimeMillis();
        ar.main();
        long tiempo = System.currentTimeMillis() - startTime;
        System.out.println(ld.size() + "               " + tiempo+"\n\n");

    
        int dataSize = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();

        System.out.println ("Memoria máxima: " + runtime.maxMemory() / dataSize + "MB");
        System.out.println ("Memoria total: " + runtime.totalMemory() / dataSize + "MB");
        System.out.println ("Memoria libre: " + runtime.freeMemory() / dataSize + "MB");
        System.out.println ("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");

    }
}