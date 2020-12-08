package com.epam.jwd.figure.strategy;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.model.impl.Point;

public enum MultiAngleFigurePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double calculateArea(Figure figure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;

        double firstTerm = 0;
        double secondTerm = 0;
        double thirdTerm = 0;
        double fourthTerm = 0;

        for (int i = 0; i < multiAngleFigure.getPOINTS().length - 1; i++) {
            firstTerm += multiAngleFigure.getPOINTS()[i].getX() * multiAngleFigure.getPOINTS()[i + 1].getY();
        }

        for (int i = 0; i < multiAngleFigure.getPOINTS().length - 1; i++) {
            secondTerm += multiAngleFigure.getPOINTS()[i + 1].getX() * multiAngleFigure.getPOINTS()[i].getY();
        }

        thirdTerm = multiAngleFigure.getPOINTS()[multiAngleFigure.getPOINTS().length - 1].getX()
                * multiAngleFigure.getPOINTS()[0].getY();
        fourthTerm = multiAngleFigure.getPOINTS()[0].getX()
                * multiAngleFigure.getPOINTS()[multiAngleFigure.getPOINTS().length - 1].getY();

        return 0.5 * Math.abs(firstTerm + thirdTerm - secondTerm - fourthTerm);
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;

        double perimeter = 0;

        for (int i = 0; i < multiAngleFigure.getAMOUNT_OF_ANGLES() - 1; i++) {
            Point firstPoint = multiAngleFigure.getPOINTS()[i];
            Point secondPoint = multiAngleFigure.getPOINTS()[i + 1];

            perimeter += PointLogic.getDistance(firstPoint, secondPoint);
        }
        perimeter += PointLogic.getDistance(multiAngleFigure.getPOINTS()[0],
                multiAngleFigure.getPOINTS()[multiAngleFigure.getAMOUNT_OF_ANGLES() - 1]);

        return perimeter;
    }

}
