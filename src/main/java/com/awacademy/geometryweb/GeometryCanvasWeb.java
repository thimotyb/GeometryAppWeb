package com.awacademy.geometryweb;

import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.shapes.Circle;
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

    /*@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shape> getAllShapes() {
        List<Shape> allShapes = new ArrayList<>();
        // TODO: This is not OCP, we will have to modify it
        allShapes.addAll(factory.getShapes("Circle"));
        allShapes.addAll(factory.getShapes("Square"));
        allShapes.addAll(factory.getShapes("Rectangle"));
        return allShapes;
    }*/

    @GetMapping(value = "/")
    public String getAllShapes() {
        StringBuilder allShapes = new StringBuilder();
        for (String key: ShapeFactory.myShapeDictionary.keySet()) {
            List<Shape> array = ShapeFactory.myShapeDictionary.get(key);
            if (array.size() > 0) {
                allShapes.append(array.toString());
            }
        }
        return allShapes.toString();
    }


}
