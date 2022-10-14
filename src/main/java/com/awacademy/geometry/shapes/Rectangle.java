package com.awacademy.geometry.shapes;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;

public class Rectangle implements Shape {

    // USe the same ideas
    Point topLeftCorner;
    int width;
    int height;

    public Rectangle(Point topLeftCorner, int width, int height) {
        this.topLeftCorner = topLeftCorner;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topLeftCorner=" + topLeftCorner +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public double calculatePerimeter() {
        return (width*2)+(height*2);
    }

    public double calculateArea() {
        return width*height;
    }

}
