package lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ContainsAndIndexOfTest<T extends Object & Comparable<? super T>> {
    @Parameterized.Parameter
    public T[] array;

    @Parameterized.Parameter(1)
    public T testValue;

    @Parameterized.Parameter(2)
    public boolean contains;

    @Parameterized.Parameter(3)
    public int indexOf;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Integer[]{0, 1, 2, 3, 4, 5}, 3, true, 3},
                {new String[]{"test string"}, "not that string", false, -1}
        });
    }

    private MyArrayList<T> arrayList;

    @Before
    public void init() {
        arrayList = new MyArrayList<>(array);
    }

    @Test
    public void containsTest() {
        Assert.assertEquals(contains, arrayList.contains(testValue));
    }

    @Test
    public void indexOfTest() {
        Assert.assertEquals(indexOf, arrayList.indexOf(testValue));
    }
}
