package lesson2;

import java.util.Random;

@SuppressWarnings("unchecked")
class Solution {
    private static final int CAPACITY = 1_000_000;

    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>(CAPACITY);
        MyArrayList<Integer> list2 = new MyArrayList<>(CAPACITY);
        MyArrayList<Integer> list3 = new MyArrayList<>(CAPACITY);

        listInit(list1, list2, list3);

        System.out.println("Sorting started...");

        new Thread(timer(list1::sortBubble, "bubble sort")).start();
        new Thread(timer(list2::sortSelect, "select sort")).start();
        new Thread(timer(list3::sortInsert, "insert sort")).start();
    }

    private static void listInit(MyList<Integer>... lists) {
        System.out.println("Lists filling started...");
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < CAPACITY; i++) {
            int value = random.nextInt(CAPACITY);

            for (MyList<Integer> list : lists) {
                list.add(value);
            }
        }
        System.out.println("Lists are full!");
    }

    private static Runnable timer(Runnable action, String name) {
        return () -> {
            long start = System.currentTimeMillis();
            action.run();
            System.out.printf("%s: %d ms\n", name, System.currentTimeMillis() - start);
        };
    }
}
