package controller;

import model.GraphRelationsObject;

import java.util.ArrayList;

public class GraphRepresenter {

    public static int[][] toMatrix(ArrayList<GraphRelationsObject> graph) {
        int verticesCount = graph.size();
        int[][] matrix = new int[verticesCount][verticesCount];
        for (var graphObject : graph) {
            matrix[graphObject.getFrom()][graphObject.getTo()] = graphObject.getWeight();
        }
        return matrix;
    }

    public static ArrayList<GraphRelationsObject> toGraph(int[][] matrix) {
        ArrayList<GraphRelationsObject> graph = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    GraphRelationsObject object = new GraphRelationsObject(i, j, matrix[i][j]);
                    graph.add(object);
                }
            }
        }
        return graph;
    }
}
