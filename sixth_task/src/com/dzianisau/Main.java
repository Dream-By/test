package com.dzianisau;

import java.util.*;

public class Main {


    private Item[] items;
    private int capacity;

    public Main(Item[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public void display() {
        if (items != null  &&  items.length > 0) {
            System.out.println("Задача о рюкзаке");
            System.out.println("Грузоподъемность : " + capacity);
            System.out.println("Вещи, которые имеются в наличии :");

            for (Item item : items) {
                System.out.println("- " + item.str());
            }
        }
    }


    public Solution solve() {
        int NB_ITEMS = items.length;
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];


        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;


        for (int i = 1; i <= NB_ITEMS; i++) {

            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j)
                    matrix[i][j] = matrix[i-1][j];
                else

                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight]
                            + items[i-1].value);
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);

                res -= items[i-1].value;
                w -= items[i-1].weight;
            }
        }

        return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
    }

    public static void main(String[] args) {
        int Weight=0;
        int Count=0;

        System.out.println("Введите грузоподъемность рюкзака и нажмите Enter: ");
        Scanner scan = new Scanner(System.in);
        Weight = scan.nextInt();
        System.out.println("Введите количество вещей и нажмите Enter: ");
        Count = scan.nextInt();
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Вводим параметры вещей");
        for (int i=1; i<=Count;i++){
            System.out.println("Введите через запятую ценность и вес "+i+"-ой вещи и нажмите Enter: ");
            arrayList.add(scan.next());
            }

        Item[] items = new Item[Count];

        for (int i=0;i<Count;i++){
            String s = arrayList.get(i);
            String[] wordlist = s.split(",");
            items[i] = new Item("Вещь "+(i+1), Integer. parseInt(wordlist[0]), Integer. parseInt(wordlist[1]));
        }


        Main knapsack = new Main(items, Weight);
        knapsack.display();
        Solution solution = knapsack.solve();
        solution.display();
    }
}