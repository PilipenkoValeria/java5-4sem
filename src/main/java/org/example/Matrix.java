package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    protected int size;
    protected double[] elements;
    protected double determinant;
    protected boolean determinantIsCorrect = false;

    public Matrix(int size) {
        if (size > 0) {
            this.size = size;
            this.elements = new double[size * size];
        } else {
            throw new IllegalArgumentException();
        }
    }

    static void swap(double[] arr, int size, int i1, int j1, int i2, int j2) {
        double temp = arr[i1 * size + j1];
        arr[i1 * size + j1] = arr[i2 * size + j2];
        arr[i2 * size + j2] = temp;
    }

    @Override
    public double calculateDeterminant() {
        if (!determinantIsCorrect) {
            determinantIsCorrect = true;
            determinant = 1;
            double[] tmpArray = Arrays.copyOf(elements, size * size);
            double coefficient = 0;
            int i, j, k, s, index;
            for (i = 0; i < size - 1; i++) {
                index = i;
                while (index < size && tmpArray[index * size + i] == 0) {
                    index++;
                }
                if (index == size) {
                    determinantIsCorrect = false;
                    determinant = 0;
                    return determinant;
                }
                if (index != i) {
                    for (s = 0; s < size; s++) {
                        swap(tmpArray, size, index, s, i, s);
                    }
                    determinant *= Math.pow(-1, index - i);
                }
                for (j = i + 1; j < size; j++) {
                    coefficient = tmpArray[j * size + i] / tmpArray[i * size + i];
                    for (k = 0; k < size; k++) {
                        tmpArray[j * size + k] -= tmpArray[i * size + k] * coefficient;
                    }
                }
            }
            for (i = 0; i < size; i++) {
                determinant *= tmpArray[i * size + i];
            }
            return determinant;
        }
        return determinant;
    }

    @Override
    public void setMatrixElem( int i,  int j,  double value)  {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            elements[i * size + j] = value;
            determinantIsCorrect = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getMatrixElem( int i,  int j)  {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            return elements[i * size + j];
        } else {
            throw new IllegalArgumentException();
        }
    }


    private void setSize(final int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return size == matrix.size && Arrays.equals(elements, matrix.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}
