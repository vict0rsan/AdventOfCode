package code2020;

import java.io.*;

public class day2 {

    public static void main(String[] args) {

        File archivo;
        FileReader fr;
        BufferedReader br;
        int contador = 0;
        boolean check = false; //parte 2

        try {
            archivo = new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/Archivos/contraseñasNavidad.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                check = false; //parte 2
                linea = linea.replaceAll("\\s", "");
                System.out.println(linea);
                int guion = linea.indexOf('-');
                int puntos = linea.indexOf(':');
                //System.out.println(puntos);
                int min = Integer.parseInt(linea.substring(0, guion));
                int max = Integer.parseInt(linea.substring(guion + 1, puntos - 1));
                char c = linea.charAt(puntos - 1);
                String pass = linea.substring(puntos + 1);
                int veces = 0;
                
                System.out.println("min: " + min);
                System.out.println("max : " + max);
                System.out.println("char: " + c);
                System.out.println("password: " + pass);
                System.out.println("contador = " + contador);
                System.out.println("posicion min: " + pass.charAt(min-1));
                System.out.println("posicion max: " + pass.charAt(max-1) + "\n");
                
                if((pass.charAt(min-1)==c && pass.charAt(max-1)!=c)
                   ||((pass.charAt(min-1)!=c && pass.charAt(max-1)==c))) //parte 2
                    contador++;
                
                
                
                
                //codigo parte 1

               /* for (int i = 0; i < pass.length(); i++) {
                    if (c == pass.charAt(i)) {
                        System.out.println(c+ " encontrada en posicion: " + i);
                        veces++;
                    }
                }
                if (veces >= min && veces <= max) {

                    contador++;
                }
                System.out.println("min: " + min);
                System.out.println("max : " + max);
                System.out.println("char: " + c);
                System.out.println("password: " + pass);
                System.out.println("pass.length() = " + pass.length());
                System.out.println("veces: " + veces);
                System.out.println("contador: " + contador + "\n");*/ 
            }
            System.out.println(contador);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Array index out of bounds");

        } catch (IOException e) {
            System.out.println("Ruta no encotrada");
        }

    }

}
