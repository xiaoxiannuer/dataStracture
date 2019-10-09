package hufffman;

public class Node implements Comparable<Node>{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }

    @Override
    public int compareTo(Node o) {
        return -(this.data-o.data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
