package lesson4;

import lesson4.linkedlist.MyTwoSideLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSideLinkedListTest {
    private MyTwoSideLinkedList<Integer> list;

    @Before
    public void prepare() {
        list = new MyTwoSideLinkedList<>();
    }

    @Test
    public void addFirstTest() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.forEach(System.out::println);
    }

    @Test
    public void addLastTest() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.forEach(System.out::println);
    }

    @Test
    public void containsTest() {
        list.addFirst(1);

        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
    }

    @Test
    public void removeFirstTest() {
        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst();

        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
    }

    @Test
    public void removeTest() {
        list.addFirst(1);
        list.addFirst(2);
        list.remove(1);

        Assert.assertTrue(list.contains(2));
        Assert.assertFalse(list.contains(1));
    }
}
