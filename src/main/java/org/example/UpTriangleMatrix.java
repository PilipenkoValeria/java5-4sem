package org.example;

import java.util.Arrays;
import java.util.Objects;

public class UpTriangleMatrix extends Matrix {
    public UpTriangleMatrix(int size) {
        super(size);
    }

    public double getMatrixElem(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            return elements[i * size + j];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setMatrixElem(int i, int j, double element) {
        if (j >= i && i >= 0 && i < size) {
            elements[i * size + j] = element;
            determinantIsCorrect = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double calculateDeterminant() {
        if (!determinantIsCorrect) {
            determinantIsCorrect = true;
            determinant = 1;
            double[] tmpArray = Arrays.copyOf(elements, size * size);
            int i;
            for (i = 0; i < size; i++) {
                if (tmpArray[i * size + i] == 0) {
                    determinantIsCorrect = false;
                    return 0;
                } else {
                    determinant *= tmpArray[i * size + i];
                }
            }
            return determinant;
        }
        return determinant;
    }

    public int getSize() {
        return size;
    }

    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    public boolean equals(Matrix obj) {
        return this.hashCode() == obj.hashCode();
    }
}