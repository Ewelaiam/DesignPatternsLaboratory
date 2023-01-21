package pl.edu.agh.dp.Nodes;

import pl.edu.agh.dp.Visitor;

public class MatrixMultiplicationNode extends OperationNode {
    private final NodeElement secondOperationElement;

    public MatrixMultiplicationNode(NodeElement operationElement, NodeElement secondOperationElement) {
        super(operationElement);
        this.secondOperationElement = secondOperationElement;
    }

    public NodeElement getSecondOperationElement() {
        return secondOperationElement;
    }

    public boolean isMatrixMultiplicationPossible(){
        return operationElement.getMatrix()[0].length == secondOperationElement.getMatrix().length;
    }
    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
