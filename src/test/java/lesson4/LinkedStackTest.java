package lesson4;

import lesson3.Stack.MyIStack;
import lesson4.linkedlist.MyLinkedStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedStackTest {
    private MyIStack<Integer> stack;

    @Before
    public void prepare() {
        stack = new MyLinkedStack<>();
    }

    @Test
    public void pushTest() {
        stack.push(1);

        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void popTest() {
        stack.push(1);
        stack.push(2);

        Assert.assertEquals(new Integer(2), stack.pop());
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void peekTest() {
        stack.push(1);
        stack.push(2);

        Assert.assertEquals(new Integer(2), stack.peek());
        Assert.assertEquals(2, stack.size());
    }
}
