package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiagMatrixTest {

    DiagMatrix dm1 = new DiagMatrix(1,5,7);

    @Test
    public void getMatrixElemTest0() {
        assertEquals(5, dm1.getMatrixElem(1, 1), 0.001);
    }

    @Test
    public void getMatrixElemTest1() {
        assertEquals(0, dm1.getMatrixElem(0, 1), 0.001);
    }

    @Test
    public void setMatrixElemTest0() {
        dm1.setMatrixElem(1, 1, 111);
        assertEquals(111, dm1.getMatrixElem(1, 1), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMatrixElemTest1() {
        dm1.setMatrixElem(0, 1, 111);
    }

    @Test
    public void calculateDeterminantTest() {
        assertEquals(35, dm1.calculateDeterminant(), 0.001);
    }

    @Test
    public void determinantIsCorrectTest0() {
        Matrix matrix = new DiagMatrix(1, 7, 5);
        matrix.calculateDeterminant(); // 35
        matrix.setMatrixElem(0, 0, 5);
        assertEquals(175, matrix.calculateDeterminant(), 0.001);
    }

    @Test
    public void determinantIsCorrectTest1() {
        Matrix matrix = new DiagMatrix(2, 4, 6, 8);
        matrix.calculateDeterminant(); // 384
        matrix.setMatrixElem(2, 2, 10);
        assertEquals(640, matrix.calculateDeterminant(), 0.001);
    }

    @Test
    public void getSizeTest() {
        assertEquals(3, dm1.getSize(), 0.001);
    }

    @Test
    public void equalsTest1() {
        DiagMatrix dm4 = new DiagMatrix(dm1.getSize());
        for (int i = 0; i < dm1.getSize(); i++) {
            dm4.setMatrixElem(i, i, dm1.getMatrixElem(i, i));
        }
        assertTrue(dm1.equals(dm4));
    }
}
