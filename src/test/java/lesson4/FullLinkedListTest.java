package lesson4;

import lesson4.linkedlist.MyFullLinkedList;
import lesson4.linkedlist.MyLinkedListFull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class FullLinkedListTest {
    private MyLinkedListFull<Integer> list;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void prepare() {
        list = new MyLinkedListFull<>();
        list.addLast(1);
        list.addLast(2);

        System.setOut(new PrintStream(out));
    }

    @After
    public void close() {
        System.setOut(System.out);
    }

    @Test
    public void addFirstTest() {
        list.addFirst(0);

        list.forEach(System.out::print);
        Assert.assertEquals("012", out.toString());
    }

    @Test
    public void addLastTest() {
        list.addLast(3);

        list.forEach(System.out::print);
        Assert.assertEquals("123", out.toString());
    }

    @Test
    public void containsTest() {
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(3));
    }

    @Test
    public void removeFirstTest() {
        list.removeFirst();

        Assert.assertTrue(list.contains(2));
        Assert.assertFalse(list.contains(1));
    }

    @Test
    public void removeLastTest() {
        list.removeLast();

        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
    }

    @Test
    public void removeTest() {
        list.remove(1);

        Assert.assertTrue(list.contains(2));
        Assert.assertFalse(list.contains(1));
    }

    @Test
    public void getFirstTest() {
        Assert.assertEquals(new Integer(1), list.getFirst());
    }

    @Test
    public void getLastTest() {
        Assert.assertEquals(new Integer(2), list.getLast());
    }

    @Test
    public void iteratorTest() {
        list.addLast(3);

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext())
            System.out.print(itr.next());

        Assert.assertEquals("123", out.toString());
    }

    @Test
    public void descendingIteratorTest() {
        list.addLast(3);

        Iterator<Integer> itr = list.descendingIterator();
        while (itr.hasNext())
            System.out.print(itr.next());

        Assert.assertEquals("321", out.toString());
    }
}
