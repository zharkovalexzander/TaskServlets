package com.task.servlets.servlet;

import com.task.servlets.files.FileReader;
import com.task.servlets.geometry.Line;
import com.task.servlets.geometry.Point;
import com.task.servlets.geometry.PointProcessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int aParam = processIntegerParam("A", request);
        int bParam = processIntegerParam("B", request);
        int cParam = processIntegerParam("C", request);
        double dis = processDoubleParam("distance", request);

        FileReader fileReader = new FileReader("D:\\abc.txt");
        List<Point> points = fileReader.read();
        Line line = new Line(aParam, bParam, cParam);
        PointProcessor pointProcessor = new PointProcessor(points, line, dis);

        Map<Double, Point> filteredPoints = pointProcessor.resolve();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        int count = 0;
        for(Map.Entry<Double, Point> pointEntry : filteredPoints.entrySet()) {
            String prepared = "<div";
            if (count == 0) {
                prepared += " style=\"color:green\"";
            } else if (count == filteredPoints.entrySet().size() - 1) {
                prepared += " style=\"color:red\"";
            }
            prepared += ">";
            out.println(prepared + pointEntry.getValue().toString()
                    + " ---> "
                    + pointEntry.getKey().toString()
                    + "</div>");
            count++;
        }
    }
    @Override
    public String getServletInfo() {
        return "Task with servlets";
    }

    private int processIntegerParam(String paramName, HttpServletRequest request) {
        return (request.getParameter(paramName).length() == 0)
                ? 1 : Integer.valueOf(request.getParameter(paramName));
    }

    private double processDoubleParam(String paramName, HttpServletRequest request) {
        return (request.getParameter(paramName).length() == 0)
                ? 1.0 : Double.valueOf(request.getParameter(paramName));
    }
}
