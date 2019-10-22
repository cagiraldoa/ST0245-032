import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class P2_1{

    public void main (String [] args){

        DigraphAM DAM1 = new DigraphAM(3);
        DAM1.addArc(0, 1, 1);
        DAM1.addArc(1, 2, 1);
        DAM1.addArc(2, 0, 1);

        boolean ans1 = isBipartite(DAM1, 0, 3);

        if(ans1) System.out.println("BICOLORABLE");
        else System.out.println("NOT BICOLORABLE");

        DigraphAM graph2 = new DigraphAM(3);
        graph2.addArc(0, 1, 1);
        graph2.addArc(1, 2, 1);

        boolean ans2 = isBipartite(graph2, 0, 3);

        if(ans2) System.out.println("BICOLORABLE");
        else System.out.println("NOT BICOLORABLE");

        DigraphAM graph3 = new DigraphAM(9);
        graph3.addArc(0, 1, 1);
        graph3.addArc(0, 2, 1);
        graph3.addArc(0, 3, 1);
        graph3.addArc(0, 4, 1);
        graph3.addArc(0, 5, 1);
        graph3.addArc(0, 6, 1);
        graph3.addArc(0, 7, 1);
        graph3.addArc(0, 8, 1);

        boolean ans3 = isBipartite(graph3, 0, 9);

        if(ans3) System.out.println("BICOLORABLE");
        else System.out.println("NOT BICOLORABLE");
    }

    boolean isBipartite(DigraphAM g,int src, int V) 
    { 

        int colorArr[] = new int[V]; 
        for (int i=0; i<V; ++i) 
            colorArr[i] = -1; 

        colorArr[src] = 1; 

        LinkedList<Integer>list = new LinkedList<Integer>(); 
        list.add(src); 

        while (list.size() != 0) 
        { 

            int u = list.poll(); 

            if (g.getWeight(u, u) == 1) 
                return false;  

            for (int v=0; v<V; ++v) 
            { 

                if (g.getWeight(u, v)==1 && colorArr[v]==-1) 
                { 

                    colorArr[v] = 1-colorArr[u]; 
                    list.add(v); 
                } 

                else if (g.getWeight(u, v)==1 && colorArr[v]==colorArr[u]) 
                    return false; 
            } 
        } 

        return true; 
    } 
}