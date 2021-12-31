package code2021;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class day1 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day1data.txt");
        int counter = 0;
        int previousData = Integer.parseInt(reader.next());

        while(reader.hasNext()){
            int currentData = Integer.parseInt(reader.next());
            if(currentData > previousData)
                counter++;
            previousData = currentData;
        }
        System.out.println(counter);
    }
}
