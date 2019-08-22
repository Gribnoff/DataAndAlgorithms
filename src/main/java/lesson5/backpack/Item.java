package lesson5.backpack;

public class Item {
    private static int itemsCount;
    private final String name;
    private final int weight;
    private final int cost;

    public Item() {
        itemsCount++;
        this.name = "item #" + itemsCount;
        this.weight = (int) (Math.random() * 30);
        this.cost = (int) (Math.random() * 100_000);
    }

    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s(%dкг, %dруб)", name, weight, cost);
    }
}
