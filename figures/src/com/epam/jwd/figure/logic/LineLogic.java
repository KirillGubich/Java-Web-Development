package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Line;
import com.epam.jwd.figure.model.Point;

public class LineLogic {

    private final PointLogic POINT_LOGIC;

    public LineLogic(PointLogic POINT_LOGIC) {
        this.POINT_LOGIC = POINT_LOGIC;
    }

    public boolean hasSamePoints(Line line) {
        return line.getA().equals(line.getB());
    }

    private Line createLine(double x1, double y1, double x2, double y2) {
        Point a = POINT_LOGIC.createPoint(x1, y1);
        Point b = POINT_LOGIC.createPoint(x2, y2);

        return new Line(a, b);
    }

    public Line[] createArray(int count) {
        Line[] lines = new Line[count];

        for (int i = 0; i < count; i++) {
            lines[i] = createLine(3 * i, i - 3, 2 + i, -2 * i);
        }

        return lines;
    }
}
