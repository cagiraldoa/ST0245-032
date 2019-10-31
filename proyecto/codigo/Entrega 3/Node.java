import java.util.Optional;
class Node {

    boolean answer;
    double value;  
    int nivel;   
    Node right, left;
    DataType type;

    public Node(double value, DataType t) {
        this.value = value;
        this.type = t;
    }

    public Node(boolean answer) {
        this.answer = answer;
    }

    public boolean decidir(double n) {
        return n > value;
    }
    
}