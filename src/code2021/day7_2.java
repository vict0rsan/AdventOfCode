package code2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day7_2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day7data.txt");
        List<Integer> positions = processPositions(reader);

        int minValue = Collections.min(positions);
        int maxValue = Collections.max(positions);

        long minFuelNeeded = Long.MAX_VALUE;

        for (int comparingPos = minValue; comparingPos <= maxValue; comparingPos++) {
            int currentPosFuel = 0;

            for (Integer currentPos : positions) {
                int distance = Math.abs(currentPos - comparingPos);

                for (int i = 1; i <= distance; i++)
                    currentPosFuel += i;
            }
            minFuelNeeded = Math.min(minFuelNeeded, currentPosFuel);
        }
        System.out.println(minFuelNeeded);
    }

    public static ArrayList<Integer> processPositions(Scanner reader) {
        ArrayList<Integer> positions = new ArrayList<>();
        String[] data = reader.nextLine().split(",");
        for (String value : data)
            positions.add(Integer.parseInt(value));
        return positions;
    }
}
