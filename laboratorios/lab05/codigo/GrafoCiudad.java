import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

class Vertice
{
    Long id;
    double x;
    double y;
    String nombre;
    public Vertice(Long id,double x,double y,String nombre){

        this.id=id;
        this.x=x;
        this.y=y;
        this.nombre=nombre;
    }
}

class Arco
{
    long ID1;
    long ID2;
    double distancia;
    String nombre;

    public Arco(long ID1,long ID2, double distancia, String nombre){
        this.ID1=ID1;
        this.ID2=ID2;
        this.distancia=distancia;
        this.nombre=nombre;
    }
}

public  class GrafoCiudad {
    LinkedList<Vertice> al = new LinkedList<>();
    LinkedList<Arco> al2 = new LinkedList<>();

    public LinkedList<Vertice> leerDatosVertice() {

        try {
            Scanner archivo = new Scanner(new File("medellin_colombia-grande.txt"));
            archivo.nextLine();
            while(archivo.hasNextLine()) {

                String linea = archivo.nextLine();
                if(linea.isEmpty())

                    break;
                //linea+= ", ";

                Scanner registro = new Scanner(linea+" ");
                registro.useDelimiter(" ");

                long id = Long.parseLong(registro.next());
                double x = Double.parseDouble(registro.next());
                double y = Double.parseDouble(registro.next());
                String nombre = registro.next();

                if (nombre.isEmpty()) nombre = "No registra";

                Vertice dato = new Vertice(id, x, y, nombre);
                al.add(dato);

            }
        } catch (FileNotFoundException e) {
            System.out.println("No pude abrir el archivo");
        }
        return al;
    }

    public LinkedList<Arco> leerDatosArco() {
        int cont=0;
        try {
            Scanner archivo = new Scanner(new File("medellin_colombia-grande.txt"));

            while(archivo.hasNextLine()) {

                String linea = archivo.nextLine();

                if(linea.contains("Arco")){
                    cont=1;
                    linea = archivo.nextLine();
                }
                if(cont==1){
                    Scanner registro = new Scanner(linea);
                    registro.useDelimiter(" ");
                    long ID1 = Long.parseLong(registro.next());
                    long ID2 = Long.parseLong(registro.next());
                    double distancia = Double.parseDouble(registro.next());
                    String nombre = registro.next();

                    if (nombre.isEmpty()) nombre = "No registra";

                    Arco dato = new Arco(ID1, ID2, distancia, nombre);
                    al2.add(dato);

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("No pude abrir el archivo");
        }
        return al2;
    }

}