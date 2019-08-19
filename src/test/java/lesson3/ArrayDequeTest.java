package lesson3;

import lesson3.deque.MyArrayDeque;
import lesson3.deque.MyDeque;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayDequeTest {
    private MyDeque<Integer> deque;

    @Before
    public void prepare() {
        deque = new MyArrayDeque<>(5);
    }

    @Test
    public void offerLastTest() {
        for (int i = 0; i < 5 + 1; i++) {
            deque.offerLast(i + 1);
        }

        Assert.assertEquals(5, deque.size());
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5}, deque.getArray());
    }

    @Test
    public void offerFirstTest() {
        for (int i = 0; i < 5 + 1; i++) {
            deque.offerFirst(i + 1);
        }

        Assert.assertEquals(5, deque.size());
        Assert.assertArrayEquals(new Integer[]{5,4,3,2,1}, deque.getArray());
    }

    @Test
    public void peekFirstTest() {
        for (int i = 0; i < 5; i++) {
            deque.offerLast(i + 1);
        }

        Assert.assertEquals(new Integer(1), deque.peekFirst());
        Assert.assertEquals(5, deque.size());
    }

    @Test
    public void peekLastTest() {
        for (int i = 0; i < 5; i++) {
            deque.offerLast(i + 1);
        }

        Assert.assertEquals(new Integer(5), deque.peekLast());
        Assert.assertEquals(5, deque.size());
    }

    @Test
    public void pollFirstTest() {
        for (int i = 0; i < 5; i++) {
            deque.offerLast(i + 1);
        }

        Assert.assertEquals(new Integer(1), deque.pollFirst());
        Assert.assertEquals(4, deque.size());
    }

    @Test
    public void pollLastTest() {
        for (int i = 0; i < 5; i++) {
            deque.offerLast(i + 1);
        }

        Assert.assertEquals(new Integer(5), deque.pollLast());
        Assert.assertEquals(4, deque.size());
    }

    @Test //проверяется, что добавление и удаление элементов правильно при достижении края массива(проход направо)
    public void goingRightTest() {
        for (int i = 0; i < 5; i++) { // {1,2,3,4,5}
            deque.offerLast(i + 1);
        }

        Assert.assertEquals(new Integer(1), deque.pollFirst()); // {-,2,3,4,5}

        deque.offerLast(6); // {6,2,3,4,5}
        Assert.assertArrayEquals(new Integer[] {6,2,3,4,5}, deque.getArray());
        Assert.assertEquals(new Integer(2), deque.pollFirst()); // {6,-,3,4,5}
    }

    @Test //проверяется, что добавление и удаление элементов правильно при достижении края массива(проход налево)
    public void goingLeftTest() {
        for (int i = 0; i < 5; i++) { // {5,4,3,2,1}
            deque.offerFirst(i + 1);
        }

        Assert.assertEquals(new Integer(1), deque.pollLast()); // {5,4,3,2,-}

        deque.offerFirst(6); // {5,4,3,2,6}
        Assert.assertArrayEquals(new Integer[] {5,4,3,2,6}, deque.getArray());
        Assert.assertEquals(new Integer(2), deque.pollLast()); // {5,4,3,-,6}

    }
}
