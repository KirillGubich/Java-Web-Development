package main.java.com.epam.jwd.figure.strategy;

import main.java.com.epam.jwd.figure.model.impl.MultiAngleFigure;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.model.Figure;

public enum MultiAngleFigurePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double calculateArea(Figure figure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;

        double firstTerm = 0;
        double secondTerm = 0;
        double thirdTerm = 0;
        double fourthTerm = 0;

        for (int i = 0; i < multiAngleFigure.getPoints().length - 1; i++) {
            firstTerm += multiAngleFigure.getPoints()[i].getX() * multiAngleFigure.getPoints()[i + 1].getY();
        }

        for (int i = 0; i < multiAngleFigure.getPoints().length - 1; i++) {
            secondTerm += multiAngleFigure.getPoints()[i + 1].getX() * multiAngleFigure.getPoints()[i].getY();
        }

        thirdTerm = multiAngleFigure.getPoints()[multiAngleFigure.getPoints().length - 1].getX()
                * multiAngleFigure.getPoints()[0].getY();
        fourthTerm = multiAngleFigure.getPoints()[0].getX()
                * multiAngleFigure.getPoints()[multiAngleFigure.getPoints().length - 1].getY();

        return 0.5 * Math.abs(firstTerm + thirdTerm - secondTerm - fourthTerm);
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;

        double perimeter = 0;

        for (int i = 0; i < multiAngleFigure.getAmountOfAngles() - 1; i++) {
            Point firstPoint = multiAngleFigure.getPoints()[i];
            Point secondPoint = multiAngleFigure.getPoints()[i + 1];

            perimeter += PointLogic.getDistance(firstPoint, secondPoint);
        }
        perimeter += PointLogic.getDistance(multiAngleFigure.getPoints()[0],
                multiAngleFigure.getPoints()[multiAngleFigure.getAmountOfAngles() - 1]);

        return perimeter;
    }

}
