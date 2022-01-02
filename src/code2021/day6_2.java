package code2021;

import java.util.*;

public class day6_2 {

    public static void main(String[] args) {
        Scanner reader = Utility.readDataFrom("src/code2021/data/day6data.txt");
        String[] fishTimersString = reader.nextLine().split(",");
        System.out.println(growthPrediction(fishTimersString, 256));
    }

    public static long growthPrediction(String[] fisherTimersString, int atDay) {
        long[] fish = new long[10];

        for (String s : fisherTimersString)
            fish[Integer.parseInt(s)]++;

        for (int day = 0; day < atDay; day++) {
            fish[7] += fish[0];
            fish[9] = fish[0];

            for (int i = 0; i < 9; i++)
                fish[i] = fish[i + 1];

            fish[9] = 0;
        }
        return Arrays.stream(fish).sum();
    }

}
