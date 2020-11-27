package com.epam.jwd.figure.model;

import java.util.Arrays;

public class MultiAngleFigureFactory {

    private static final int MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES = 8;
    private static final MultiAngleFigure[] ALL_CREATED_MULTI_ANGLE_FIGURES =
            new MultiAngleFigure[MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES];
    private static int amountOfMultiAngleFigures;

    public static MultiAngleFigure createMultiAngleFigure(Point[] points) {

        return fetchMultiAngleFigureFromCacheOrCreate(points);
    }

    private static void addMultiAngleFigureToCache(MultiAngleFigure multiAngleFigure) {
        amountOfMultiAngleFigures++;
        ALL_CREATED_MULTI_ANGLE_FIGURES[amountOfMultiAngleFigures - 1] = multiAngleFigure;
    }

    private static MultiAngleFigure fetchMultiAngleFigureFromCacheOrCreate(Point[] points) {

        for (int i = 0; i < amountOfMultiAngleFigures; i++) {
            if (Arrays.equals(ALL_CREATED_MULTI_ANGLE_FIGURES[i].getPoints(), points)) {
                return ALL_CREATED_MULTI_ANGLE_FIGURES[i];
            }
        }

        if (amountOfMultiAngleFigures == MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES) {
            return null;
        }

        MultiAngleFigure multiAngleFigure = new MultiAngleFigure(points);
        addMultiAngleFigureToCache(multiAngleFigure);
        return multiAngleFigure;
    }

}
