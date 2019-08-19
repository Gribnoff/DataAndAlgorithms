package lesson3;

import lesson3.deque.MyArrayDeque;
import lesson3.queue.MyArrayQueue;
import lesson3.queue.MyQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
    private MyArrayQueue<Integer> queue;

    @Before
    public void prepare() {
        queue = new MyArrayQueue<>(3);
    }

    @Test
    public void offerTest() {
        queue.offerAll(1, 2, 3, 4);

        Assert.assertEquals(3, queue.size());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, queue.getArray());
    }

    @Test
    public void peekTest() {
        queue.offerAll(1, 2, 3);

        Assert.assertEquals(new Integer(1), queue.peek());
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void pollTest() {
        queue.offerAll(1, 2, 3);

        Assert.assertEquals(new Integer(1), queue.poll());
        Assert.assertEquals(2, queue.size());
    }

    @Test //проверяется, что добавление идёт в конец(очереди), а забираются элементы с начала(очереди)
    public void generalTest() {
        queue.offerAll(0, 1, 2);

        Assert.assertEquals(new Integer(0), queue.poll());

        queue.offer(3);
        for (int i = 1; i <= 3; i++) {
            Assert.assertEquals(new Integer(i), queue.poll());
        }
    }
}
