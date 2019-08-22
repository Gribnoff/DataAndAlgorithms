package lesson5.backpack;

import java.util.HashSet;
import java.util.Set;

public class Backpack {
    private final int capacity;
    private int overallCost;
    private int loadedWeight;
    private Set<Item> content;

    public Backpack(int capacity) {
        this.capacity = capacity;
        content = new HashSet<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLoadedWeight() {
        return loadedWeight;
    }

    public int getOverallCost() {
        return overallCost;
    }

    public Set<Item> getContent() {
        return content;
    }

    public void put(Item item) {
        content.add(item);
    }

    public void pack(Set<Item> items) {
        checkVariants(items);

        showContent();
    }

    private void checkVariants(Set<Item> items) {
        if (items.size() > 0)
            checkSet(items);

        for (Item item : items) {
            Set<Item> newSet = new HashSet<>(items);
            newSet.remove(item);

            checkVariants(newSet);
        }
    }

    private void checkSet(Set<Item> items) {
        if (getItemsWeight(items) <= capacity && getItemsCost(items) > overallCost) {
            content = items;
            overallCost = getItemsCost(items);
            loadedWeight = getItemsWeight(items);
        }
    }

    private static int getItemsCost(Set<Item> items) {
        int itemsCost = 0;

        for (Item item : items) {
            itemsCost += item.getCost();
        }

        return itemsCost;
    }

    private static int getItemsWeight(Set<Item> items) {
        int itemsWeight = 0;

        for (Item item : items) {
            itemsWeight += item.getWeight();
        }

        return itemsWeight;
    }

    public void showContent() {
        if (content.isEmpty())
            System.out.println("Рюкзак слишком маленький, в него ничего не влезает!");
        else {
            System.out.printf("В рюкзаке(на %dкг):\n", capacity);
            for (Item item : content) {
                System.out.println(item);
            }
            System.out.printf("Всего в рюкзаке %d вещей на %dкг общей стоимостью %dруб\n", content.size(), loadedWeight, overallCost);
        }
    }
}
