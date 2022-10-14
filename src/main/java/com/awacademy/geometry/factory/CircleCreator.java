package com.awacademy.geometry.factory;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.base.ShapeCreator;
import com.awacademy.geometry.shapes.Circle;

import java.util.Scanner;

public class CircleCreator implements ShapeCreator {

    @Override
    public Shape askDataAndCreateShape(Scanner sc) {
        System.out.println("x-coordinate of center point?");
        int x = sc.nextInt();
        System.out.println("y-coordinate of center point?");
        int y = sc.nextInt();
        System.out.println("Radius?");
        int length = sc.nextInt();
        Point center = new Point(x, y);
        Circle circle = new Circle(center, length);

        return circle; // Polymorphism
    }

}
