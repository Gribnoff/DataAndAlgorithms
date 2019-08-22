package lesson5.backpack;

import java.util.HashSet;
import java.util.Set;

public class PackMain {
    public static void main(String[] args) {
        Backpack myBackpack = new Backpack(50);
        Set<Item> items = new HashSet<>();
        System.out.println("Выбираем из следующих вещей:");
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            System.out.println(item);
            items.add(item);
        }

        myBackpack.pack(items);
    }
}
