package com.awacademy.geometry.base;

public class PointWithColour extends Point {

    int colour = 1;

    public PointWithColour(int first_coordinate, int second_coordinate, int colour) {
        super(first_coordinate, second_coordinate);
        this.colour = colour;
    }
}
