package com.dzianisau;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

        //Метод для разделения строки на отдельные числа
        public static String[] separation(String numbers) {

            //Создаем обьект типа StringTokenizer, со знаками разделения "," и "_"
            StringTokenizer num = new StringTokenizer(numbers, ", ");

            //Подсчитываем к-во чисел для создания массива
            int count = num.countTokens();
            if (count>100) {
                System.out.println("Последовательность чисел превысила 100");
            }

            //Создаем массив
            String[] numText = new String[count];

            //Заполняем массив числами
            for (int i=0; i<numText.length; i++) {
                numText[i] = num.nextToken();
            }
            return numText;
        }

        //Метод для вывода на консоль палиндрома
        public static void toCheckPalindrom(String[] nums) {

            for (int i=0; i<nums.length; i++) {
                try {
                    //Пытаемся привести строковое значение к целочисленному
                    int a = Integer.parseInt(nums[i]);

                    //Если получается, проверяем является ли число палиндромом
                    if (checkNumbers(a)) {
                        System.out.println("Число "+a+" является палиндромом");
                    }
                } catch (NumberFormatException e) {

                    //В случае если строку нельзя привести к целочисленному значению
                    //проверяем можно ли ее привести к вещественному
                    try {
                        double b = Double.parseDouble(nums[i]);

                        //Если получается, проверяем является ли число палиндромом
                        if (checkNumbers(b)) {
                            System.out.println("Число "+b+" является палиндромом");
                        }

                        //Если нет, тогда в строке текст
                    } catch (NumberFormatException f) {
                        System.out.println("Введенное вами выражение '"+nums[i]+
                                "' не является целым или вещественным числом");
                    }
                }
            }
        }

        //Метод который, в общем то, проверяет является ли целое
        //или вещественное число палиндромом
        public static boolean checkNumbers(int num) {
            char[] x = String.valueOf(num).toCharArray();
            boolean check = true;
            for (int i=0, j=x.length-1; i < x.length; i++, j--) {
                if (x[i] == x[j]) {
                    check = true;
                } else {
                    return false;
                }
            }
            return check;
        }

        //Перегружаем метод для проверки вещественных чисел
        public static boolean checkNumbers(double num) {
            char[] x = String.valueOf(num).toCharArray();
            boolean check = true;
            for (int i=0, j=x.length-1; i < x.length; i++, j--) {
                if (x[i] == x[j]) {
                    check = true;
                } else {
                    return false;
                }
            }
            return check;
        }

    private static boolean isPalindrome(String src) {
        src = src.replaceAll("[\\s]", "").toLowerCase();
        boolean result = true;
        for (int i = 0; i < src.length() / 2; i++) {
            if (src.charAt(i) != src.charAt(src.length() - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Введите необходимое количество чисел, не более 100 элементов");
        System.out.println("Введите все числа в одну строку разделяя запятой");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        String[] a = separation(numbers);
        toCheckPalindrom(a);


    }
}
