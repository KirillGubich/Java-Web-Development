package main.java.com.epam.jwd.figure.strategy;

import main.java.com.epam.jwd.figure.model.impl.Square;
import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.model.Figure;

public final class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    private static SquarePropertiesStrategy instance;

    private SquarePropertiesStrategy() {
    }

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculateArea(Figure figure) {
        Square square = (Square) figure;
        double sideSize;
        sideSize = PointLogic.getDistance(square.getA(), square.getB());

        return Math.pow(sideSize, 2);
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        Square square = (Square) figure;
        double sideSize;
        sideSize = PointLogic.getDistance(square.getA(), square.getB());

        return 4 * sideSize;
    }
}
