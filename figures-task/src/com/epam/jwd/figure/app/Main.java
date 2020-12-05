package com.epam.jwd.figure.app;

import com.epam.jwd.figure.logic.LineLogic;
import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.logic.SquareLogic;
import com.epam.jwd.figure.logic.TriangleLogic;
import com.epam.jwd.figure.view.LineView;
import com.epam.jwd.figure.view.PointView;
import com.epam.jwd.figure.view.SquareView;
import com.epam.jwd.figure.view.TriangleView;

public class Main {

    public static void main(String[] args) {

        PointView.outputPoints(PointLogic.createArray(4));
        LineView.outputLines(LineLogic.getInstance().createArray(2));
        TriangleView.outputTriangles(TriangleLogic.getInstance().createArray(2));
        SquareView.outputSquares(SquareLogic.getInstance().createArray(1));
    }

}