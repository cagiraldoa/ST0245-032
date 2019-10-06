
/**
 * Write a description of class P2_1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class P2_1
{
    public static void main(String[] args) {
        Node ab = new Node(50);

        ab.add(30);
        ab.add(24);
        ab.add(5);
        ab.add(28);
        ab.add(45);
        ab.add(98);
        ab.add(52);
        ab.add(60);
        System.out.println("Pos_Orden\n");
        ab.postOrden(ab);
        System.out.println("\nPre_Orden\n");
        ab.preOrden(ab);
    }
}