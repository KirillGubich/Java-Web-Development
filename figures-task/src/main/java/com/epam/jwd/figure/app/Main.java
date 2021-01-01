package main.java.com.epam.jwd.figure.app;

import main.java.com.epam.jwd.figure.logic.LineLogic;
import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.logic.SquareLogic;
import main.java.com.epam.jwd.figure.logic.TriangleLogic;
import main.java.com.epam.jwd.figure.view.LineView;
import main.java.com.epam.jwd.figure.view.PointView;
import main.java.com.epam.jwd.figure.view.SquareView;
import main.java.com.epam.jwd.figure.view.TriangleView;

public class Main {

    public static void main(String[] args) {
        PointView.outputPoints(PointLogic.createList(4));
        LineView.outputLines(LineLogic.getInstance().createList(2));
        TriangleView.outputTriangles(TriangleLogic.getInstance().createList(2));
        SquareView.outputSquares(SquareLogic.getInstance().createList(1));
    }
}