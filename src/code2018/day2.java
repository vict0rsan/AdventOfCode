package code2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2018/data/day2data.txt");

        Integer twoExactLettersCounter = 0;
        Integer threeExactLettersCounter = 0;

        while (reader.hasNextLine()){
            String data = reader.nextLine();
            int[] counters = checkCharsAndComputeCounters(data);
            twoExactLettersCounter += counters[0];
            threeExactLettersCounter += counters[1];
        }
        System.out.println(twoExactLettersCounter*threeExactLettersCounter);
    }

    public static int[] checkCharsAndComputeCounters(String data){
        Set<Character> seen = new HashSet<>();
        int threeExactLettersCounter = 0;
        int twoExactLettersCounter = 0;
        for(int i = 0; i < data.length(); i++){
            int counter = 1;

            if(seen.contains(data.charAt(i)))
                continue;

            seen.add(data.charAt(i));
            for(int j = i + 1; j < data.length(); j++ ){
                if(data.charAt(i) == data.charAt(j))
                    counter++;
            }
            if(counter == 2 && twoExactLettersCounter == 0)
                twoExactLettersCounter++;
            else if(counter == 3 && threeExactLettersCounter == 0)
                threeExactLettersCounter++;
        }
        return new int[]{twoExactLettersCounter,threeExactLettersCounter};
    }
}
