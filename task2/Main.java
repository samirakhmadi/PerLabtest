package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // 1. Прочитали файлы
        String file1Line = readFile(args[0]);
        String file2Line = readFile(args[1]);
        // 2. обработка синтаксиса строк
        String[] xy0rMas = file1Line.split("\n");
        String[] xy0Mas = xy0rMas[0].split(" ");
        float x0 = Float.parseFloat(xy0Mas[0]);
        float y0 = Float.parseFloat(xy0Mas[1]);
        float r = Float.parseFloat(xy0rMas[1]);
        String[] cordMas = file2Line.split("\n");

        // 3. Обработка и проверка каждой точки
        for (int i = 0; i < cordMas.length; i++) {
            String[] xy1Mas = cordMas[i].split(" ");

            float x1 = Float.parseFloat(xy1Mas[0]);
            float y1 = Float.parseFloat(xy1Mas[1]);
            double v = Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2);
            // 4. условия на вывод
            if (v < Math.pow(r, 2)) {
                System.out.println(i + " - точка внутри");
            } else if (v == Math.pow(r, 2)) {
                System.out.println(i + " - точка лежит на окружности");
            } else {
                System.out.println(i + " - точка снаружи");
            }
        }
    }

    public static String readFile(String path) {
        StringBuilder finishTextFromFile = new StringBuilder();
        String readableLine;
        try {
            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);
            while ((readableLine = br.readLine()) != null) {
                finishTextFromFile.append(readableLine).append("\n");
            }
            br.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return finishTextFromFile.toString();
    }
}
