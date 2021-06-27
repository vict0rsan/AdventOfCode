package code2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class day2 {

    public static void main(String[] args) { //falta la segunda parte, no entiendo bien el enunciado

        File archivo = new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/AdventOfCode/data files/day2.txt");

        String texto = "";
        String [] vector;
        int [] array = new int [150];

        try {
            Scanner s = new Scanner(archivo);

            while (s.hasNext()) {
                texto += s.next();
            }
            
        vector = texto.split(",");
        
        for(int i = 0; i < vector.length; i++){
            array[i] = Integer.parseInt(vector[i]);
        }
           
            

        } catch (FileNotFoundException ex) {
            System.out.println("ERROR DE LECTURA");
        }

        for(int i = 0; i < array.length; i=i+4){
            
            int res = 0;
            int num1;
            int num2;
            int pos;
            
            if(array[i]==1){
                num1 = array[i+1];
                num2 = array[i+2];
                pos = array[i+3];
                res = array[num1]+array[num2];
                if(res == 19690720){
                   //System.out.println("num1: " + num1);
                    //System.out.println("num2: " + num2);
                    break;
                }
                array[pos] = res;
            }
            else if(array[i] == 2){
                 num1 = array[i+1];
                num2 = array[i+2];
                pos = array[i+3];
                res = array[num1]*array[num2];
                if(res == 19690720){
                    //System.out.println("num1: " + num1);
                    //System.out.println("num2: " + num2);
                    break;
                }
                array[pos] = res;
            }
            else 
                break;
              
        }
        
        
        
        for(int i : array){
            System.out.println(i);
        }
    }

}
