package org.example;

import java.util.Arrays;
import java.util.Objects;

public class UpTriangleMatrix extends Matrix {
    public UpTriangleMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше 0");
        }
        this.size = size;
        this.elements = new double[(size * size + size) / 2];
    }

    UpTriangleMatrix(int size, double... elements) {
        if (size <= 0) {
            throw new IllegalArgumentException("Задан неккоректный размер матрицы");
        }
        this.size = size;
        this.elements = new double[(size * size + size) / 2];
        this.elements = elements;
    }

    @Override
    public double getMatrixElem(int i, int j) {
        if (i >= size || j >= size || i < 0 || j < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        if (i > j) {
            return 0.0;
        } else {
            int k = 0;
            for (int l = 1; l <= i; l++) {
                k += l;
            }
            return elements[size * i + j - k];
        }
    }

    @Override
    public void setMatrixElem(int i, int j, double element) {
        if (i >= size || j >= size || i < 0 || j < 0) {
            throw new IllegalArgumentException("Индексы не входят в матрицу");
        }
        if (i > j && element != 0) {
            throw new IllegalArgumentException("Нельзя записать ненулевое значение под главной диагональю");
        } else {
            elements[(size - i) * i + j] = element;
            determinantIsCorrect = false;
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