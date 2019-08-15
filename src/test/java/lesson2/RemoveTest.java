package lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Parameterized.Parameter(2)
    public int removeIndex;

    @Parameterized.Parameter(3)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Integer[]{0, 1, 2, 3, 4, 5}, 3, 3, null},
                {new String[]{"test string"}, "not that string", 1, ArrayIndexOutOfBoundsException.class}
        });
    }

    private MyArrayList<T> arrayList;
    private int startSize;

    @Before
    public void init() {
        arrayList = new MyArrayList<>(array);
        startSize = arrayList.size();
    }

    @Test
    public void removeTest() {
        arrayList.remove(testValue);
        Assert.assertFalse(arrayList.contains(testValue));
        Assert.assertEquals(startSize - 1, arrayList.size());
    }

    @Test
    public void removeByIndexTest() {
        if (expectedException != null)
            thrown.expect(expectedException);

        arrayList.removeByIndex(removeIndex);
        Assert.assertFalse(arrayList.contains(testValue));
        Assert.assertEquals(startSize - 1, arrayList.size());
    }
}
