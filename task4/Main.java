package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    // нужно найти мин кол-во ходов требуемых для приведения всех элементов к одному числу
    // За один ход можно уменьшить или увеличить число массива на 1

    public static void main(String[] args) {
        String fileLine = readFile(args[0]);
        String[] numsString = fileLine.split("\n");
        int[] nums = new int[numsString.length];
        for (int i = 0; i < numsString.length; i++) {
            nums[i] = Integer.parseInt(numsString[i]);
        }

        // как найти среднее число?
        // мы можем отсортировать массив и взять среднее, так и сделаю
        Arrays.sort(nums);
        System.out.println(superMethod(nums[nums.length / 2 - 1], nums));

        /*// если мы длину массива поделим на 2 и,
        // если его длина = четному числу, то проверяем 2 серединных значения
        // иначе просто работаем с серединным значением
        if (nums.length % 2 == 0) {
            int[] nums1 = Arrays.copyOf(nums, nums.length);
            // если длина = четному числу
            // проверяем оба срединных элемента массива на количество ходов и выводим наименьшее
            int count = superMethod(nums[nums.length / 2 - 1], nums);
            int count1 = superMethod(nums1[nums1.length / 2], nums1);
            if (count <= count1) System.out.println(count);
            else System.out.println(count1);
//            System.out.println(Math.min(count, count1));
        } else System.out.println(superMethod(nums[nums.length / 2 - 1], nums));*/ // значения все равно дает одинаковые
    }

    public static int superMethod(int avg, int[] nums) {
        int count = 0;
        int oldi = 0;
        while (nums[nums.length - 1] != avg) {
            for (int i = oldi; i < nums.length; i++) {
                if (nums[i] < avg) {
                    nums[i]++;
                    count++;
                    oldi = i;
                    break;
                } else if (nums[i] > avg) {
                    nums[i]--;
                    count++;
                    oldi = i;
                    break;
                }
            }
        }
        return count;
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
