import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class BrazoRobotico{
    
    public static Stack<Integer>[] bloques;

    public static Stack<Integer>[] crearpila(int n){
        bloques = new Stack[n];
        for(int i=0;i<n;i++){
            bloques[i]=new Stack<Integer>();
            bloques[i].push(i);
        }
        return bloques;
    }

    public static void impresion(){
        for(int i=0;i<bloques.length;i++)
            System.out.println(i+": "+bloques[i]);
    }

    public static int buscar(int x){
        int a=-1;
        for(int i=0;i<bloques.length&&a==-1;i++){
            Stack<Integer> temp= new Stack<Integer>();
            temp=bloques[i];
            a=temp.search(x);
            if(a!=-1){
                return i;
            }
        }
        return a;
    }

    public static void moveOnto(int a, int b){
        int posa= buscar(a);
        int posb= buscar(b);
        if(posa==posb){
            System.out.println("Los dos elementos estan en la misma fila intente hacer el comando move over");
        }else{
            while(bloques[posa].peek()!=a){
                int t= bloques[posa].pop();
                bloques[t].push(t);
            }
            while(bloques[posb].peek()!=b){
                int t= bloques[posb].pop();
                bloques[t].push(t);
            }
        }

        bloques[posb].push(bloques[posa].pop());
        impresion();
    }

    public static void moveOver(int a, int b){
        int posa= buscar(a);
        int posb= buscar(b);
        while(bloques[posa].peek()!=a){
            int t= bloques[posa].pop();
            bloques[t].push(t);
        }
        bloques[posb].push(bloques[posa].pop());
        impresion();
    }

    public static void pileOnto(int a , int b){
        int posa= buscar(a);
        int posb= buscar(b);
        while(bloques[posb].peek()!=b){
            int t= bloques[posb].pop();
            bloques[t].push(t);
        }
        Stack<Integer> temp= new Stack<Integer>();
        while(bloques[posb].peek()!=a){
            temp.push(bloques[posa].pop());
        }
        temp.push(bloques[posa].pop());
        while(temp.isEmpty()){
            bloques[posb].push(temp.pop());
        }
        impresion();
    }

    public static void pileOver(int a , int b){
        int posa= buscar(a);
        int posb= buscar(b);

        Stack<Integer> temp= new Stack<Integer>();
        while(bloques[posa].peek()!=a){
            temp.push(bloques[posa].pop());
        }
        temp.push(bloques[posa].pop());
        while(!temp.isEmpty()){
            bloques[posb].push(temp.pop());
        }
        impresion();
    }

    public static void comandos(){
        Scanner tecl= new Scanner(System.in);
        String comando;
        boolean estado=true;
        while(estado==true){
            System.out.println("Ingrese un comando");
            comando=tecl.nextLine();

            String[] texto= comando.split(" ");
            //menu de comandos
            if(texto[0].equals("move")){
                if(texto[2].equals("onto")){
                    moveOnto(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }
                if(texto[2].equals("over")){
                    moveOver(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }
            }
            if(texto[0].equals("pile")){
                if(texto[2].equals("ontto")){
                    pileOnto(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }
                if(texto[2].equals("over")){
                    pileOver(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }

            }
            if(texto[0].equals("quit")){
                System.out.println("Fin de las Operaciones");
                System.out.println("Resultado final:");
                estado=false;
            }

        }
        impresion();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nuemero de cubos que hay");

        int n= teclado.nextInt();
        crearpila(n);
        impresion();
        comandos();

    }

}