package org.example;

public interface IMatrix {
    double calculateDeterminant();
    void setMatrixElem(final int i, final int j, final double value);
    double getMatrixElem(final int i, final int j);
}
