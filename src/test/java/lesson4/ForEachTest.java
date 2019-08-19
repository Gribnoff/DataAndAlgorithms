package lesson4;

import lesson4.linkedlist.MyLinkedList;
import lesson4.linkedlist.MySimpleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.function.Consumer;

public class ForEachTest {
    @Test
    public void test() {
        MyLinkedList<Integer> list = new MySimpleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        list.forEach(System.out::println);
    }

    @Test
    public void test1() {
        MyLinkedList<Integer> list = new MySimpleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
