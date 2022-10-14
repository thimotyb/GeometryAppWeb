package com.awacademy.geometryweb;

import com.awacademy.geometry.base.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
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

}
