package code2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day6 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day6data.txt");
        String[] fishTimersString = reader.nextLine().split(",");
        List<Integer> fishTimerValues = getTimerValues(fishTimersString);

        int currentDay = 0;

        do {
            int extraTimers = 0;
            for (int i = 0; i < fishTimerValues.size(); i++) {
                int currentValue = fishTimerValues.get(i);

                if (currentValue > 0) {
                    fishTimerValues.set(i, --currentValue);
                } else {
                    extraTimers++;
                    fishTimerValues.set(i, 6);
                }
            }

            for (int j = 0; j < extraTimers; j++)
                fishTimerValues.add(8);

            currentDay++;
            System.out.println("After " + currentDay + " days: " + fishTimerValues);
        } while (currentDay < 18);

        System.out.println(fishTimerValues.size());
    }

    public static ArrayList<Integer> getTimerValues(String[] fishTimerString) {
        ArrayList<Integer> timerValues = new ArrayList<>();
        for (String timerString : fishTimerString)
            timerValues.add(Integer.parseInt(timerString));
        return timerValues;
    }
}
