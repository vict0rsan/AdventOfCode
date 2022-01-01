package code2021;

import java.util.*;

public class day3 {

    public static void main(String[] args) {

        Set<Integer> linesErased = new HashSet<>();
        int currentBit = 0;
        String oxygen = "";

        while (linesErased.size() < 999) {

            List<Integer> dataWithCurrentBitOne = new ArrayList<>();
            List<Integer> dataWithCurrentBitZero = new ArrayList<>();
            Scanner reader = Utility.readDataFrom("src/code2021/data/day3data.txt");
            List<HashMap<Character, Integer>> data = new ArrayList<>();


            int currentLine = 1;

            for (int i = 0; i < 12; i++)
                data.add(new HashMap<>());

            while (reader.hasNextLine()) {
                String bits = reader.next();

                if (!linesErased.contains(currentLine)) {
                    char currentChar = bits.charAt(currentBit);

                    if (currentChar == '1')
                        dataWithCurrentBitOne.add(currentLine);
                    else
                        dataWithCurrentBitZero.add(currentLine);

                    data.get(currentBit).put(currentChar, data.get(currentBit).getOrDefault(currentChar, 0) + 1);
                    System.out.println("Adding a: " + currentChar + " in line: " + currentLine);
                    oxygen = bits;
                }
                currentLine++;
            }

            int onesFrequency = data.get(currentBit).get('1');
            int zerosFrequency = data.get(currentBit).get('0');

            if (onesFrequency >= zerosFrequency) {
                for (Integer line : dataWithCurrentBitZero)
                    linesErased.add(line);
            } else {
                for (Integer line : dataWithCurrentBitOne)
                    linesErased.add(line);
            }

            currentBit++;
        }

        currentBit = 0;
        String C02 = "";
        linesErased.clear();

        while (linesErased.size() < 999) {

            List<Integer> dataWithCurrentBitOne = new ArrayList<>();
            List<Integer> dataWithCurrentBitZero = new ArrayList<>();
            Scanner reader = Utility.readDataFrom("src/code2021/data/day3data.txt");
            List<HashMap<Character, Integer>> data = new ArrayList<>();

            int currentLine = 1;

            for (int i = 0; i < 12; i++)
                data.add(new HashMap<>());

            while (reader.hasNextLine()) {
                String bits = reader.next();

                if (!linesErased.contains(currentLine)) {
                    char currentChar = bits.charAt(currentBit);

                    if (currentChar == '1')
                        dataWithCurrentBitOne.add(currentLine);
                    else
                        dataWithCurrentBitZero.add(currentLine);

                    data.get(currentBit).put(currentChar, data.get(currentBit).getOrDefault(currentChar, 0) + 1);
                    System.out.println("Adding a: " + currentChar + " in line: " + currentLine);
                    C02 = bits;
                }
                currentLine++;
            }

            int onesFrequency = data.get(currentBit).get('1');
            int zerosFrequency = data.get(currentBit).get('0');

            if (onesFrequency >= zerosFrequency) {
                for (Integer line : dataWithCurrentBitOne)
                    linesErased.add(line);
            } else {
                for (Integer line : dataWithCurrentBitZero)
                    linesErased.add(line);
            }

            currentBit++;
        }
        int oxygenValue = Integer.parseInt(oxygen, 2);
        int C02Value = Integer.parseInt(C02, 2);
        System.out.println(oxygenValue * C02Value);
    }
}
