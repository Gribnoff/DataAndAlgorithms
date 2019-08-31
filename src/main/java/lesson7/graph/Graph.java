package lesson7.graph;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private final int[][] adjMat;

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new int[maxVertexCount][maxVertexCount];
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
        addEdge(label, label2, 1);
    }

    public void addEdge(String label, String label2, int weight) {
        int index = indexOf(label);
        int index2 = indexOf(label2);

        if (index == -1 || index2 == -1)
            throw new IllegalArgumentException("Invalid vertex label");

        adjMat[index][index2] = weight;
        adjMat[index2][index] = weight;
    }

    public int getWeight(String label, String label2) {
        return adjMat[indexOf(label)][indexOf(label2)];
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
                if (adjMat[i][j] != 0)
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
            if (adjMat[currentIndex][i] != 0 && !vertexList.get(i).isVisited())
                return vertexList.get(i);
        }

        return null;
    }

    public void bestRoute(String source, String target) {
        int index1 = indexOf(source);
        int index2 = indexOf(target);
        if (index1 == -1 || index2 == -1)
            throw new IllegalArgumentException("Invalid vertex label");

        for (Vertex v : vertexList) {
            v.setDist(Integer.MAX_VALUE);
            v.setPrev(null);
        }
        Vertex targetVertex = vertexList.get(index2);

        Vertex vertex = vertexList.get(index1);
        vertex.setDist(0);

        Queue<Vertex> queue = new PriorityQueue<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Vertex prev = queue.poll();
            int index = indexOf(prev.getLabel());
            for (int i = 0; i < adjMat[index].length; i++) {
                if (adjMat[index][i] > 0) {
                    vertex = vertexList.get(i);
                    int dist = getWeight(prev.getLabel(), vertex.getLabel());
                    int distToVertex = prev.dist + dist;

                    if (distToVertex < vertex.dist) {
                        queue.remove(vertex);
                        vertex.setDist(distToVertex);
                        vertex.setPrev(prev);
                        queue.add(vertex);
                    }
                }
            }
        }

        List<Vertex> route = new ArrayList<>();
        for (Vertex v = targetVertex; v != null; v = v.prev)
            route.add(v);

        Collections.reverse(route);

        System.out.printf("Best route from %s to %s: ", source, target);
        for (Vertex v : route) {
            System.out.print(v.getLabel() + " -> ");
        }

        System.out.println("\b\b\b\b\nDistance: " + targetVertex.getDist());

    }

    private static class Vertex implements Comparable<Vertex>{
        private final String label;
        private boolean visited;
        private int dist;
        private Vertex prev;

        Vertex(String label) {
            this.label = label;
            this.dist = Integer.MAX_VALUE;
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

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public Vertex getPrev() {
            return prev;
        }

        public void setPrev(Vertex prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return String.format("(%s)", label);
        }

        @Override
        public int compareTo(Vertex another) {
            return Integer.compare(dist, another.dist);
        }
    }
}
