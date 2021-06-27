
package code2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class day3_2 {
     public static void main(String[] args) {
        File f;
        FileReader fr;
        BufferedReader br;

        try {
            f = new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/Archivos/arbolesNavidad.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            int arboles = 0;

            char[][] map = new char[323][31];

            for (int i = 0; i < map.length; i++) {
                String linea = br.readLine();
                char[] chars = linea.toCharArray();
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = chars[j];
                }
            }

            int j = 0;

            for (int i = 0; i < map.length; i=i+2) { //repetir eso para los numeros pedidos y despues multiplicar
                System.out.println("i:" + i + " j:" + j);
                if (map[i][j] == '#') {
                    arboles++;
                }

                System.out.println("arboles: " + arboles);
                j = (j + 1) % 31;

            }

            printMatrix(map);
            System.out.println("arboles: " + arboles);

        } catch (IOException e) {
            System.out.println("Ruta no encontrada");
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4c", matrix[row][col]);
            }
            System.out.println();
        }
    }
    
}
