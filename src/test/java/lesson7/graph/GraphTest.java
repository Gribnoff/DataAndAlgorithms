package lesson7.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GraphTest {
    private Graph graph;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        graph = new Graph(6);
        graph.addAll("A", "B", "C", "D", "E", "F");
        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E", "E");
        graph.addEdge("D", "F");
    }

    @Test
    public void addTest() {
        System.setOut(new PrintStream(out));
        graph.display();
        String expected = "Size = 6\r\n" +
                "(A) -> (B) -> (C) -> (D)\r\n" +
                "(B) -> (A) -> (E)\r\n" +
                "(C) -> (A)\r\n" +
                "(D) -> (A) -> (F)\r\n" +
                "(E) -> (B)\r\n" +
                "(F) -> (D)\r\n";
        Assert.assertEquals(expected, out.toString());
        System.setOut(System.out);
    }

    @Test
    public void bfsTest() {
        System.setOut(new PrintStream(out));
        graph.bfs("A");
        String expected = "A B C D E F \r\n";
        Assert.assertEquals(expected, out.toString());
        System.setOut(System.out);
    }

    @Test
    public void dfsTest() {
        System.setOut(new PrintStream(out));
        graph.dfs("A");
        String expected = "A B E C D F \r\n";
        Assert.assertEquals(expected, out.toString());
        System.setOut(System.out);
    }
}
