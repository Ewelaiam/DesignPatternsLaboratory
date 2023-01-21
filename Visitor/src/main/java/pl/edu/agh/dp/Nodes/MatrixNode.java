package pl.edu.agh.dp.Nodes;

import pl.edu.agh.dp.Visitor;

public class MatrixNode extends NodeElement {
    public MatrixNode(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
