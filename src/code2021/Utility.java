package code2021;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Utility {

    public static Scanner readDataFrom(String pathName){
        Scanner read = null;

        try {
            File file = new File(pathName);
            read = new Scanner(file);
        } catch (IOException e){
            System.out.println("Error reading the data!");
        }

        return read;
    }
}
