package com.epam.jwd.figure.strategy;

import com.epam.jwd.figure.logic.TriangleLogic;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.Triangle;

public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {

    private TrianglePropertiesStrategy() {
    }

    private static class TrianglePropertiesStrategyHolder {
        private final static TrianglePropertiesStrategy instance = new TrianglePropertiesStrategy();
    }

    public static TrianglePropertiesStrategy getInstance() {
        return TrianglePropertiesStrategyHolder.instance;
    }

    @Override
    public double calculateArea(Figure figure) {

        Triangle triangle = (Triangle) figure;
        double[] sides;
        sides = TriangleLogic.getInstance().fetchTriangleSides(triangle);

        double halfPerimeter;
        halfPerimeter = (sides[0] + sides[1] + sides[2]) / 3;

        return Math.sqrt(halfPerimeter * (halfPerimeter - sides[0]) *
                (halfPerimeter - sides[1]) * (halfPerimeter - sides[2]));
    }

    @Override
    public double calculatePerimeter(Figure figure) {

        Triangle triangle = (Triangle) figure;
        double[] sides;
        sides = TriangleLogic.getInstance().fetchTriangleSides(triangle);

        return sides[0] + sides[1] + sides[2];
    }
}
