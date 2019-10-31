
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Analisis 
{
    Procesamiento p =  new Procesamiento();
    LinkedList<Dato> data2 = new LinkedList<Dato>();    
    Node arbol;
    MarcoDeDatos ld = new MarcoDeDatos();
    LinkedList<Dato> data3 = new LinkedList<Dato>();    

    MarcoDeDatos ld2 = new MarcoDeDatos();

    LinkedList<Boolean> b = new LinkedList<Boolean>();
    public void main(){

        p.main("data_set_train.csv");

        data2 = ld.leerDatos("data_set_test.csv");
        data3 = ld2.leerDatos("data_set_train.csv");
        arbol = p.armarArbol(data3, 0);

        for(Dato d: data2){

            switch((arbol.decidir(d.soil_moisture)) ? 1 : 0){ 
                case 1:
                System.out.println("Tiene Roya? " + arbol.right.answer);
                b.add(arbol.right.answer);
                continue;

                case 0:
                switch((arbol.left.decidir(d.soil_moisture)) ? 1 : 0){ 

                    case 1:
                    switch((arbol.left.right.decidir(d.ph)) ? 1 : 0){ 

                        case 1:
                        switch((arbol.left.right.right.decidir(d.soil_moisture)) ? 1 : 0){
                            case 1:
                            switch((arbol.left.right.right.right.decidir(d.env_temperature)) ? 1 : 0){
                                case 1:
                                System.out.println("Tiene Roya? " + arbol.left.right.right.right.right.answer);
                                b.add(arbol.left.right.right.right.right.answer);
                                continue;

                                case 0:
                                switch((arbol.left.right.right.right.left.decidir(d.illuminance)) ? 1 : 0){
                                    case 1:
                                    System.out.println("Tiene Roya? " + arbol.left.right.right.right.left.right.answer);
                                    b.add(arbol.left.right.right.right.left.right.answer);
                                    continue;

                                    case 0:
                                    System.out.println("Tiene Roya? " + arbol.left.right.right.right.left.left.answer);
                                    b.add(arbol.left.right.right.right.left.left.answer);
                                    continue;
                                }  
                                continue;
                            }
                            continue;

                            case 0:
                            switch((arbol.left.right.right.left.decidir(d.env_humidity)) ? 1 : 0){

                                case 1:
                                switch((arbol.left.right.right.left.right.decidir(d.illuminance)) ? 1 : 0){
                                    case 1:
                                    switch((arbol.left.right.right.left.right.right.decidir(d.soil_moisture)) ? 1 : 0){

                                        case 1:
                                        System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.right.right.answer);
                                        b.add(arbol.left.right.right.left.right.right.right.answer);
                                        continue;

                                        case 0:
                                        switch((arbol.left.right.right.left.right.right.left.decidir(d.soil_temperature)) ? 1 : 0){
                                            case 1:
                                            System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.right.left.right.answer);
                                            b.add(arbol.left.right.right.left.right.right.left.right.answer);
                                            continue;

                                            case 0:
                                            System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.right.left.left.answer);
                                            b.add(arbol.left.right.right.left.right.right.left.left.answer);
                                            continue;
                                        }
                                        continue;
                                    }
                                    continue;

                                    case 0:
                                    switch((arbol.left.right.right.left.right.left.decidir(d.soil_moisture)) ? 1 : 0){

                                        case 1:
                                        switch((arbol.left.right.right.left.right.left.right.decidir(d.soil_moisture)) ? 1 : 0){
                                            case 1:
                                            switch((arbol.left.right.right.left.right.left.right.right.decidir(d.illuminance)) ? 1 : 0){

                                                case 1:
                                                switch((arbol.left.right.right.left.right.left.right.right.right.decidir(d.illuminance)) ? 1 : 0){

                                                    case 1: 
                                                    switch((arbol.left.right.right.left.right.left.right.right.right.right.decidir(d.illuminance)) ? 1 : 0){
                                                        case 1:
                                                        switch((arbol.left.right.right.left.right.left.right.right.right.right.right.decidir(d.ph)) ? 1 : 0){

                                                            case 1:
                                                            System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.right.right.right.right.answer);
                                                            b.add(arbol.left.right.right.left.right.left.right.right.right.right.right.right.answer);
                                                            continue;

                                                            case 0:
                                                            switch((arbol.left.right.right.left.right.left.right.right.right.right.right.left.decidir(d.soil_temperature)) ? 1 : 0){

                                                                case 1:
                                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.right.right.right.left.right.answer);
                                                                b.add(arbol.left.right.right.left.right.left.right.right.right.right.right.left.right.answer);
                                                                continue;

                                                                case 0:
                                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.right.right.right.left.left.answer);
                                                                b.add(arbol.left.right.right.left.right.left.right.right.right.right.right.left.left.answer);
                                                                continue;

                                                            }
                                                            continue;
                                                        }
                                                        continue;

                                                        case 0:
                                                        System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.right.right.left.answer);
                                                        b.add(arbol.left.right.right.left.right.left.right.right.right.right.left.answer);
                                                        continue;
                                                    }
                                                    continue;

                                                    case 0:
                                                    switch((arbol.left.right.right.left.right.left.right.right.right.left.decidir(d.soil_moisture)) ? 1 : 0){

                                                        case 1:
                                                        System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.right.left.right.answer);
                                                        b.add(arbol.left.right.right.left.right.left.right.right.right.left.right.answer);
                                                        continue;

                                                        case 0:
                                                        System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.right.left.left.answer);
                                                        b.add(arbol.left.right.right.left.right.left.right.right.right.left.left.answer);
                                                        continue;
                                                    }
                                                    continue;
                                                }
                                                continue;
                                                //
                                                case 0:
                                                switch((arbol.left.right.right.left.right.left.right.right.left.decidir(d.ph)) ? 1 : 0){
                                                    case 1:
                                                    System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.left.right.answer);
                                                    b.add(arbol.left.right.right.left.right.left.right.right.left.right.answer);
                                                    continue;

                                                    case 0:
                                                    System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.right.left.left.answer);
                                                    b.add(arbol.left.right.right.left.right.left.right.right.left.left.answer);
                                                    continue;   
                                                }
                                            }  
                                            continue;

                                            case 0:
                                            switch((arbol.left.right.right.left.right.left.right.left.decidir(d.illuminance)) ? 1 : 0){
                                                case 1:
                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.left.right.answer);
                                                b.add(arbol.left.right.right.left.right.left.right.left.right.answer);
                                                continue;

                                                case 0:
                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.right.left.left.answer);
                                                b.add(arbol.left.right.right.left.right.left.right.left.left.answer);
                                                continue;
                                            }
                                            continue;
                                        }

                                        case 0:
                                        switch((arbol.left.right.right.left.right.left.left.decidir(d.ph)) ? 1 : 0){

                                            case 1:
                                            switch((arbol.left.right.right.left.right.left.left.right.decidir(d.ph)) ? 1 : 0){

                                                case 1:
                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.left.right.right.answer);
                                                b.add(arbol.left.right.right.left.right.left.left.right.right.answer);
                                                continue;

                                                case 0:
                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.left.right.left.answer);
                                                b.add(arbol.left.right.right.left.right.left.left.right.left.answer);
                                                continue;
                                            }
                                            continue;

                                            case 0:
                                            switch((arbol.left.right.right.left.right.left.left.left.decidir(d.soil_moisture)) ? 1 : 0){
                                                case 1:
                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.left.left.right.answer);
                                                b.add(arbol.left.right.right.left.right.left.left.left.right.answer);
                                                continue;

                                                case 0:
                                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.right.left.left.left.left.answer);
                                                b.add(arbol.left.right.right.left.right.left.left.left.left.answer);
                                                continue;
                                            }

                                            continue;
                                        }
                                        continue;
                                    }
                                    continue;
                                }

                                case 0:
                                System.out.println("Tiene Roya? " + arbol.left.right.right.left.left.answer);
                                b.add(arbol.left.right.right.left.left.answer);
                                continue;

                            }
                            continue;
                        }
                        continue;

                        case 0:
                        switch((arbol.left.right.left.decidir(d.illuminance)) ? 1 : 0){ 

                            case 1:

                            switch((arbol.left.right.left.right.decidir(d.ph)) ? 1 : 0){ 

                                case 1:
                                switch((arbol.left.right.left.right.right.decidir(d.soil_moisture)) ? 1 : 0){ 

                                    case 1:
                                    switch((arbol.left.right.left.right.right.right.decidir(d.soil_temperature)) ? 1 : 0){ 

                                        case 1:

                                        System.out.println("Tiene Roya? " + arbol.left.right.left.right.right.right.right.answer);
                                        b.add(arbol.left.right.left.right.right.right.right.answer);
                                        continue;

                                        case 0:
                                        System.out.println("Tiene Roya? " + arbol.left.right.left.right.right.right.left.answer);
                                        b.add(arbol.left.right.left.right.right.right.left.answer);
                                        continue;
                                    }
                                    continue;

                                    case 0:
                                    System.out.println("Tiene Roya? " + arbol.left.right.left.right.right.right.left.answer);
                                    b.add(arbol.left.right.left.right.right.right.left.answer);
                                    continue;
                                }
                                continue;

                                case 0:
                                System.out.println("Tiene Roya? " + arbol.left.right.left.right.left.answer);
                                b.add(arbol.left.right.left.right.left.answer);
                                continue;
                            }
                            continue;

                            case 0:
                            System.out.println("Tiene Roya? " + arbol.left.right.left.left.answer);
                            b.add(arbol.left.right.left.left.answer);
                            continue;
                        }
                        continue;
                    }
                    continue;

                    case 0:
                    switch((arbol.left.left.decidir(d.ph)) ? 1 : 0){ 
                        case 1:
                        switch((arbol.left.left.right.decidir(d.illuminance)) ? 1 : 0){ 

                            case 1:
                            switch((arbol.left.left.right.right.decidir(d.env_temperature)) ? 1 : 0){ 

                                case 1:
                                switch((arbol.left.left.right.right.decidir(d.soil_moisture)) ? 1 : 0){

                                    case 1:
                                    switch((arbol.left.left.right.right.right.decidir(d.ph)) ? 1 : 0){

                                        case 1:
                                        System.out.println("Tiene Roya? " + arbol.left.left.right.right.right.right.answer);
                                        b.add(arbol.left.left.right.right.right.right.answer);
                                        continue;

                                        case 0:
                                        System.out.println("Tiene Roya? " + arbol.left.left.right.right.right.left.answer);
                                        b.add(arbol.left.left.right.right.right.left.answer);
                                        continue;
                                    }
                                    continue;

                                    case 0:
                                    switch((arbol.left.left.right.right.left.decidir(d.ph)) ? 1 : 0){

                                        case 1:
                                        System.out.println("Tiene Roya? " + arbol.left.left.right.right.left.right.answer);
                                        b.add(arbol.left.left.right.right.left.right.answer);
                                        continue;

                                        case 0:
                                        System.out.println("Tiene Roya? " + arbol.left.left.right.right.left.left.answer);
                                        b.add(arbol.left.left.right.right.left.left.answer);
                                        continue;
                                    }
                                    continue;
                                }
                                continue;

                                case 0:
                                switch((arbol.left.left.right.right.left.decidir(d.ph)) ? 1 : 0){ 
                                    case 1:
                                    switch((arbol.left.left.right.right.left.right.decidir(d.ph)) ? 1 : 0){ 
                                        case 1:
                                        System.out.println("Tiene Roya? " + arbol.left.left.right.right.left.right.right.answer);
                                        b.add(arbol.left.left.right.right.left.right.right.answer);
                                        continue;

                                        case 0:
                                        switch((arbol.left.left.right.right.left.right.left.decidir(d.soil_moisture)) ? 1 : 0){ 

                                            case 1:
                                            System.out.println("Tiene Roya? " + arbol.left.left.right.right.left.right.left.right.answer);
                                            b.add(arbol.left.left.right.right.left.right.left.right.answer);
                                            continue;

                                            case 0:
                                            System.out.println("Tiene Roya? " + arbol.left.left.right.right.left.right.left.left.answer);
                                            b.add(arbol.left.left.right.right.left.right.left.left.answer);
                                            continue;
                                        }
                                        continue;
                                    }
                                    continue;
                                }
                                continue;
                            }

                            case 0:
                            switch((arbol.left.left.right.left.decidir(d.env_temperature)) ? 1 : 0){ 

                                case 1:
                                switch((arbol.left.left.right.left.right.decidir(d.soil_moisture)) ? 1 : 0){ 

                                    case 1:
                                    switch((arbol.left.left.right.left.right.right.decidir(d.env_humidity)) ? 1 : 0){

                                        case 1:
                                        switch((arbol.left.left.right.left.right.right.right.decidir(d.env_temperature)) ? 1 : 0){

                                            case 1:
                                            switch((arbol.left.left.right.left.right.right.right.right.decidir(d.soil_moisture)) ? 1 : 0){

                                                case 1:
                                                System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.right.right.right.answer);
                                                b.add(arbol.left.left.right.left.right.right.right.right.right.answer);
                                                continue; 

                                                case 0:
                                                switch((arbol.left.left.right.left.right.right.right.left.decidir(d.env_temperature)) ? 1 : 0){

                                                    case 1:
                                                    System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.right.left.right.answer);
                                                    b.add(arbol.left.left.right.left.right.right.right.left.right.answer);
                                                    continue;

                                                    case 0:
                                                    System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.right.left.left.answer);
                                                    b.add(arbol.left.left.right.left.right.right.right.left.left.answer);
                                                    continue;
                                                }
                                                continue;
                                            }
                                            continue;

                                            case 0:
                                            switch((arbol.left.left.right.left.right.right.right.left.decidir(d.illuminance)) ? 1 : 0){

                                                case 1:
                                                switch((arbol.left.left.right.left.right.right.right.left.right.decidir(d.ph)) ? 1 : 0){

                                                    case 1:
                                                    System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.right.left.right.right.answer);
                                                    b.add(arbol.left.left.right.left.right.right.right.left.right.right.answer);
                                                    continue;

                                                    case 0:
                                                    System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.right.left.right.left.answer);
                                                    b.add(arbol.left.left.right.left.right.right.right.left.right.left.answer);
                                                    continue;
                                                }
                                                continue;

                                                case 0:
                                                System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.right.left.left.answer);
                                                b.add(arbol.left.left.right.left.right.right.right.left.left.answer);
                                                continue;
                                            }
                                            continue;
                                        }
                                        continue;

                                        case 0:
                                        switch((arbol.left.left.right.left.right.right.left.decidir(d.soil_moisture)) ? 1 : 0){

                                            case 1:
                                            System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.left.right.answer);
                                            b.add(arbol.left.left.right.left.right.right.left.right.answer);
                                            continue;

                                            case 0:
                                            System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.right.left.left.answer);
                                            b.add(arbol.left.left.right.left.right.right.left.left.answer);
                                            continue;  
                                        }
                                        continue;
                                    }
                                    continue;

                                    case 0:
                                    System.out.println("Tiene Roya? " + arbol.left.left.right.left.right.left.answer);
                                    b.add(arbol.left.left.right.left.right.left.answer);
                                    continue;  
                                }
                                continue;

                                case 0:

                                System.out.println("Tiene Roya? " + arbol.left.left.right.left.left.answer);
                                b.add(arbol.left.left.right.left.left.answer);
                                continue; 
                            }
                            continue;
                        }
                        continue;

                        case 0:

                        System.out.println("Tiene Roya? " + arbol.left.left.left.answer);
                        b.add(arbol.left.left.left.answer);
                        continue;

                    }
                    continue;

                }
                continue;

            }
            continue;
            
        }
    }
}

