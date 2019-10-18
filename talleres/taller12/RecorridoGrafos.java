
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;


public class RecorridoGrafos
{
    public boolean has(ArrayList<Integer> a, int b)
    {
        for(Integer has: a){
            if (has==b) return true;
        }
        return false;
    }

    public boolean profundidad(DigraphAL a, int b, int c){
        ArrayList<Integer> d = a.getSuccessors(b);
        if(d.size()==0)
        {
            return false; 
        }
        else if(has(d,c)) {
            return true;
        }
        else{
            for(Integer profundidad: d){
                profundidad(a,profundidad,c);
            }

        }
        return false;
    }

    public boolean aux(DigraphAL a,ArrayList<Integer> b )
    {
        ArrayList<Integer> d = new ArrayList();
        boolean c = false;
        for(Integer aux: b)
        {
            d=a.getSuccessors(aux);
            for(Integer aux2: b)
            {
                if(d.contains(aux2)){
                    c=true;   
                }

            }
        }
        return c;
    }

    public boolean amplitud(DigraphAL a, int b, int c){
        ArrayList<Integer> d = a.getSuccessors(b);
        if(d.size()==0)
        {
            return false; 
        }
        else if(aux(a,d)) {
            return aux(a,d);
        }
        else{
          for(Integer amplitud: d){
              amplitud(a,amplitud,c);
            }
        }

        return false;
    }
}