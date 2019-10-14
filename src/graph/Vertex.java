package graph;

public class Vertex {
    private String data;
    public boolean visited;
    public Vertex(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data='" + data + '\'' +
                '}';
    }
}
