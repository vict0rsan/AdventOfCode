package code2020;
import java.io.*;
import java.util.*;

public class day6_1 {
    public static void main(String[] args) {
        File archivo = new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/Archivos/day6input2020.txt");
        int sumaTotal = 0;
        
        
        try{
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String line;
        
        loop:
        while(true){
            
            System.out.println("\n");
            int sumaLocal = 0;
            int sumaLocalAux = 0;
            ArrayList<Character> check = new ArrayList();
            
            while((line = br.readLine())!=null){
                if(line.isEmpty())
                    continue loop;
                
                
                String line2 = line.trim();
                System.out.println(line2);
                
                for(int i = 0; i < line2.length(); i++){
                    if(!check.contains(line2.charAt(i))){
                        check.add(line2.charAt(i));
                        sumaLocal++;
                    }
                }
                
                System.out.println("Este grupo: " + sumaLocal);
                    if(sumaLocal>sumaLocalAux)
                        sumaTotal = sumaTotal + (sumaLocal-sumaLocalAux);
                
                
                    sumaLocalAux = sumaLocal;
                System.out.println("Suma total = " + sumaTotal);
               
                
            }
            break;
            
        }
            System.out.println("sumaTotal = " + sumaTotal);
        
        
        
        
        
        
        
        
        
        
        
        
        
        }catch(IOException e){
            System.out.println("Ruta no encontrada");
        }
        
    }
            
    
}
