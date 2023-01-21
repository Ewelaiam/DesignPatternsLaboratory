package pl.edu.agh.dp;

import pl.edu.agh.dp.Nodes.*;

public interface Visitor {
    void visit(AddNode addOperation) throws Exception;
    void visit(SubtractNode subtractOperation) throws Exception;
    void visit(MatrixMultiplicationNode matrixMultiplicationOperation) throws Exception;
    void visit(ScalarMultiplicationNode scalarMultiplicationOperation);
    void visit(InverseNode inverseOperation) throws Exception;
    void visit(MatrixNode matrixNode) throws Exception;
}
