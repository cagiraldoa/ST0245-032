import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Procesamiento {
    LinkedList<Dato> data = new LinkedList<Dato>(); 
    Node arbol;    

    MarcoDeDatos ld = new MarcoDeDatos();

    public void main(String archivo) {
        data = ld.leerDatos(archivo);
        arbol = armarArbol(data, 0);
    }

    public Node armarArbol(LinkedList<Dato> listaDatos, int nivel) {
        if(listaDatos.size() == 1) {
            return new Node(listaDatos.getFirst().label);
        }

        try {

            if(listaDatos.isEmpty()) throw new Exception("listaDatos vacío");
            double entropy_g = Gain.generalEntropy(listaDatos); 

            if (entropy_g == 0) return new Node(listaDatos.getFirst().label); 
            
            double min_ent = Double.MAX_VALUE;
            double node_value = Double.MAX_VALUE;
            DataType sel_type = DataType.PH ;

            for(DataType t : DataType.values()) { 
                double [] test = Gain.partialEntropy(listaDatos, t);
                if (test[0] < min_ent) {
                    min_ent = test[0];
                    node_value = test[1];
                    sel_type = t;
                }
            }

            Node n = new Node(node_value, sel_type);
            n.nivel = nivel;

            LinkedList<Dato> lista = new LinkedList<Dato>(), lista2 = new LinkedList<Dato>();
            for (Dato d : listaDatos) {
                if (n.decidir(d.getValue(sel_type))) lista.add(d);
                else lista2.add(d);
            }

            Node m = armarArbol(lista, nivel + 1);
            n.right = (m != null)? m: new Node(true);
            
            m = armarArbol(lista2, nivel + 1);
            n.left = (m != null)?  m: new Node(false);

            return n;
        }
        catch(Exception e) {
            return null;
        }
    }


    public Node getRoot() {
        return arbol;
    }


    public int getHeight() {
        return getHeight(arbol);
    }

    private int getHeight(Node n) {
        if (n == null) return 0;

        int lnodes = 1 + getHeight(n.left);
        int rnodes = 1 + getHeight(n.right);

        return Math.max(lnodes, rnodes);
    }

    public int getWidth() {
        int max = Integer.MIN_VALUE;
        int [] niveles = new int[getHeight()];

        getWidth(niveles, arbol);
        for (int n: niveles) {
            if (n > max) max = n;
        }
        return max;
    }

    private void getWidth(int [] niveles, Node n) {
        if (n != null) {
            niveles[n.nivel]++;
            getWidth(niveles, n.left);
            getWidth(niveles, n.right);
        }
    }

    public int getSize() {
        return data.size();
    }
}


class Gain {
    
    public static double generalEntropy(LinkedList<Dato> listaDatos) {
        

        double right = 0, no = 0;

        for (Dato d : listaDatos) {
            if (d.label) right++;
            else no++;
        }

        if (right == 0 || no == 0) return 0;
        double a = -(right /listaDatos.size()) * Math.log(right / listaDatos.size()) / Math.log(2);
        double b = -(no / listaDatos.size()) * Math.log(no / listaDatos.size()) / Math.log(2);
        return a + b;
    }

    public static double [] partialEntropy(LinkedList<Dato> listaDatos, DataType t) throws Exception {
        LinkedList<Dato> lista = new LinkedList<Dato>(), lista2 = new LinkedList<Dato>();

        double min = Double.MAX_VALUE;
        double measure_d = 0;

        for (Dato data: listaDatos) {
            double measure = data.getValue(t);

            
            for (Dato d : listaDatos) {
                double test = d.getValue(t);
                if (test <= measure) lista.add(d);
                else lista2.add(d);
            }

            double entropy_lista = Gain.generalEntropy(lista);
            double entropy_lista2 = (!lista2.isEmpty())? Ganancia.generalEntropy(lista2) : 0;

            double test = (lista.size()*entropy_lista + lista2.size()*entropy_lista2) / listaDatos.size();

            if (test < min)  {
                min = test;
                measure_d = measure;
            }

            lista.clear();
            lista2.clear();
        }

        return new double[]{min, measure_d};
    }
}
