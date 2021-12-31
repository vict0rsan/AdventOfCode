package code2021;

import java.util.Scanner;

public class day1_2 {
    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day1data.txt");
        int counter = 0;
        int firstElement = Integer.parseInt(reader.next());
        int secondElement = Integer.parseInt(reader.next());
        int thirdElement = Integer.parseInt(reader.next());
        int previousSum = firstElement + secondElement + thirdElement;

        while (reader.hasNext()) {
            firstElement = secondElement;
            secondElement = thirdElement;
            thirdElement = Integer.parseInt(reader.next());
            int currentSum = firstElement + secondElement + thirdElement;

            if(currentSum > previousSum)
                counter++;

            previousSum = currentSum;
        }
        System.out.println(counter);
    }
}
