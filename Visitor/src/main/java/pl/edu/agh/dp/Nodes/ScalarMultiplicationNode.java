package pl.edu.agh.dp.Nodes;

import pl.edu.agh.dp.Visitor;

public class ScalarMultiplicationNode extends OperationNode {

    private final double scalar;

    public ScalarMultiplicationNode(NodeElement operationElement, double scalar) {
        super(operationElement);
        this.scalar = scalar;
    }

    public double getScalar() {
        return scalar;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
