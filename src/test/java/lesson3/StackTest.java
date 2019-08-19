package lesson3;

import lesson3.Stack.MyStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    private MyStack<Integer> stack;

    @Before
    public void prepare() {
        stack = new MyStack<>(3);
    }

    @Test
    public void pushTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertArrayEquals(
                new Integer[] {1, 2, 3},
                stack.getArray());
    }

    @Test
    public void popTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int i = stack.pop();

        Assert.assertArrayEquals(new Integer[] {1, 2}, stack.getArray());
        Assert.assertEquals(3, i);
    }

    @Test
    public void peekTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int i = stack.peek();

        Assert.assertArrayEquals(new Integer[] {1, 2, 3}, stack.getArray());
        Assert.assertEquals(3, i);
    }
}
