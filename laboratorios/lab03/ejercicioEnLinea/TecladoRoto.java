import java.util.*;

public class TecladoRoto{
    //Punto 2.1
    public static void teclado(){
        LinkedList<Character>texto = new LinkedList<>();
        int posicion = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese texto");
        String tec = sc.nextLine(); 


        boolean inicio = false;

        for (int i=0;i<tec.length();i++){

            if(tec.charAt(i)=='['){
                inicio = true;
                posicion = 0;
            } else if (tec.charAt(i)==']'){
                inicio = false;    
            }

            if(tec.charAt(i)!='[' && tec.charAt(i)!=']'){
                if(inicio == true){
                    texto.add(posicion,tec.charAt(i));
                    posicion++;
                } else {
                    texto.addLast(tec.charAt(i));
                }
            }
        } 

        for(Character t: texto){
            System.out.print(t);
        }
    }
}