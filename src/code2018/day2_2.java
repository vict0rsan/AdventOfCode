package code2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2_2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2018/data/day2data.txt");
        List<StringBuilder> ids = getIDs(reader);
        String matchingChars = null;
        boolean matchingFound = false;

        for(int i = 0; i < ids.size(); i++){

            for(int charToBeRemoved = 0; charToBeRemoved<5; charToBeRemoved++) {

                StringBuilder data = new StringBuilder(ids.get(i));
                String id = data.deleteCharAt(charToBeRemoved).toString();

                for (int j = i + 1; j < ids.size(); j++) {

                    StringBuilder data2 = new StringBuilder(ids.get(j));
                    String id2 = data2.deleteCharAt(charToBeRemoved).toString();

                    if (id.equals(id2)) {
                        matchingChars = id;
                        matchingFound = true;
                        break;
                    }
                }

                if (matchingFound)
                    break;

                ids = getIDs(Utility.readDataFrom("src/code2018/data/day2data.txt"));
            }
        }

        System.out.println(matchingChars);

    }

    public static List<StringBuilder> getIDs(Scanner reader){
        List <StringBuilder> ids = new ArrayList<>();

        while(reader.hasNextLine())
            ids.add(new StringBuilder(reader.nextLine()));

        return ids;
    }
}
