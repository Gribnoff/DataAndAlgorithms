package lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InsertSortTest<T extends Object & Comparable<? super T>> {
    @Parameterized.Parameter
    public ArrayList<T> array;

    @Parameterized.Parameter(1)
    public ArrayList<T> result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new ArrayList<>(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}), new ArrayList<>(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})},
                {new ArrayList<>(new Character[]{'c', 'q', 'w', 'e', 'r', 'f', 'g', 'x', 'z', 'y', 'h'}), new ArrayList<>(new Character[]{'c', 'e', 'f', 'g', 'h', 'q', 'r', 'w', 'x', 'y', 'z'})}
        });
    }

    @Test
    public void insertTest() {
        array.sortInsert();
        Assert.assertEquals(result, array);
    }


}
