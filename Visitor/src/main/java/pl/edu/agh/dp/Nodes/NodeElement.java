package pl.edu.agh.dp.Nodes;

import pl.edu.agh.dp.Visitor;

public abstract class NodeElement {
    protected double[][] matrix;
    public double[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(double[][] resultMatrix){
        matrix = resultMatrix;
    }
    public abstract void accept(Visitor visitor) throws Exception;

}
