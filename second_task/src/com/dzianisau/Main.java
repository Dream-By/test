package com.dzianisau;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите два числа через пробел и нажмите Enter: ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            int A = sc.nextInt();
            if (sc.hasNextInt()){
                int B = sc.nextInt();

                if (A < 46340 && B < 46340) {
                    System.out.print("Наименьшее общее кратное двух чисел - "+nok(A, B)+"\n");
                    System.out.println("Наибольший общий делитель двух чисел - "+nod(A,B));
                }
                else {
                    System.out.println("Значения больше допустимых");
                }

            } System.out.println("Введены некорректные данные!");
        }

        else
        {
            System.out.println("Введены некорректные данные!");
        }

    }
    static int nod (int x, int y){ //  находиим наибольший общий делитель
        int tmp = x%y;
        x=y;
        y=tmp;
        if (tmp>0){
            return nod (x,y);
        }
        else {
            return x;
        }
    }
    static int nok (int x, int y){// находим наименьшее общее кратное чисел
        return x*(y/nod(x,y));
    }
}



