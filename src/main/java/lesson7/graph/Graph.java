package lesson7.graph;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public int getSize() {
        return size;
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public void addAll(String... labels) {
        for (String label : labels) {
            addVertex(label);
        }
    }

    public void addEdges(String label, String label2, String... others) {
        addEdge(label, label2);

        for (String another : others) {
            addEdge(label, another);
        }
    }

    public void addEdge(String label, String label2) {
        int index = indexOf(label);
        int index2 = indexOf(label2);

        if (index == -1 || index2 == -1)
            throw new IllegalArgumentException("Invalid vertex label");

        adjMat[index][index2] = true;
        adjMat[index2][index] = true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label))
                return i;
        }
        return -1;
    }

    public void display() {
        System.out.println("Size = " + size);

        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j])
                    System.out.print(" -> " + vertexList.get(j));
            }
            System.out.println();
        }
    }

    private void resetVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    //breadth
    public void bfs(String startLabel) {
        int index = indexOf(startLabel);
        if (index == -1)
            throw new IllegalArgumentException("Invalid vertex label");

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(index);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNextUnvisitedVertex(queue.peek());
            if (vertex != null)
                visitVertex(queue, vertex);
            else
                queue.remove();
        }

        System.out.println();
        resetVisited();
    }

    private static void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    //depth-first search
    public void dfs(String startLabel) {
        int index = indexOf(startLabel);
        if (index == -1)
            throw new IllegalArgumentException("Invalid vertex label");

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(index);
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            vertex = getNextUnvisitedVertex(stack.peek());

            if (vertex != null) {
                visitVertex(stack, vertex);
            } else
                stack.pop();
        }

        System.out.println();
        resetVisited();
    }

    private static void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNextUnvisitedVertex(Vertex currentVertex) {
        int currentIndex = vertexList.indexOf(currentVertex);
        for (int i = 0; i < size; i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited())
                return vertexList.get(i);
        }

        return null;
    }

    private static class Vertex {
        private final String label;
        private boolean visited;

        Vertex(String label) {
            this.label = label;
        }

        String getLabel() {
            return label;
        }

        boolean isVisited() {
            return visited;
        }

        void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public String toString() {
            return String.format("(%s)", label);
        }
    }
}
