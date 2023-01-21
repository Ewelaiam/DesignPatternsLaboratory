package pl.edu.agh.dp.Nodes;

import pl.edu.agh.dp.Visitor;

public class SubtractNode extends OperationNode {

    private final NodeElement secondOperationElement;

    public SubtractNode(NodeElement operationElement, NodeElement secondOperationElement) {
        super(operationElement);
        this.secondOperationElement = secondOperationElement;
    }

    public NodeElement getSecondOperationElement() {
        return secondOperationElement;
    }

    public boolean areMatricesDimensionsEqual(){
        int matrix1Rows = getOperationElement().getMatrix().length;
        int matrix1Columns = getOperationElement().getMatrix()[0].length;

        int matrix2Rows = getSecondOperationElement().getMatrix().length;
        int matrix2Columns = getSecondOperationElement().getMatrix()[0].length;

        return matrix1Rows == matrix2Rows && matrix1Columns == matrix2Columns;
    }
    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
