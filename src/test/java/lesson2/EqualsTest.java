package lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EqualsTest<T extends Object & Comparable<? super T>> {
    @Parameterized.Parameter
    public T[] array1;

    @Parameterized.Parameter(1)
    public T[] array2;

    @Parameterized.Parameter(2)
    public boolean equals;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Integer[]{0, 1, 2, 3, 4, 5}, new Integer[]{0, 1, 2, 3, 4, 5}, true},
                {new String[]{"test string"}, new String[]{"not that string"}, false}
        });
    }

    @Test
    public void equalsTest() {
        ArrayList<T> arrayList1 = new ArrayList<>(array1);
        ArrayList<T> arrayList2 = new ArrayList<>(array2);
        Assert.assertEquals(equals, arrayList1.equals(arrayList2));
    }
}
