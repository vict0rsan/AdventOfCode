package code2021;

import java.util.*;

public class day4_2 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day4data.txt");
        String[] bingoNumbers = getBingoNumbers(reader);
        List<BingoBoard> bingoBoards = fillBoards(reader);

        String[][] winnerBoard = null;
        String numberWinner = null;
        boolean winnerFound = false;

        for (String number : bingoNumbers) {

            for (BingoBoard bingoBoardss : bingoBoards) {
                String[][] bingoBoard = bingoBoardss.bingoBoard;

                if (bingoBoardss.winnerBoard == false) {
                    markBoard(number, bingoBoard);
                    winnerFound = checkWinRow(bingoBoard) || checkWinColumn(bingoBoard);
                    bingoBoardss.winnerBoard = winnerFound;

                    if (winnerFound) {
                        winnerBoard = bingoBoard;
                        numberWinner = number;
                    }
                }
            }
        }

        for (String[] res : winnerBoard) {
            for (String s : res) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println(numberWinner + "\n");

        int unmarkedNumbersSum = 0;
        for (String[] res : winnerBoard) {
            for (String s : res) {
                if (s != null)
                    unmarkedNumbersSum += Integer.parseInt(s);
            }
        }
        System.out.println(Integer.parseInt(numberWinner) * unmarkedNumbersSum);
    }

    public static void markBoard(String bingoNumber, String[][] bingoBoard) {
        for (String[] boardRow : bingoBoard) {
            for (int i = 0; i < bingoBoard.length; i++) {
                if (bingoNumber.equals(boardRow[i]))
                    boardRow[i] = null;
            }
        }
    }

    public static boolean checkWinRow(String[][] bingoBoard) {
        for (String[] row : bingoBoard) {
            boolean winnerRow = Arrays.stream(row).allMatch(Objects::isNull);

            if (winnerRow)
                return true;
        }
        return false;
    }

    public static boolean checkWinColumn(String[][] bingoBoard) {
        for (int i = 0; i < bingoBoard[0].length; i++) {
            if (bingoBoard[0][i] == bingoBoard[1][i] &&
                    bingoBoard[1][i] == bingoBoard[2][i] &&
                    bingoBoard[2][i] == bingoBoard[3][i] &&
                    bingoBoard[3][i] == bingoBoard[4][i])
                return true;
        }
        return false;
    }

    public static String[] getBingoNumbers(Scanner reader) {
        String bingoNumbers = reader.nextLine();
        return bingoNumbers.split(",");
    }

    public static ArrayList<BingoBoard> fillBoards(Scanner reader) {
        reader.nextLine();
        ArrayList<BingoBoard> bingoBoards = new ArrayList<>();
        bingoBoards.add(new BingoBoard(new String[5][5]));
        int currentBoard = 0;
        int row = 0;

        while (reader.hasNextLine()) {

            String currentRow = reader.nextLine();

            if (currentRow.isEmpty()) {
                row = 0;
                currentBoard++;

                if (reader.hasNextLine())
                    bingoBoards.add(new BingoBoard(new String[5][5]));

                continue;
            }
            currentRow = currentRow.replaceAll("  ", " ").trim();
            String[] currentRowNumbers = currentRow.split(" ");
            bingoBoards.get(currentBoard).bingoBoard[row] = currentRowNumbers;
            row++;
        }
        return bingoBoards;
    }


    static class BingoBoard {
        String[][] bingoBoard;
        boolean winnerBoard;

        public BingoBoard(String[][] bingoBoard) {
            this.bingoBoard = bingoBoard;
        }
    }
}
