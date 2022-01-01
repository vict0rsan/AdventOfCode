package code2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class day3_2 {
    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day3data.txt");
        List<HashMap<Character, Integer>> data = new ArrayList<>();

        for (int i = 0; i < 12; i++)
            data.add(new HashMap<>());

        while (reader.hasNextLine()) {
            String bits = reader.next();

            for (int i = 0; i < bits.length(); i++) {
                char currentChar = bits.charAt(i);
                data.get(i).put(currentChar, data.get(i).getOrDefault(currentChar, 0) + 1);
            }
        }

        String gammaRate = "";
        String epsilonRate = "";

        for (int i = 0; i < data.size(); i++) {
            int onesFrequency = data.get(i).get('1');
            int zerosFrequency = data.get(i).get('0');

            if (onesFrequency >= zerosFrequency) {
                gammaRate += '1';
                epsilonRate += '0';
            } else {
                gammaRate += '0';
                epsilonRate += '1';
            }
        }
        int gammaValue = Integer.parseInt(gammaRate, 2);
        int epsilonValue = Integer.parseInt(epsilonRate, 2);
        System.out.println(gammaValue * epsilonValue);
    }

}
