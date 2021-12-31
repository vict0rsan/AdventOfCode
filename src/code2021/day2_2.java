package code2021;

import java.util.Scanner;

public class day2_2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day2data.txt");
        int depth = 0;
        int length = 0;
        int aim = 0;

        while(reader.hasNextLine()){
            String instruction = reader.next();
            int instructionValue = reader.nextInt();

            if(instruction.equals("forward")) {
                length += instructionValue;
                depth+=aim*instructionValue;
            }
            else if(instruction.equals("up"))
                aim-=instructionValue;
            else if(instruction.equals("down"))
                aim+=instructionValue;
            else
                System.out.println("Wrong instruction!");
        }
        System.out.println(depth*length);
    }
}
