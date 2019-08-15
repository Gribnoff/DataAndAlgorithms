package lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    private MyQueue<Integer> queue;

    @Before
    public void prepare() {
        queue = new MyPriorityQueue<>(5);
    }

    @Test
    public void offerPollTest() {
        queue.offerAll(5, 1, 3, 2, 4, 8);

        Assert.assertEquals(5, queue.size());
        for (int i = 1; i <= 5; i++) {
            Assert.assertEquals(i, (int)queue.poll());
        }
    }

    @Test
    public void peekTest() {
        queue.offerAll(5, 1, 3, 2, 4);

        int i = queue.peek();

        Assert.assertEquals(5, queue.size());
        Assert.assertEquals(1, i);
    }
}
