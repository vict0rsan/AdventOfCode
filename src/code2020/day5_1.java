package code2020;
import java.io.*;
import java.util.*;


public class day5_1 {
    public static void main(String[] args) {
        
        
        try{
        
        File archivo = new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/Archivos/day5.1input2020.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int BigID = 0;
        HashMap <Integer, Integer> rows = new HashMap();
            HashMap <Integer, Integer> columns = new HashMap();
            List<Integer> list = new ArrayList();
        
        while((line = br.readLine())!=null){
            
            
            int rowsHi = 127;
            int rowsLo = 0;
            int columnsHi = 7;
            int columnsLo = 0;
            int row;
            int column;
            
            for(int i = 0; i < line.length()-4; i++){
                if(line.charAt(i) == 'F'){
                    rowsHi = rowsHi - (rowsHi-rowsLo)/2;
                    System.out.println("rowsHi = " + rowsHi);
                    
                }else if(line.charAt(i) == 'B'){
                    rowsLo = rowsLo+(rowsHi-rowsLo)/2;
                    System.out.println("rowsLo = " + rowsLo);
                }
            }
            row = (line.charAt(6)=='F')?rowsLo:rowsHi;
            rows.put(row, 1);
            System.out.println("row = " + row);
            
            String c = line.substring(7);
            
            
            for(int j = 0; j < c.length(); j++){
                if(c.charAt(j) == 'L'){
                    columnsHi = columnsHi - (columnsHi-columnsLo)/2;
                    System.out.println("columnsHi = " + columnsHi);
                    
                }else if(c.charAt(j) == 'R'){
                    columnsLo = columnsLo+(columnsHi-columnsLo)/2;
                    System.out.println("columnsLo = " + columnsLo);
                }
            }
            column = (c.charAt(2)=='L')?columnsLo:columnsHi;
            columns.put(column, 1);
            System.out.println("columns = " + column);
            
            int id = row*8+column;
            list.add(id);
            
            if(id>BigID){
                BigID = id;
            }
            System.out.println(" ");
        }
        
        for(int i : list){
            System.out.println(i);
        }
            System.out.println(BigID);
            
            //falta segunda parte
            
            
            
        
        
        
        
        }catch(IOException ex){
            System.out.println("Ruta no encontrada");
        }
        
        
    }
    
}
