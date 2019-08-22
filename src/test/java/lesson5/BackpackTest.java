package lesson5;

import lesson5.backpack.Backpack;
import lesson5.backpack.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BackpackTest {
    private Backpack backpack;
    private Set<Item> items;
    private Item laptop;
    private Item jacket;
    private Item boots;
    private Item books;
    private Item umbrella;

    @Before
    public void setUp() {
        backpack = new Backpack(30);
        items = new HashSet<>();
        laptop = new Item("Laptop", 15, 50_000);
        jacket = new Item("Jacket", 5, 15_000);
        boots = new Item("Boots", 35, 25_000);
        books = new Item("Books", 15, 5_000);
        umbrella = new Item("Umbrella", 5, 10_000);
    }

    @Test
    public void test1() {
        items.addAll(Arrays.asList(laptop, jacket, boots, books, umbrella));
        backpack.pack(items);

        Assert.assertTrue(backpack.getContent().contains(laptop));
        Assert.assertTrue(backpack.getContent().contains(jacket));
        Assert.assertTrue(backpack.getContent().contains(umbrella));
        Assert.assertFalse(backpack.getContent().contains(books));
        Assert.assertFalse(backpack.getContent().contains(boots));
    }

    @Test
    public void test2() {
        items.add(laptop);
        backpack.pack(items);

        Assert.assertTrue(backpack.getContent().contains(laptop));
    }

    @Test
    public void test3() {
        items.add(boots);
        backpack.pack(items);

        Assert.assertFalse(backpack.getContent().contains(boots));
    }
}
