package lesson6.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TreeSetTest {
    private MyTree<Integer> tree;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        tree = new MyTreeSet<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);
        tree.display();
    }

    @Test
    public void addTest() {
        System.setOut(new PrintStream(out));
        tree.traverse(MyTree.TraverseMode.PRE_ORDER);
        String expected = "60\r\n5\r\n15\r\n20\r\n25\r\n30\r\n32\r\n45\r\n55\r\n66\r\n";
        Assert.assertEquals(expected, out.toString());
        System.setOut(System.out);
    }

    @Test
    public void removeLeafTest() {
        tree.remove(32);
        Assert.assertFalse(tree.find(32));
    }

    @Test
    public void removeNodeWithSingleChildTest() {
        tree.remove(30);
        Assert.assertFalse(tree.find(30));
        Assert.assertTrue(tree.find(32));
    }

    @Test
    public void removeCommonNodeTest() {
        tree.remove(25);
        Assert.assertFalse(tree.find(25));
        Assert.assertTrue(tree.find(30));
        Assert.assertTrue(tree.find(32));
        Assert.assertTrue(tree.find(45));
    }
}
