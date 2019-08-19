package lesson3;

import lesson3.queue.MyPriorityQueue;
import lesson3.queue.MyQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    private MyPriorityQueue<Integer> queue;

    @Before
    public void prepare() {
        queue = new MyPriorityQueue<>(5);
    }

    @Test
    public void offerTest() {
        queue.offerAll(5, 1, 3, 2, 4, 8);

        Assert.assertEquals(5, queue.size());
        Assert.assertArrayEquals(new Integer[] {5,4,3,2,1}, queue.getArray());
    }

    @Test
    public void peekTest() {
        queue.offerAll(5, 1, 3, 2, 4);

        Assert.assertEquals(new Integer(1), queue.peek());
        Assert.assertEquals(5, queue.size());
    }

    @Test
    public void pollTest() {
        queue.offerAll(5, 1, 3, 2, 4);

        Assert.assertEquals(new Integer(1), queue.poll());
        Assert.assertEquals(4, queue.size());
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
