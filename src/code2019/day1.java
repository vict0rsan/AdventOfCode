package code2019;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class day1 {
    public static void main(String[] args) {
        
        File archivo = new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/AdventOfCode/data files/day1.txt");
        
        int sum = 0;
        int num = 0;
        int extrasum = 0;
        
        try {
            Scanner s = new Scanner(archivo);
            
            while(s.hasNext()){
                sum = 0;
                num = (s.nextInt()/3) - 2;
                
                while(num > 0){
                    extrasum += num;
                    num = num/3 - 2;
                }
                
                sum+=extrasum;
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
        
        System.out.println(sum);
        
    }
    
}
