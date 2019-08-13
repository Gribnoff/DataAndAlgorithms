package lesson2;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    @Test
    public void addTest1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        Assert.assertTrue(arrayList.containsAll(1, 2));
    }

    @Test
    public void addTest2() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String");
        Assert.assertTrue(arrayList.containsAll("String"));
    }
}
