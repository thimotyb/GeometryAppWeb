package com.awacademy.geometryweb;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.factory.CircleCreator;
import com.awacademy.geometry.factory.RectangleCreator;
import com.awacademy.geometry.factory.SquareCreator;
import com.awacademy.geometry.shapes.Circle;
import com.awacademy.geometry.shapes.Rectangle;
import com.awacademy.geometry.shapes.Square;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ShapeFactory {

    public static LinkedHashMap<Integer, String> supportedShapes = new LinkedHashMap<>();
    public static Map<String, List<Shape>> myShapeDictionary = new LinkedHashMap<>();

    public ShapeFactory() {
        supportedShapes.put(Integer.valueOf(1), "Square");
        supportedShapes.put(Integer.valueOf(2), "Circle");
        supportedShapes.put(Integer.valueOf(3), "Rectangle");

        for (int i: ShapeFactory.supportedShapes.keySet()) {
            myShapeDictionary.put(ShapeFactory.supportedShapes.get(i), new ArrayList<Shape>());
        }
    }

    public List<Shape> getShapes(String key) {
        return myShapeDictionary.get(key);
    }

    // TODO: It would  be beautiful if I didn't need to specify the ShapeType
    public void setShape(Shape shape, int shapeType) {
        myShapeDictionary.get(ShapeFactory.supportedShapes.get(shapeType)).add(shape);
    }

    // TODO: I don't like this very much, it is difficult to remember the meaning of the params I am passing
    public Shape createShape(int shape, List<Integer> params) {
        switch(shape) {
            case 1: // Square
                Point p = new Point(params.get(0), params.get(1));
                int sideLength = params.get(2);
                return new Square(p, sideLength);
            case 2: // Circle
                Point center = new Point(params.get(0), params.get(1));
                int radius = params.get(2);
                return new Circle(center, radius);
            case 3: // Rectangle
                Point topLeftCorner = new Point(params.get(0), params.get(1));
                int width = params.get(2);
                int height = params.get(3);
                return new Rectangle(topLeftCorner, width, height);
            default:
                return null;
        }
    }

    public Shape createShape(int shape, Scanner sc) {
        switch(shape) {
            case 1: // Square
                return new SquareCreator().askDataAndCreateShape(sc);
            case 2: // Circle
                return new CircleCreator().askDataAndCreateShape(sc);
            case 3: // Rectangle
                return new RectangleCreator().askDataAndCreateShape(sc);
            default:
                return null;
        }
    }
}
