package model;

public class GraphRelationsObject {
    private final int from;
    private final int to;
    private final int weight;

    public GraphRelationsObject(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
