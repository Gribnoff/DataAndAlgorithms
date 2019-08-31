package lesson7;

import lesson7.graph.Graph;

public class Cities {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addAll("Москва", "Тула", "Рязань", "Калуга", "Липецк",
                "Тамбов", "Орел", "Саратов", "Курск", "Воронеж");

        graph.addEdge("Москва","Тула", 180);
        graph.addEdge("Москва","Рязань", 200);
        graph.addEdge("Москва","Калуга", 180);

        graph.addEdge("Тула", "Липецк", 270);
        graph.addEdge("Липецк", "Воронеж", 130);

        graph.addEdge("Рязань", "Тамбов", 280);
        graph.addEdge("Тамбов", "Саратов", 390);
        graph.addEdge("Саратов", "Воронеж", 520);

        graph.addEdge("Калуга", "Орел", 210);
        graph.addEdge("Орел", "Курск", 160);
        graph.addEdge("Курск", "Воронеж", 230);

        graph.bestRoute("Москва", "Воронеж");
        graph.bestRoute("Орел", "Тамбов");
    }
}
