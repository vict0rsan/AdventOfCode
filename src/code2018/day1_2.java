package code2018;

import java.util.*;

public class day1_2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2018/data/day1data.txt");
        Set<Integer> frequencies = new HashSet<>();

        int frequency = 0;

        while (true) {

            if (reader.hasNextLine()) {
                String data = reader.nextLine();
                frequency += makeOperation(data);

                if (!frequencies.contains(frequency))
                    frequencies.add(frequency);
                else
                    break;
            } else
                reader = Utility.readDataFrom("src/code2018/data/day1data.txt");
        }

        System.out.println(frequency);
    }

    public static int makeOperation(String data) {
        char sign = data.charAt(0);
        int value = Integer.parseInt(data.substring(1));

        if (sign == '+')
            return value;
        else
            return -value;
    }
}
