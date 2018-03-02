package com.task.servlets;

import java.util.*;

public class PointProcessor {
    private List<Point> points;
    private Line line;
    private double distance;

    public PointProcessor(List<Point> points, Line line, double distance) {
        this.points = points;
        this.line = line;
        this.distance = distance;
    }

    public Map<Double, Point> resolve() {
        HashMap<Double, Point> hm = new HashMap<>();
        for (Point point : this.points) {
            double calc = calculateDistance(point);
            //if(calculateDistance(point) <= this.distance) {
                hm.put(calc, point);
            //}
        }
        return new TreeMap<>(hm);
    }

    private double calculateDistance(Point point) {
        return Math.abs(line.getA() * point.getX() + line.getB() * point.getY() + line.getC())
        / (Math.sqrt((line.getA() * line.getA()) + (line.getB() * line.getB())));
    }
}
