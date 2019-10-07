public class Node {
 public Node left;
 public Node right;
 public String data;
 public Node(String d){
	 
	data = d;
 }
 
 public void add(String data, String genero) {
        if (genero.equals("f")) {
            if (left != null) {
                left.add(data, "");
            } else {
                left = new Node(data);
            }
        } else {
            if (right != null) {
                right.add(data, "");
            } else {
                right = new Node(data);
            }
        }
    }
}