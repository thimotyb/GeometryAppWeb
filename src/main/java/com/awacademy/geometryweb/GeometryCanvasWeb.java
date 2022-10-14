package com.awacademy.geometryweb;

import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.shapes.Circle;
import com.awacademy.geometry.shapes.Rectangle;
import com.awacademy.geometry.shapes.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Possible REST Interface:
 *
 * GET /shapes == GETs all the shapes currently in memory
 * GET /shapes/<shapetype> == GETs all the shapes currently in memory for that shape type
 * GET /shapes/totalArea == GETs the total area of all the shapes
 *
 * POST /shapes
 *    (body: the JSON of a Shape, Circle, Rectangle, a Square...)
 *
 * POST /shapes/circle/<x>/<y>/<radius> *
 * POST /shapes/square/<x>/<y>/<sideLength>
 * POST /shapes/rectangle/<x>/<y>/<height>/<width>
 *
 * PUT: How to modify a specific shape? We don't have (yet) a way to "identify" a specific instance of a specific shape
 *
 */
@RestController
@RequestMapping("/shapes")
public class GeometryCanvasWeb {

    @Autowired
    ShapeFactory factory;

    /**
     * An endpoint
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        List<Integer> myParams = new ArrayList<>();
        myParams.add(2); // x
        myParams.add(4); // y
        myParams.add(8); // radius
        Shape shape = factory.createShape(2, myParams);
        factory.setShape(shape, 2);
        //System.out.println(factory.getShapes("Circle"));
        return factory.getShapes("Circle").toString();

    }


    @PostMapping(value = "/circle/{x_center}/{y_center}/{radius}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Circle addCircle(@PathVariable int x_center, @PathVariable int y_center, @PathVariable int radius) {
        Circle c = null;
        List<Integer> myParams = new ArrayList<>();
        myParams.add(x_center); // x
        myParams.add(y_center); // y
        myParams.add(radius); // radius
        Shape shape = factory.createShape(2, myParams);
        factory.setShape(shape, 2);
        c = (Circle)shape;
        return c;
    }

    @PostMapping(value = "/square/{x_center}/{y_center}/{sideLength}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Square addSquare(@PathVariable int x_center, @PathVariable int y_center, @PathVariable int sideLength) {
        Square s = null;
        List<Integer> myParams = new ArrayList<>();
        myParams.add(x_center); // x
        myParams.add(y_center); // y
        myParams.add(sideLength); // side
        Shape shape = factory.createShape(1, myParams);
        factory.setShape(shape, 1);
        s = (Square)shape;
        return s;
    }

    @PostMapping(value = "/rectangle/{x_center}/{y_center}/{height}/{width}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rectangle addRectangle(@PathVariable int x_center, @PathVariable int y_center, @PathVariable int height, @PathVariable int width) {
        Rectangle r = null;
        List<Integer> myParams = new ArrayList<>();
        myParams.add(x_center); // x
        myParams.add(y_center); // y
        myParams.add(height); // height
        myParams.add(width);
        Shape shape = factory.createShape(3, myParams);
        factory.setShape(shape, 3);
        r = (Rectangle)shape;
        return r;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shape> getAllShapes() {
        List<Shape> allShapes = new ArrayList<>();
        for (String key: ShapeFactory.myShapeDictionary.keySet()) {
            List<Shape> array = ShapeFactory.myShapeDictionary.get(key);
            if (array.size() > 0) {
                allShapes.addAll(array);
            }
        }
        return allShapes;
    }

 /*   @GetMapping(value = "/")
    public String getAllShapes() {
        StringBuilder allShapes = new StringBuilder();
        for (String key: ShapeFactory.myShapeDictionary.keySet()) {
            List<Shape> array = ShapeFactory.myShapeDictionary.get(key);
            if (array.size() > 0) {
                allShapes.append(array.toString());
            }
        }
        return allShapes.toString();
    }*/


}
