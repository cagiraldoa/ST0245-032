
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

/**
 * Esta clase permite organizar y disttibuir 
 * correctamente ls datos para crear un LinkedList
 * donde cada posición tiene una variable 
 * de tipo Dato
 */ 
public class MarcoDeDatos
{
    /** LinkedList donde se almacenan los datos leidos **/
    LinkedList<Dato> al = new LinkedList<>();

    /** 
     * Este método recibe el nombre del archivo que se va a leer.
     * Se trata de abrir el archivo, si se puede abrir, se leen y se muestran impresos los
     * datos y se retornan en un LinkedList que almacena referencias a 
     * objetos tipo Dato.
     */
    public LinkedList<Dato> leerDatos(String nombre) {

        try {
            Scanner archivo = new Scanner(new File(nombre));
            archivo.nextLine();
            while(archivo.hasNextLine()) {

                String linea = archivo.nextLine();

                //linea+= ", ";

                Scanner registro = new Scanner(linea.replaceAll("yes", "true").replaceAll("no", "false"));
                registro.useDelimiter(",");

                double ph = Double.parseDouble(registro.next());
                double soil_temperature = Double.parseDouble(registro.next());
                double soil_moisture = Double.parseDouble(registro.next());
                double illuminance = Double.parseDouble(registro.next());
                double env_temperature = Double.parseDouble(registro.next());
                double env_humidity = Double.parseDouble(registro.next());
                boolean label = Boolean.parseBoolean(registro.next());


                //System.out.println(ph + "    "  + soil_temperature + "    " + soil_moisture + "    " + illuminance + "    " + env_temperature + "    " + env_humidity + "    " + label); //Antes estaba comentado

                Dato dato = new Dato(ph, soil_temperature, soil_moisture, illuminance, env_temperature, env_humidity, label);
                al.add(dato);

            }
        } catch (FileNotFoundException e) {
            System.out.println("No pude abrir el archivo");
        }
        return al;
    }

    /**
     * Programa principal.
     * Se leen los datos almacenados en el archivo "datos.txt" y se
     * guardan en el LinkedList "al".
     **/
    public static void main(String [] args) {
        MarcoDeDatos ldd = new MarcoDeDatos();
        System.out.println("Voy a leer los datos");
        ldd.leerDatos("data_set.csv");
        ldd.leerDatos("data_set_balanced.csv");
        ldd.leerDatos("data_set_train.csv");
        ldd.leerDatos("data_set_test.csv");
        System.out.println("Ya leí los datos");
    }
}
