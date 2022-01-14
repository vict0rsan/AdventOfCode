package code2018;

import java.util.Scanner;

public class day1 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2018/data/day1data.txt");
        int frequency = 0;

        while(reader.hasNextLine()){
            String data = reader.nextLine();
            frequency += makeOperation(data);
        }

        System.out.println(frequency);
    }

    public static int makeOperation(String data){
        char sign = data.charAt(0);
        int value = Integer.parseInt(data.substring(1));

        if(sign=='+')
            return value;
        else
            return -value;
    }
}
