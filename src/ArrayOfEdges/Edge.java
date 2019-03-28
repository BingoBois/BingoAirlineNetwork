package ArrayOfEdges;

public class Edge<T> {
    private Vertex<T> vertexA, vertexB;

    public Edge(Vertex<T> vertexA, Vertex<T> vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Vertex<T> getVertexA() {
        return vertexA;
    }

    public Vertex<T> getVertexB() {
        return vertexB;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{a: ");
        strBuilder.append(vertexA.toString());
        strBuilder.append(" }, ");

        strBuilder.append("{b: ");
        strBuilder.append(vertexB.toString());
        strBuilder.append(" }");
        return strBuilder.toString();
    }
}
