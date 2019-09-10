package lesson8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HashMap2Test {
    private MyHash<Item, Integer> map;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private Item orange = new Item(1, "Orange");
    private Item banana = new Item(71, "Banana");
    private Item lemon = new Item(60, "Lemon");
    private Item milk = new Item(52, "Milk");
    private Item potato = new Item(21, "Potato");

    @Before
    public void setUp() {
        map = new MyHashMap<>(5);

        map.put(orange, 150);
        map.put(banana, 100);
        map.put(lemon, 250);
        map.put(milk, 120);
        map.put(potato, 67);
        map.display();
    }

    @Test
    public void addTest() {
        Assert.assertTrue(map.contains(orange));
        Assert.assertTrue(map.contains(banana));
        Assert.assertTrue(map.contains(lemon));
        Assert.assertTrue(map.contains(milk));
        Assert.assertTrue(map.contains(potato));

        System.setOut(System.out);
        System.setOut(new PrintStream(out));
        map.display();
        String expected = "0 = [Node{key=Lemon, value=250}]\r\n" +
                "1 = [Node{key=Orange, value=150}] [Node{key=Banana, value=100}] [Node{key=Potato, value=67}]\r\n" +
                "2 = [Node{key=Milk, value=120}]\r\n" +
                "3 = [null]\r\n" +
                "4 = [null]\r\n";
        Assert.assertEquals(expected, out.toString());
    }

    @Test
    public void removeTest() {
        Assert.assertEquals(100, (int)map.remove(banana));
        Assert.assertFalse(map.contains(banana));
    }

    @Test
    public void getTest() {
        Assert.assertEquals(67, (int)map.get(potato));
    }
}
