package com.awacademy.geometry.shapes;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;

public class Square implements Shape {

    // Fields
    Point topLeftCorner;
    int sideLength;

    // Pattern: Instance State Injection via Constructor
    public Square(Point topLeftCorner, int sideLength) {
        this.topLeftCorner = topLeftCorner;
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "topLeftCorner=" + topLeftCorner +
                ", sideLength=" + sideLength +
                '}';
    }

    public double calculatePerimeter() {
        return sideLength*4;
    }

    public double calculateArea() {
        return sideLength*sideLength;
    }

}
