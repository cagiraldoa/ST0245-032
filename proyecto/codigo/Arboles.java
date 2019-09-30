import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class Arboles
{

    public Node arboles(String archivo){

        LinkedList<Dato> arbol;
        MarcoDeDatos arbol_ = new MarcoDeDatos();

        arbol = arbol_.leerDatos(archivo);

        Node ph = new Node(0.0);
        Node soil_temperature = new Node(0.0);
        Node soil_moisture = new Node(0.0);
        Node illuminance = new Node(0.0);
        Node env_temperature = new Node(0.0);
        Node env_humidity = new Node(0.0);

        for(Dato dato: arbol){

            ph.add(dato.ph);
            soil_temperature.add(dato.soil_temperature);
            soil_moisture.add(dato.soil_moisture);
            illuminance.add(dato.illuminance);
            env_temperature.add(dato.env_temperature);
            env_humidity.add(dato.env_humidity);

        }

        return ph;
    }
}
