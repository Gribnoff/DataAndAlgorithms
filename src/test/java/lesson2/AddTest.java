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
        Assert.assertTrue(arrayList.contains("String"));
    }

    @Test
    public void addByIndexTest1() {
        ArrayList<Integer> arrayList = new ArrayList<>(new Integer[]{0,1,2,4,5,6,7,8,9,10});
        arrayList.add(3, 3);
        Assert.assertEquals((Integer) 3, arrayList.get(3));
    }

    @Test
    public void addByIndexTest2() {
        ArrayList<Character> arrayList = new ArrayList<>(new Character[]{'q','w','e','r','y','u','i','o','p'});
        arrayList.add(4, 't');
        Assert.assertEquals( (Character) 't', arrayList.get(4));
    }
}
