
public class P1_2 {

    public static Node arbolGenealogico() {
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
        
        return yo;
    }
   
}

