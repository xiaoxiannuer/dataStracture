package graph;

import java.util.Arrays;

public class TestGraph {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        Vertex v1=new Vertex("A");
        Vertex v2=new Vertex("B");
        Vertex v3=new Vertex("C");
        Vertex v4=new Vertex("D");
        Vertex v5=new Vertex("E");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge("A","C");
        g.addEdge("A","B");
        g.addEdge("B","C");
        g.addEdge("B","E");
        g.addEdge("B","D");
        g.addEdge("A","A");
        g.addEdge("B","B");
        g.addEdge("C","C");
        g.addEdge("D","D");
        g.addEdge("E","E");
        for (int[] a:g.adjMat){
            System.out.println(Arrays.toString(a));
        }
        g.dfs();
    }
}
