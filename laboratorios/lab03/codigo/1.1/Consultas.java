import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Esta clase permite realizar
 * estadisticas a cada tipo de dato
 */ 
public class Consultas extends Usuario {

    /**
     * Este metodo permite realizar la estadistica promedio
     */
    public void c1(){
        LinkedList<Dato> ld;
        LinkedList<Dato> ld2;
        LinkedList<Dato> ld3;

        MarcoDeDatos ldd = new MarcoDeDatos();
        MarcoDeDatos ldd2 = new MarcoDeDatos();
        MarcoDeDatos ldd3 = new MarcoDeDatos();
        Scanner sc = new Scanner(System.in);

        String mat;
        String sem;
        String nombre = "";

        System.out.println("Escriba la materia");
        mat = sc.nextLine();

        System.out.println("Indique el semestre");  
        sem = sc.nextLine();

        ld = ldd.leerDatos("NOTAS ST0242.csv");

        
        for(Dato dato: ld){

            if(dato.materia.equals(mat)  && dato.semestre.equals(sem)){

                if(!dato.nombre_.equals(nombre))
                    System.out.println(dato.nombre_ + "   " + dato.definitiva);
                nombre = dato.nombre_;
            }
        }

        ld2 = ldd2.leerDatos("NOTAS ST0245.csv");
        for(Dato dato: ld2){
            if(dato.materia.equals(mat)  && dato.semestre.equals(sem)){

                if(!dato.nombre_.equals(nombre))
                    System.out.println(dato.nombre_ + "   " + dato.definitiva);
                nombre = dato.nombre_;
            }
        }

        ld3 = ldd3.leerDatos("NOTAS ST0247.csv");
        for(Dato dato: ld3){
            if(dato.materia.equals(mat)  && dato.semestre.equals(sem)){

                if(!dato.nombre_.equals(nombre))
                    System.out.println(dato.nombre_ + "   " + dato.definitiva);
                nombre = dato.nombre_;
            }
        }
    }

    public void c2(){
        LinkedList<Dato> ld;
        LinkedList<Dato> ld2;
        LinkedList<Dato> ld3;

        MarcoDeDatos ldd = new MarcoDeDatos();
        MarcoDeDatos ldd2 = new MarcoDeDatos();
        MarcoDeDatos ldd3 = new MarcoDeDatos();
        Scanner sc = new Scanner(System.in);

        String nombre;

        System.out.println("Escriba el nombre del estudiante");
        nombre = sc.nextLine();

        ld = ldd.leerDatos("NOTAS ST0242.csv");
        for(Dato dato: ld){
            if(dato.nombre_.equals(nombre)){
                System.out.print(dato.materia + " =  " + dato.definitiva);
                break;
            }

        }

        ld2 = ldd2.leerDatos("NOTAS ST0245.csv");
        for(Dato dato2: ld2){

            if(dato2.nombre_.equals(nombre)){

                System.out.print("     |  "+ dato2.materia + "  = " + dato2.definitiva);
                break;
            }
        }

        ld3 = ldd3.leerDatos("NOTAS ST0247.csv");
        for(Dato dato3: ld3){

            if(dato3.nombre_.equals(nombre)){

                System.out.println("     |  "+ dato3.materia + " =  " + dato3.definitiva);
                break;
            }
        }
    }
}