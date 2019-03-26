package ArrayOfEdges;

public class EdgePair<T> {
    private Edge<T> edgeA, edgeB;

    public EdgePair(Edge<T> edgeA, Edge<T> edgeB) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
    }

    public Edge<T> getEdgeA() {
        return edgeA;
    }

    public Edge<T> getEdgeB() {
        return edgeB;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{a: ");
        strBuilder.append(edgeA.toString());
        strBuilder.append(" }, ");

        strBuilder.append("{b: ");
        strBuilder.append(edgeB.toString());
        strBuilder.append(" }");
        return strBuilder.toString();
    }
}
