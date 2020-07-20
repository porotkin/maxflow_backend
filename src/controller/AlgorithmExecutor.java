package controller;

import model.GraphNode;
import model.GraphRelationsObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AlgorithmExecutor {

    public ArrayList<GraphRelationsObject> getListGraph() {
        return new ArrayList<>(listGraph);
    }

    public ArrayList<GraphNode> getVertices() {
        return new ArrayList<>(vertices);
    }

    private final ArrayList<GraphRelationsObject> listGraph;
    private final ArrayList<GraphNode> vertices;

    public AlgorithmExecutor() throws FileNotFoundException {
        listGraph = FileIO.getDataFromFile(FileIO.CATALINA_HOME + "relations.json", GraphRelationsObject.class);
        vertices = FileIO.getDataFromFile(FileIO.CATALINA_HOME + "vertices.json", GraphNode.class);
    }

    public String execute() {
        String result = "";
        FlowCounter flowCounter = new FlowCounter(vertices.size());
        result = String.format("The maximum possible flow is %d",
                flowCounter.fordFulkerson(GraphRepresenter.toMatrix(listGraph), 0, 5));
        return result;
    }

    public ArrayList<GraphRelationsObject> getChangedRelationsList(GraphRelationsObject newRelation) {
        ArrayList<GraphRelationsObject> result = new ArrayList<>();
        for (var relation : listGraph) {
            if (relation.getFrom() == newRelation.getFrom() && relation.getTo() == newRelation.getTo()) {
                result.add(newRelation);
            }
            else {
                result.add(relation);
            }
        }
        return result;
    }
}
