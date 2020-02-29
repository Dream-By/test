package com.dzianisau;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите строку и нажмите Enter:");

        //создаем сканер
        Scanner scan = new Scanner(System.in);

        //передаем строку из сканера в переменную
        String name = scan.nextLine();

        //избавляем текст от знаков препинания
        name = name.replace(".","").replace("-", "").replace("!", "").replace(":", "").replace("?", "");

        //создаем новый мап в виде строкового массива
        Map<Integer, ArrayList<String>> counter = new HashMap<>();

        //определяем строковый массив слов в строке с разделителем пробел " "
        String[] wordlist = name.split(" ");

        //выводим информацию в консоль
        System.out.println("Количество слов в предложении - "+wordlist.length);

        //выводим информацию в консоль
        System.out.println("Сортировка слов по количеству символов:");

        //запускаем цикл сортировки слов в массиве по количеству символов
        for (int i=0; i < wordlist.length;i++){
            String s = wordlist[i];

            //здесь делаем первую букву заглавной
            String stemp = s.substring(0,1).toUpperCase()+s.substring(1);
            s = stemp;

            Integer key = s.length();

            //организовываем сравнение по длине слов
            if (counter.containsKey(key)){
                counter.get(key).add(s);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(s);
                counter.put(key,al);
            }
        }

        //выводим информацию в консоль
        for (Integer key: counter.keySet()){
            System.out.println(String.join(", ", counter.get(key)));
        }

        }
}
