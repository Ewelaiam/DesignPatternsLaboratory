package pl.edu.agh.dp;

import pl.edu.agh.dp.Nodes.*;

import java.util.LinkedList;
import java.util.List;

public class ComputationalGraph {
    private final List<NodeElement> nodes = new LinkedList<>();

    public void doCalculations(Visitor visitor) throws Exception {
        for(NodeElement nodeElement : nodes){
            nodeElement.accept(visitor);
        }
    }

    public NodeElement addMatrices(NodeElement nodeElement1, NodeElement nodeElement2){
        NodeElement addNode = new AddNode(nodeElement1, nodeElement2);
        nodes.add(addNode);
        return addNode;
    }

    public NodeElement subtractMatrices(NodeElement nodeElement1, NodeElement nodeElement2){
        NodeElement subtractNode = new SubtractNode(nodeElement1, nodeElement2);
        nodes.add(subtractNode);
        return subtractNode;
    }

    public NodeElement scalarMultiplication(NodeElement nodeElement, double scalar){
        NodeElement scalarMultiplicationNode = new ScalarMultiplicationNode(nodeElement, scalar);
        nodes.add(scalarMultiplicationNode);
        return scalarMultiplicationNode;
    }

    public NodeElement matrixMultiplication(NodeElement nodeElement1, NodeElement nodeElement2){
        NodeElement matrixMultiplicationNode = new MatrixMultiplicationNode(nodeElement1, nodeElement2);
        nodes.add(matrixMultiplicationNode);
        return matrixMultiplicationNode;
    }

    public NodeElement inverseMatrix(NodeElement nodeElement){
        NodeElement inverseNode = new InverseNode(nodeElement);
        nodes.add(inverseNode);
        return inverseNode;
    }

    public NodeElement addMatrix(double[][] matrix){
        NodeElement matrixNode = new MatrixNode(matrix);
        nodes.add(matrixNode);
        return matrixNode;
    }

}
