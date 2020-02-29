package com.dzianisau;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double n;
        int fn;
        boolean isComposite = false;

        System.out.println("Введите целое число и нажмите Enter: ");
        Scanner scan = new Scanner(System.in);
        n = Double.parseDouble(scan.next());

            //проверяем целое ли число
            if (n % 1 == 0) {
                fn = (int) n;
                //Если число чётное, то его младший бит = 0
                if ((fn & 1) == 0) {

                    for (int i = 2; i < fn; i++) {
                        if (n % i == 0) {
                            isComposite = true;
                        }
                    }
                    if (isComposite) {
                        System.out.println(fn + " - четное составное");
                    }
                    else {
                        System.out.println(fn + " - четное простое");
                    }

                } else {
                    if (isComposite){
                        System.out.println(fn + " - нечетное составное");
                    } else {
                        System.out.println(fn + " - нечетное простое");
                    }
                    }

            } else {

            System.out.println("Сорри, но "+n + " - нецелое число");
        }

        }
}
