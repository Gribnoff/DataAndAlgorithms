package lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RemoveTest<T extends Object & Comparable<? super T>> {
    @Parameterized.Parameter
    public T[] array;

    @Parameterized.Parameter(1)
    public T testValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Integer[]{0, 1, 2, 3, 4, 5}, 3},
                {new String[]{"test string"}, "not that string"}
        });
    }

    private ArrayList<T> arrayList;

    @Before
    public void init() {
        arrayList = new ArrayList<>(array);
    }

    @Test
    public void removeTest() {
        arrayList.remove(testValue);
        Assert.assertFalse(arrayList.contains(testValue));
    }
}
