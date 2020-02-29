package com.dzianisau;

import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //организация ввода произвольного текста
        System.out.println("Введите произвольный текст и нажмите Enter:");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();


        //вводим искомое слово
        System.out.println("Введите искомое слово для поиска и нажмите Enter:");
        String fword = scan.nextLine();

        //фиксируем для вывода наше слово без изменения регистра
        String word = fword;

        //создаем объект Map
        Map<Integer, ArrayList<String>> counter = new HashMap<>();

        //избавляем текст от знаков препинания, приводим  к одному регистру весь текст и искомое слово, и "забрасываем" текст в массив, разбивая по словам, разделитель "пробел"
        text = text.replace(".","").replace("-", "").replace("!", "").replace(":", "").replace("?", "").toLowerCase();
        fword = fword.toLowerCase();

        String[] wordlist = text.split(" ");

        //запускаем цикл по сравнению слов в тексте на предмет повтора
        int count=0;
        for (int i=0;i < wordlist.length; i++){
            if (fword.equals(wordlist[i])){
            count++;
        }
        }

        if (count !=0) {
            System.out.println("Искомое слово '" +word+ "' " + "повторяется в исходном тексте " +count+ " раз(а)");
        } else {
            System.out.println("Искомое слово не найдено");
        }



    }
}
