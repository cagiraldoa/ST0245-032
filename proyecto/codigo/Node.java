import java.util.Optional;

public class Node {
    
    private  double value;
    private Node left;
    private Node right;
 
    public Node(double value) {
        this.value = value;
    }
 
   
 
    public void add(double value) {
        if (value < this.value) {
            if (left != null) {
                left.add(value);
            } else {
                left = new Node(value);
            }
        } else {
            if (right != null) {
                right.add(value);
            } else {
                right = new Node(value);
            }
        }
    }
 
    public Optional<Node> find(double value) {
        if (value == this.value) {
            return Optional.of(this);
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.find(value);
            } else {
                return Optional.empty();
            }
        } else {
            if (this.right != null) {
                return this.right.find(value);
            } else {
                return Optional.empty();
            }
        }
    }
 
 
 
    public void toString_() {
        System.out.println( "Node [value=" + value + ", left=" + left + ", right=" + right + "]");
    }
 
}