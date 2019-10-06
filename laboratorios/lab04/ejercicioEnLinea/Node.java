

public class Node {
 public Node left;
 public Node right;
 public int data;
 public Node(int d){
	 
	data = d;
 }
 
 public void add(int data) {
        if (data < this.data) {
            if (left != null) {
                left.add(data);
            } else {
                left = new Node(data);
            }
        } else {
            if (right != null) {
                right.add(data);
            } else {
                right = new Node(data);
            }
        }
    }
    
    public void postOrden(Node n){
        if(n!=null){
            postOrden(n.left);
            postOrden(n.right);
            System.out.println(n.data);
        }
    }

    public void preOrden(Node n) {
        if(n!=null) {
            System.out.println(n.data);
            postOrden(n.left);
            postOrden(n.right);
        }
    }
}
