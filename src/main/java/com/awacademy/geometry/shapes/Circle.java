package com.awacademy.geometry.shapes;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;

public class Circle implements Shape {

    Point center;
    int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public double calculateArea() {
        return 3.14d*radius*radius;
    }

    public double calculatePerimeter() {
        return 2 * 3.14d * radius;
    }

}
