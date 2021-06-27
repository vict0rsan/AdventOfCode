package code2020;

import java.io.*;

public class day4_1 {

    public static void main(String[] args) {
        FileReader fr;
        BufferedReader br;

        try {
            fr = new FileReader(new File("C:/Users/VicLo/Desktop/APRENDIZAJE PROGRAMACION/Archivos/pasaportesNavidad.txt"));
            br = new BufferedReader(fr);
            int pasaportes = 0;
            String line;

            int dosPuntos = 0;
            boolean cid = false;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (line.isEmpty()) {
                    dosPuntos = 0;
                    cid = false;
                    //continue loop;
                } else {

                    if (line.contains("cid:")) {
                        cid = true;
                    }

                    System.out.println("cid: " + cid);

                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == ':') {
                            dosPuntos++;
                        }
                    }

                    System.out.println("dosPuntos: " + dosPuntos);

                    if (dosPuntos == 8) {
                        pasaportes++;
                    }

                    if (dosPuntos == 7 && cid == false) {
                        pasaportes++;
                    }

                    System.out.println("pas validos: " + pasaportes);
                }
            }

        } catch (IOException ex) {
            System.out.println("Ruta no encontrada");
        }
    }

}
