package code2021;

import java.util.Scanner;

public class day2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day2data.txt");
        int depth = 0;
        int length = 0;

        while(reader.hasNextLine()){
            String instruction = reader.next();
            int instructionValue = reader.nextInt();

            if(instruction.equals("forward"))
               length+=instructionValue;
            else if(instruction.equals("up"))
                depth-=instructionValue;
            else if(instruction.equals("down"))
                depth+=instructionValue;
            else
                System.out.println("Wrong instruction!");
        }
        System.out.println(depth*length);
    }
}
