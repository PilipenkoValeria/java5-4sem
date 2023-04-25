package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpTriangleMatrixTest {
    UpTriangleMatrix utm1 = new UpTriangleMatrix(3);

    @Before
    public void setup() {
        utm1.elements = new double[]
                       {1, 2, 3,
                        0, 3, 3,
                        0, 0, 9};
    }

    @Test
    public void setMatrixElemTest0() {
        utm1.setMatrixElem(1, 2, 4);
        assertEquals(4, utm1.getMatrixElem(1, 2), 0.001);
    }

    @Test
    public void setMatrixElemTest1() {
        utm1.setMatrixElem(1, 1, 4);
        assertEquals(4, utm1.getMatrixElem(1, 1), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMatrixElemTestBad() {
        utm1.setMatrixElem(2, 0, 4);
    }

    @Test
    public void calculateDeterminantTest0() {
        assertEquals(27, utm1.calculateDeterminant(), 0.001);
    }

    @Test
    public void determinantIsCorrectTest0() {
        Matrix matrix = new UpTriangleMatrix(3);
        matrix.elements = new double[]
                       {2, 4, 6,
                        0, 3, 3,
                        0, 0, 9};
        matrix.calculateDeterminant(); // 54
        matrix.setMatrixElem(1, 1, 5);
        assertEquals(54, matrix.calculateDeterminant(), 0.001);
    }

    @Test
    public void determinantIsCorrectTest1() {
        Matrix matrix = new UpTriangleMatrix(4);
        matrix.elements = new double[]
                       {2, 4, 6, 8,
                        0, 3, 3, 3,
                        0, 0, 6, 9,
                        0, 0, 0, 7};
        matrix.calculateDeterminant(); // 252
        matrix.setMatrixElem(1, 1, 5);
        assertEquals(252, matrix.calculateDeterminant(), 0.001);
    }

    @Test
    public void getSizeTest() {
        assertEquals(3, utm1.getSize());
    }

    @Test
    public void equalsTest() {
        UpTriangleMatrix utm2 = new UpTriangleMatrix(3);
        UpTriangleMatrix utm3 = new UpTriangleMatrix(3);
        utm1.elements = new double[]
                       {1, 2, 3,
                        0, 3, 3,
                        0, 0, 9};

        utm2.elements = new double[]
                       {1, 2, 3,
                        0, 3, 3,
                        0, 0, 9};
        utm3.elements = new double[]
                       {2, 4, 6,
                        0, 7, 7,
                        0, 0, 8};
        assertTrue(utm1.equals(utm2));
        assertFalse(utm1.equals(utm3));
    }
}