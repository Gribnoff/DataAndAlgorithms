package lesson2;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    @Test
    public void addTest1() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        Assert.assertTrue(arrayList.containsAll(1, 2));
    }

    @Test
    public void addTest2() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("String");
        Assert.assertTrue(arrayList.contains("String"));
    }

    @Test
    public void addByIndexTest1() {
        MyArrayList<Integer> arrayList = new MyArrayList<>(new Integer[]{0,1,2,4,5,6,7,8,9,10});
        arrayList.add(3, 3);
        Assert.assertEquals((Integer) 3, arrayList.get(3));
    }

    @Test
    public void addByIndexTest2() {
        MyArrayList<Character> arrayList = new MyArrayList<>(new Character[]{'q','w','e','r','y','u','i','o','p'});
        arrayList.add(4, 't');
        Assert.assertEquals( (Character) 't', arrayList.get(4));
    }
}
