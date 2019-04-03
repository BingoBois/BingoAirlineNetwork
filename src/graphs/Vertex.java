package graphs;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>>{
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return o.getData().compareTo(data);
    }
}
