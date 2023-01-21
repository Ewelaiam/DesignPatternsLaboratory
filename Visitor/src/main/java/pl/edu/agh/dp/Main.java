package pl.edu.agh.dp;

import pl.edu.agh.dp.Nodes.NodeElement;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        ComputationalGraph computationalGraph = new ComputationalGraph();
        Visitor visitor = new CalculationVisitor();

        double[][] a = {
            {3, 9, -4},
            {1, 3, -1},
            {2, 5, -2}
        };

        double[][] b = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };

        double[][] c = {
            {-3, 1},
            {4, 5},
            {1, 2}
        };

        double[][] d = {
            {5, 8},
            {1, 2},
            {9, 4}
        };

        NodeElement matrixNodeA = computationalGraph.addMatrix(a);
        NodeElement inverseNodeA = computationalGraph.inverseMatrix(matrixNodeA);
        NodeElement matrixNodeB = computationalGraph.addMatrix(b);
        NodeElement addNodeAB = computationalGraph.addMatrices(inverseNodeA, matrixNodeB);
        NodeElement matrixNodeC = computationalGraph.addMatrix(c);
        NodeElement matrixMultiplicationABAndC = computationalGraph.matrixMultiplication(addNodeAB, matrixNodeC);
        NodeElement matrixNodeD = computationalGraph.addMatrix(d);
        NodeElement subtractMatrixABCAndD = computationalGraph.subtractMatrices(matrixMultiplicationABAndC, matrixNodeD);
        NodeElement scalarMultiplicationABCD = computationalGraph.scalarMultiplication(subtractMatrixABCAndD, 1.5);

        computationalGraph.doCalculations(visitor);
        System.out.println(Arrays.deepToString(scalarMultiplicationABCD.getMatrix()));
    }
}
