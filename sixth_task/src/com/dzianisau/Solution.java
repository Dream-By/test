package com.dzianisau;

import java.util.List;

public class Solution {

    public List<Item> items;
    public int value;

    public Solution(List<Item> items, int value) {
        this.items = items;
        this.value = value;
    }

    public void display() {
        if (items != null  &&  !items.isEmpty()){
            System.out.println("\n Решение задачи о рюкзаке:-)");
            System.out.println("Максимальная ценность (Жадный Алгоритм) = " + value);
            System.out.println("Вещи, которые берем :");

            for (Item item : items) {
                System.out.println("- " + item.str());
            }
        }
    }

}
