package code2021;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day5 {

    public static void main(String[] args) {

        Scanner reader = Utility.readDataFrom("src/code2021/data/day5data.txt");
        int[][] diagram = new int[1000][1000];
        List<Line> lines = processData(reader);
        lines.forEach(l -> l.representLine(diagram));

        int overlappingLines = 0;
        for (int[] i : diagram) {
            for (int j : i) {
                System.out.print(j + "");
                if (j > 1)
                    overlappingLines++;
            }
            System.out.println();
        }
        System.out.println(overlappingLines);
    }

    public static ArrayList<Line> processData(Scanner reader) {
        ArrayList<Line> processedData = new ArrayList<>();

        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            String[] data = currentLine.split(" -> ");
            String[] start = data[0].split(",");
            String[] end = data[1].split(",");

            if (Integer.parseInt(start[0]) == Integer.parseInt(end[0]) || Integer.parseInt(start[1]) == Integer.parseInt(end[1]))
                processedData.add(new Line(start, end));
        }

        return processedData;
    }

    static class Line {
        Point start;
        Point end;

        public Line(String[] start, String[] end) {
            this.start = new Point(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            this.end = new Point(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
        }

        public void representLine(int[][] diagram) {

            int startX = (int) this.start.getX();
            int endX = (int) this.end.getX();
            int startY = (int) this.start.getY();
            int endY = (int) this.end.getY();

            if (this.isHorizontal()) {
                if (startX <= endX) {
                    for (int i = startX; i <= endX; i++)
                        diagram[startY][i]++;
                } else {
                    for (int i = startX; i >= endX; i--)
                        diagram[startY][i]++;
                }
            } else {
                if (startY <= endY) {
                    for (int i = startY; i <= endY; i++)
                        diagram[i][startX]++;
                } else {
                    for (int i = startY; i >= endY; i--)
                        diagram[i][startX]++;
                }
            }
        }

        public boolean isHorizontal() {
            return this.start.getY() == this.end.getY();
        }
    }
}
