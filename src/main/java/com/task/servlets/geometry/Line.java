package com.task.servlets.geometry;

public class Line {
    private int A, B, C;

    public Line(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public int getC() {
        return C;
    }

    public void setB(int b) {
        B = b;
    }

    public void setC(int c) {
        C = c;
    }

    public void setA(int a) {
        A = a;
    }
}
