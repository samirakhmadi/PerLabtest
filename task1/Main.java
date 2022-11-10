package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Task1
        // Имеется круговой массив [nMas] и длина обхода [m]
        // Собираем массив-интервал [mMas]. Каждый следующий будет начинаться с последнего числа предыдущего.
        // Путь будет состоять из первых чисел полученных массив-интервалов.
        // Собираем пока не придем к первому числу кругового массива.

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        List<Integer> resultList = new ArrayList<>();
        int[] nMas = new int[n];
        boolean flag = true;
        int[] mMas = new int[m];

        int i=0;
        while (flag) {
            for (int j = 0; j < m; i++, j++) {
                if (i == n) i = 0;
                nMas[i] = i + 1;
                mMas[j] = nMas[i];
            }
            resultList.add(mMas[0]);
            i--;
            if (mMas[m - 1] == nMas[0]) {
                flag = false;
            }
        }

        for (Integer integer : resultList) {
            System.out.print(integer);
        }
    }
}
