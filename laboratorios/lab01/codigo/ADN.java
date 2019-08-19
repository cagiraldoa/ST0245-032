public class ADN
{
    public static int encontrar(String cadenaA, String cadenaB){

        
        if(cadenaA.length() == 0 || cadenaB.length() == 0){
            return 0;

        }else if (cadenaA.charAt(cadenaA.length()-1) == cadenaB.charAt(cadenaB.length()-1)){
            return  encontrar(cadenaA.substring(0, cadenaA.length()-1), cadenaB.substring(0, cadenaB.length()-1)) + 1;
        }
        return Math.max(encontrar(cadenaA.substring(0, cadenaA.length()- 1), cadenaB), encontrar(cadenaA, cadenaB.substring(0, cadenaB.length() - 1)));

    }   
}