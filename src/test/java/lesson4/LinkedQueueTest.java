package lesson4;

import lesson3.queue.MyQueue;
import lesson4.linkedlist.MyLinkedQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {
    private MyQueue<Integer> queue;

    @Before
    public void prepare() {
        queue = new MyLinkedQueue<>();
    }

    @Test
    public void offerTest() {
        queue.offer(1);

        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void pollTest() {
        queue.offer(1);
        queue.offer(2);

        Assert.assertEquals(new Integer(1), queue.poll());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void peekTest() {
        queue.offer(1);
        queue.offer(2);

        Assert.assertEquals(new Integer(1), queue.peek());
        Assert.assertEquals(2, queue.size());
    }
}
