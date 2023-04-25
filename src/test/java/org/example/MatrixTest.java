package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    Matrix m1 = new Matrix(3);
    Matrix m2 = new Matrix(4);


    @Before
    public void setUp() {
        m1.elements = new double[]
                {1, 5, 25,
                        1, 7, 49,
                        1, 8, 64};
        m2.elements = new double[]
                {2, -5, 1, 2,
                        -3, 7, -1, 4,
                        5, -9, 2, 7,
                        4, -6, 1, 2};

    }

    @Test
    public void getMatrixElemTest0() {
        Assert.assertEquals(1, m1.getMatrixElem(0, 0), 0.001);
    }

    @Test
    public void getMatrixElemTest1() {
        Assert.assertEquals(7, m1.getMatrixElem(1, 1), 0.001);
    }

    @Test
    public void getMatrixElemTest2() {
        Assert.assertEquals(25, m1.getMatrixElem(0, 2), 0.001);
    }

    @Test
    public void setMatrixElemTest0() {
        m1.setMatrixElem(0, 2, 999);
        Assert.assertEquals(999, m1.getMatrixElem(0, 2), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMatrixElemTestException() {
        m1.setMatrixElem(0, 4, 999);
    }

    @Test
    public void getSizeTest() {
        Assert.assertEquals(3, m1.getSize());
    }

    @Test
    public void calculateDeterminantTest0() {
        Assert.assertEquals(6, m1.calculateDeterminant(), 0.001);
    }

    @Test
    public void calculateDeterminantTest1() {
        Assert.assertEquals(-9, m2.calculateDeterminant(), 0.001);
    }


    @Test
    public void determinantIsCorrectTest0() {
        Matrix matrix = new Matrix(3);
        matrix.elements = new double[]
                {1, 5, 25,
                        1, 7, 49,
                        1, 8, 64};
        matrix.calculateDeterminant(); // 6
        matrix.setMatrixElem(0, 1, 1);
        assertEquals(66, matrix.calculateDeterminant(), 0.001);
    }

    @Test
    public void determinantIsCorrectTest1() {
        Matrix matrix = new Matrix(4);
        matrix.elements = new double[]
                {2, -5, 1, 2,
                        -3, 7, -1, 4,
                        5, -9, 2, 7,
                        4, -6, 1, 2};
        matrix.calculateDeterminant(); // -9
        matrix.setMatrixElem(0, 1, 2);
        assertEquals(138, matrix.calculateDeterminant(), 0.001);
    }

    @Test
    public void equalsTest0() {
        assertNotEquals(m1, m2);
    }
}