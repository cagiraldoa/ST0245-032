import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dat   o en la posición index
    public void insert(int data, int index)
    {
        if(index==0){     
            Node insert = new Node(data);
            insert.next = first;
            first = insert;
        } else if(index>=0 && index<=size){
            Node temp = first;
            for(int i=0; i<index-1; i++){
                temp = temp.next; 
            }
            Node insert = new Node(data);
            insert.next = temp.next;
            temp.next = insert;
        }
        size++;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(index==0){
            first=first.next;
        }else{
            Node temp = first;    
            for(int i=0;i<index-1;i++){
                temp =temp.next;
            }
            Node remove = temp;
            remove.next = (temp.next).next;
        }
        size--;
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node temp = first;
        while(temp != null){
            if(data == temp.data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }



}