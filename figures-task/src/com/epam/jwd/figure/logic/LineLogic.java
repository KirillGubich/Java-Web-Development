package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.FigureFactory;
import com.epam.jwd.figure.model.Line;
import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.PointFactory;

public class LineLogic {

    public boolean hasSamePoints(Line line) {
        return line.getA().equals(line.getB());
    }

    public static Line[] createArray(int count) {
        Line[] lines = new Line[count];

        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(3 * i, i - 3);
            Point b = PointFactory.createPoint(2 + i, -2 * i);
            lines[i] = (Line) FigureFactory.createFigure("Line", a, b);
        }

        return lines;
    }
}
