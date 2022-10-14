package com.awacademy.geometry.factory;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.base.ShapeCreator;
import com.awacademy.geometry.shapes.Rectangle;

import java.util.Scanner;

public class RectangleCreator implements ShapeCreator {

    @Override
    public Shape askDataAndCreateShape(Scanner sc) {
        System.out.println("x-coordinate of upper left corner?");
        int x = sc.nextInt();
        System.out.println("y-coordinate of upper left corner?");
        int y = sc.nextInt();
        System.out.println("Length of width?");
        int length = sc.nextInt();
        System.out.println("Length of height?");
        int length2 = sc.nextInt();
        Point corner1 = new Point(x, y);
        Rectangle rectangle = new Rectangle(corner1, length, length2);
        return rectangle;
    }

}
