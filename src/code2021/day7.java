package code2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day7 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day7data.txt");
        List<Integer> positions = processPositions(reader);

        int minFuelNecessary = Integer.MAX_VALUE;

        for(Integer currentPos : positions){
            int currentPosFuel = 0;
            for(Integer comparingPos: positions){
                currentPosFuel += Math.abs(currentPos-comparingPos);
            }
            minFuelNecessary = Math.min(minFuelNecessary, currentPosFuel);
        }
        System.out.println(minFuelNecessary);

    }

    public static ArrayList<Integer> processPositions(Scanner reader){
        ArrayList<Integer> positions = new ArrayList<>();
        String [] data = reader.nextLine().split(",");
        for(String value : data)
            positions.add(Integer.parseInt(value));
        return positions;

    }
}
