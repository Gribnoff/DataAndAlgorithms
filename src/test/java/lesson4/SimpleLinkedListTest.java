package lesson4;

import lesson4.linkedlist.MyLinkedList;
import lesson4.linkedlist.MySimpleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleLinkedListTest {
    private MyLinkedList<Integer> list;

    @Before
    public void prepare() {
        list = new MySimpleLinkedList<>();
    }

    @Test
    public void addFirstTest() {
        list.addFirst(1);

        Assert.assertNotNull(list.getFirst());
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
