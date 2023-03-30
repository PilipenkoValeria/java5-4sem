package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double element;
        System.out.println("Введите элементы: ");
        Matrix matrix = new Matrix(3);
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                element = in.nextDouble();
                matrix.setMatrixElem(i, j, element);
            }
        }
        System.out.println(matrix.calculateDeterminant());
    }
}
