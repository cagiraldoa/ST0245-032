import java.util.*;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {

    /**
     * @param stack es una pila ya implementada que se crea en el test
     * Este método se encarga de poner la pila stack en orden inverso
     * Nota: recuerde que la funcion pop() no solo expulsa la última 
     * posición de una pila si no que tambien devuelve su valor.
     * @return una pila que haga el inverso de stack
     */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> stack2 = new Stack<Integer>();

        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }

        return stack2;
    }

    /**
     * @param queue es una cola ya implementada que se crea en el test
     * Este método se encarga de atender a personas.
     * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
     * existe una función "pull" que hace el trabajo más fácil
     * 
     */
    public static void cola (Queue<String> queue){

        while(queue.peek()!=null){
            System.out.println("Se está atendiendo a " + queue.poll());
        }
    }

    /**
     * @param string es una pol de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
     * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
     * Se intenta hacer el calculo por medio del metodo polaco posfijo
     * @return un entero resultado de la operación
     */
    public static int polaca  (String string){
        Stack<Integer> op = new Stack<>();
        String[] pol = string.split(" ");
        for(int i=0;i<pol.length;i++){
            char c = (pol[i]).charAt(0);
            if(c=='+' || c =='-' || c=='*' || c=='/'){
                switch(c){
                    case '+':
                    op.push(op.pop()+op.pop());
                    break;
                    case '-':
                    op.push((op.pop()*-1)+op.pop());
                    break;
                    case '*':
                    op.push(op.pop()*op.pop());
                    break;
                    case '/':
                    int num1=op.pop();int num2=op.pop();
                    op.push(num2/num1);
                    break;
                }  
            }else{
                op.push(Integer.parseInt(pol[i]));
            }
        }
        return op.pop();
    }

}