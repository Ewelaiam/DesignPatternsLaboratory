package pl.edu.agh.dp.Nodes;

public abstract class OperationNode extends NodeElement {
    protected NodeElement operationElement;

    public OperationNode(NodeElement operationElement){
        this.operationElement = operationElement;
    }

    public NodeElement getOperationElement() {
        return operationElement;
    }

}
