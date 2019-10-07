
public class P1_3 {

    public static String abuelaMaterna(String Persona, String genero) {
        Node yo = new Node("Cristian Alexis Giraldo Agudelo");

        //Padres
        yo.add("Dora Agudelo Montoya", "f");
        yo.add("Argiro Giraldo Franco", "m");

        //Abuelos Maternos
        yo.left.add("Amparo Montoya de Agudelo", "f");
        yo.left.add("Francisco Agudelo Agudelo", "m");

        //Abuelos Paternos
        yo.right.add("Alicia Franco de Giraldo", "f");
        yo.right.add("Luis Giraldo", "m");

        //Biabuelos Maternos
        yo.left.left.add("Aura Ines Sanchez", "f");
        yo.left.left.add("Juan de Dios Montoya", "m");
        yo.left.right.add("Maria Alejandria Agudelo", "f");
        yo.left.right.add("Pablo Emilio Agudelo", "m");

        //Biabuelos Paternos
        yo.right.left.add("Maria Pastora Giraldo", "f");
        yo.right.left.add("Vicente Franco", "m");
        yo.right.right.add("Luisa Vergara", "f");
        yo.right.right.add("Juan Epomuseno Giraldo", "m");

        return buscar(yo, Persona, genero).left.left.data;
    }

    private static Node buscar(Node node, String n, String genero) {
        if (node != null)

            if (node.data.equals(n))
                return node;
            else {
                if (genero.equals("f"))   
                    return buscar(node.left,n, genero);
                return buscar(node.right, n, genero); 

            }

        return node;
    }
}

