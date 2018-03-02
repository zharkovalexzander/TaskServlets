package com.task.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Point> read() {
        List<Point> points = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] liner = line.split(",");
                Point point = new Point(Integer.valueOf(liner[0]),
                        Integer.valueOf(liner[1]));
                points.add(point);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(points);
        return points;
    }
}

