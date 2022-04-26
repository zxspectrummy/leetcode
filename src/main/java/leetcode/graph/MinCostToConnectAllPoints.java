package leetcode.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        public int kruskalMST() {
            if (allEdges.size() == 0)
                return 0;
            if (allEdges.size() == 1)
                return allEdges.get(0).weight;
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(e -> e.weight));
            pq.addAll(allEdges);

            int[] parent = new int[vertices];
            makeSet(parent);
            ArrayList<Edge> mst = new ArrayList<>();

            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if (x_set != y_set) {
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            int sum = 0;
            for (Edge edge : mst) {
                sum += edge.weight;
            }
            return sum;
        }

        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex)
                return find(parent, parent[vertex]);
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int xSetParent = find(parent, x);
            int ySetParent = find(parent, y);
            parent[ySetParent] = xSetParent;
        }
    }

    public static int countDistance(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }


    public static void main(String[] args) {
        //int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int[][] points = {{-100, -100}, {100, 100}};
        Graph graph = new Graph(points.length);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                graph.addEgde(i, j, countDistance(points[i], points[j]));
            }
        }
        System.out.println(graph.kruskalMST());
    }
}



