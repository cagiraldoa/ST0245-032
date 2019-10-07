import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Procesamiento
{
    ArrayList<ArrayList<String>> archivo1= new ArrayList<ArrayList<String>>();
    Directorio directorio1;


    public void leerDatos(String archivo){
        try{

            BufferedReader br=new BufferedReader(new FileReader(archivo));
            String directorio=br.readLine();
            directorio1=new Directorio(directorio);
            String linea=br.readLine();

            while(linea!=null){
                ArrayList<String>cd=new ArrayList<String>();
                String[]cadena=linea.split(" ");
                for(int i=0; i<cadena.length;i++){
                    cd.add(cadena[i]);
                }
                archivo1.add(cd);
                linea=br.readLine();
            }
            tipo();

        }
        catch(IOException ioe){
            System.out.println("E   l archivo no existe");
        }
    }

    private void tipo(){
        for(ArrayList<String> a1: archivo1){
            ArrayList<String>s1=a1;
            int cont=0;
            for(int j=0; j<s1.size();j++){
                String info=s1.get(j);
                if(info.length()==0){
                    s1.remove(j);
                    j--;
                }
                if(info.contains("├")||info.contains("└")||info.contains("│")){
                    cont++;
                    s1.remove(info);
                    j--;
                }

            }
            s1.add(""+cont);
            s1.trimToSize();
        }
        archivo1.trimToSize();
        guardaDirectorio(archivo1);
    }

    private void guardaDirectorio(ArrayList<ArrayList<String>> archivo1){
        for(ArrayList<String> a1: archivo1){
            ArrayList <String>s=a1;
            String usuario=s.get(0).substring(1);
            String memoria=s.get(1).substring(0,s.get(1).length()-1);
            String nombre="";
            String grado=s.get(s.size()-1);
            for(int j=2;j<s.size()-1;j++){
                nombre=nombre+" "+s.get(j); 
            }
            Archivo q= new Archivo(usuario,memoria,nombre,grado);
            directorio1.info.add(q);
        }
    }

    public void encuentraDirectorio(String directorio){
        boolean posee=false;
        for(int i=0; i<directorio1.info.size();i++){
            if(directorio1.info.get(i).nombre.contains(directorio)){
                posee=true;
                int k=Integer.parseInt(directorio1.info.get(i).grado);
                for(int j=i+1;j<directorio1.info.size();j++){
                    Archivo o=directorio1.info.get(j);
                    if(k<Integer.parseInt(o.grado)){
                        for(int m=1; m<=Integer.parseInt(o.grado);m++){
                            System.out.print(" ");
                        }
                        System.out.println("["+o.usuario+" "+o.tamaño+"] "+o.nombre);
                    }

                    else{
                        break;
                    }

                }
            }

        }
        if(posee==false){
            System.out.println("No such file or directory");
        }
    }
}