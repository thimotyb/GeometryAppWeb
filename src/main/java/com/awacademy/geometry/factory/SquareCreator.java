package com.awacademy.geometry.factory;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.base.ShapeCreator;
import com.awacademy.geometry.shapes.Square;

import java.util.Scanner;

public class SquareCreator implements ShapeCreator {
    @Override
    public Shape askDataAndCreateShape(Scanner sc) {
        System.out.println("x-coordinate of upper left corner?");
        int x = sc.nextInt();
        System.out.println("y-coordinate of upper left corner?");
        int y = sc.nextInt();
        System.out.println("Length of side?");
        int length = sc.nextInt();
        Point corner1 = new Point(x, y);
        Square square = new Square(corner1, length);
        return square;
    }
}
