package lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
    private MyQueue<Integer> queue;

    @Before
    public void prepare() {
        queue = new MyArrayQueue<>(3);
    }

    @Test
    public void offerPollTest() {
        queue.offerAll(1, 2, 3, 4);

        Assert.assertEquals(3, queue.size());
        for (int i = 1; i <= 3; i++) {
            Assert.assertEquals(i, (int)queue.poll());
        }
    }

    @Test
    public void peekTest() {
        queue.offerAll(1, 2, 3);

        int i = queue.peek();

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(1, i);
    }
}
