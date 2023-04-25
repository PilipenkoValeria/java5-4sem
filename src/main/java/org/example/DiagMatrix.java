package org.example;

import java.util.Arrays;
import java.util.Objects;

public class DiagMatrix extends Matrix {

    public DiagMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше 0");
        } else {
            this.size = size;
            this.elements = new double[size];
        }
    }

    public DiagMatrix(double... elements) {
        if (elements.length <= 0) {
            throw new IllegalArgumentException("Неккоректный размер матрицы");
        } else {
            this.size = elements.length;
            this.elements = new double[size];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
        }
    }

    @Override
    public double getMatrixElem(int i, int j) {
        if (i >= size || j >= size || i < 0 || j < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        return (i != j) ? 0.0 : elements[i];
    }

    @Override
    public void setMatrixElem(int i, int j, double element) {
        if (i >= size || j >= size || i < 0 || j < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        if (i != j && element != 0) {
            throw new IllegalArgumentException("Нельзя записать ненулевое значение вне главной диагонали");
        } else {
            elements[i] = element;
            determinantIsCorrect = false;
        }
    }

    public double calculateDeterminant() {
        double determinant = 1;
        if (determinantIsCorrect) {
            return determinant;
        }
        for (double i : elements) {
            determinant *= i;
        }
        determinant = determinant;
        determinantIsCorrect = true;
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