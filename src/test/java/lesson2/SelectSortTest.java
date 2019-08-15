package lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SelectSortTest<T extends Object & Comparable<? super T>> {
    @Parameterized.Parameter
    public MyArrayList<T> array;

    @Parameterized.Parameter(1)
    public MyArrayList<T> result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new MyArrayList<>(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}), new MyArrayList<>(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})},
                {new MyArrayList<>(new Character[]{'c', 'q', 'w', 'e', 'r', 'f', 'g', 'x', 'z', 'y', 'h'}), new MyArrayList<>(new Character[]{'c', 'e', 'f', 'g', 'h', 'q', 'r', 'w', 'x', 'y', 'z'})}
        });
    }

    @Test
    public void selectTest() {
        array.sortSelect();
        Assert.assertEquals(result, array);
    }
}
