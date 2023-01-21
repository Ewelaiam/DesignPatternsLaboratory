package pl.edu.agh.dp.Nodes;

import pl.edu.agh.dp.Visitor;

public class InverseNode extends OperationNode {
    private final double epsilon = 1e-8;

    public InverseNode(NodeElement operationElement) {
        super(operationElement);
    }

    public boolean isInversionPossible() {
        return operationElement.matrix.length == operationElement.matrix[0].length
                && Math.abs(matrixDeterminant(operationElement.matrix.length, operationElement.matrix.length)) > epsilon;
    }

    private double matrixDeterminant(int n, int cofactorN) {
        double determinant = 0;

        if (n == 1) return operationElement.matrix[0][0];

        int sign = 1;
        double[][] cofactors = new double[cofactorN][cofactorN];

        for (int i = 0; i < n; i++) {
            countCofactor(cofactors, i, n);
            determinant += sign * operationElement.matrix[0][i] * matrixDeterminant(n - 1, cofactorN);
            sign = -sign;
        }

        return determinant;
    }

    private void countCofactor(double[][] cofactors, int q, int n) {
        int i = 0;
        int j = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r != 0 && c != q) {
                    cofactors[i][j++] = operationElement.matrix[r][c];
                    if (j == n - 1) {
                        i++;
                        j = 0;
                    }
                }
            }
        }
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
