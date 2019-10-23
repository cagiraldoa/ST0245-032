
import java.util.*;
public class AnalisisDatos
{
    LinkedList<Vertice>vertices=new LinkedList<Vertice>();
    LinkedList<Arco>arcos=new LinkedList<Arco>();
    public AnalisisDatos(LinkedList<Vertice> vertices,LinkedList<Arco> arcos){
        this.arcos=arcos;
        this.vertices=vertices;

    }

    public  LinkedList<Long> getSuccessors(long vertexID){
        LinkedList<Long> sucesores=new LinkedList<Long>();
        for(Arco arcos: arcos){
            long codigo=arcos.ID1;
            if(vertexID==codigo){
                sucesores.add(arcos.ID2);
            }
        }
        return sucesores;
    }

    public double getWeight(int sourceID, int destinationID){
        for(Arco arcos: arcos){
            if(sourceID==arcos.ID1 && destinationID==arcos.ID2){
                return arcos.distancia;

            }

        }
        return 0;
    }

    public int size() {
        return vertices.size();
    }
}