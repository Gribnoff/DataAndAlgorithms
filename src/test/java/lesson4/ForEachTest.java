package lesson4;

import lesson4.linkedlist.MySimpleLinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ForEachTest {
    private MySimpleLinkedList<Integer> list;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void prepare() {
        list = new MySimpleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        System.setOut(new PrintStream(out));
    }

    @After
    public void close() {
        System.setOut(System.out);
    }

    @Test
    public void test() {
        list.forEach(System.out::print);

        Assert.assertEquals("43210", out.toString());
    }

    @Test
    public void test1() {
        for (Integer integer : list) {
            System.out.print(integer);
        }

        Assert.assertEquals("43210", out.toString());
    }
}
