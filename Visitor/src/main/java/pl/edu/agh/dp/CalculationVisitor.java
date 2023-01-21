package pl.edu.agh.dp;

import pl.edu.agh.dp.Nodes.*;

public class CalculationVisitor implements Visitor{

    @Override
    public void visit(AddNode addOperation) throws Exception {
        double[][] matrix1 = addOperation.getOperationElement().getMatrix();
        double[][] matrix2 = addOperation.getSecondOperationElement().getMatrix();

        double[][] result = new double[matrix1.length][];
        for (int i = 0; i < matrix1.length; i++)
            result[i] = matrix1[i].clone();

        if (addOperation.areMatricesDimensionsEqual()){
            for(int i = 0; i < matrix1.length; i++){
                for(int j = 0; j < matrix1[0].length; j++){
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        } else throw new Exception("Cannot add two matrices with different dimensions!");

        addOperation.setMatrix(result);
    }

    @Override
    public void visit(SubtractNode subtractOperation) throws Exception {
        double[][] matrix1 = subtractOperation.getOperationElement().getMatrix();
        double[][] matrix2 = subtractOperation.getSecondOperationElement().getMatrix();

        double[][] result = new double[matrix1.length][];
        for (int i = 0; i < matrix1.length; i++)
            result[i] = matrix1[i].clone();

        if (subtractOperation.areMatricesDimensionsEqual()){
            for(int i = 0; i < matrix1.length; i++){
                for(int j = 0; j < matrix1[0].length; j++){
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        } else throw new Exception("Cannot subtract two matrices with different dimensions!");

        subtractOperation.setMatrix(result);
    }

    @Override
    public void visit(MatrixMultiplicationNode matrixMultiplicationOperation) throws Exception {
        double[][] matrix1 = matrixMultiplicationOperation.getOperationElement().getMatrix();
        double[][] matrix2 = matrixMultiplicationOperation.getSecondOperationElement().getMatrix();

        double[][] result = new double[matrix1.length][];
        for (int i = 0; i < matrix2.length; i++)
            result[i] = matrix2[i].clone();

        if(matrixMultiplicationOperation.isMatrixMultiplicationPossible()){
            for (int i=0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    double cellValue = 0;
                    for (int k = 0; k < matrix1[0].length; k++)
                        cellValue += matrix1[i][k] * matrix2[k][j];
                    result[i][j] = cellValue;
                }
            }
        } else throw new Exception("Cannot multiple given matrices - the number of matrix1 columns and matrix2 rows must be equal!");

        matrixMultiplicationOperation.setMatrix(result);
    }

    @Override
    public void visit(ScalarMultiplicationNode scalarMultiplicationOperation) {
        double[][] matrix1 = scalarMultiplicationOperation.getOperationElement().getMatrix();
        double scalar = scalarMultiplicationOperation.getScalar();

        for (int i=0; i < matrix1.length; i++)
            for (int j=0; j < matrix1[0].length; j++)
                matrix1[i][j] *= scalar;

        scalarMultiplicationOperation.setMatrix(matrix1);
    }

    @Override
    public void visit(InverseNode inverseOperation) throws Exception {
        if(inverseOperation.isInversionPossible()){
            double[][] A = inverseOperation.getOperationElement().getMatrix();
            int n = A.length;
            double[][] x = new double[n][n];
            double[][] b = new double[n][n];
            int[] idx = new int[n];

            for (int i = 0; i < n; ++i)
                b[i][i] = 1;

            gaussian(A, idx);

            for (int i = 0; i < n - 1; ++i)
                for (int j = i + 1; j < n; ++j)
                    for (int k = 0; k < n; ++k)
                        b[idx[j]][k] -= A[idx[j]][i] * b[idx[i]][k];

            for (int i = 0; i < n; ++i) {
                x[n - 1][i] = b[idx[n - 1]][i] / A[idx[n - 1]][n - 1];
                for (int j = n - 2; j >= 0; --j) {
                    x[j][i] = b[idx[j]][i];
                    for (int k = j + 1; k < n; ++k) {
                        x[j][i] -= A[idx[j]][k] * x[k][i];
                    }
                    x[j][i] /= A[idx[j]][j];
                }
            }

            inverseOperation.setMatrix(x);

        } else throw new Exception("For given matrix inverse matrix does not exist!");
    }

    public void gaussian(double[][] A, int[] idx) {
        int n = idx.length;
        double[] c = new double[n];

        for (int i = 0; i < n; ++i)
            idx[i] = i;

        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(A[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pivot1 = 0;
            for (int i = j; i < n; ++i) {
                double pivot0 = Math.abs(A[idx[i]][j]);
                pivot0 /= c[idx[i]];
                if (pivot0 > pivot1) {
                    pivot1 = pivot0;
                    k = i;
                }
            }

            int tmp = idx[j];
            idx[j] = idx[k];
            idx[k] = tmp;

            for (int i = j + 1; i < n; ++i) {
                double pivotRation = A[idx[i]][j] / A[idx[j]][j];

                A[idx[i]][j] = pivotRation;

                for (int l = j + 1; l < n; ++l)
                    A[idx[i]][l] -= pivotRation * A[idx[j]][l];
            }
        }
    }

    @Override
    public void visit(MatrixNode matrixNode) throws Exception {
        if(matrixNode.getMatrix().length == 0){
            throw new Exception("Provided a empty matrix!");
        }
    }
}
