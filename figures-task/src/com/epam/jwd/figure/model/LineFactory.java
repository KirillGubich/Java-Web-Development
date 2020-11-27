package com.epam.jwd.figure.model;

public class LineFactory {

    private static final int MAX_AMOUNT_OF_LINES = 32;
    private static final Line[] ALL_CREATED_LINES = new Line[MAX_AMOUNT_OF_LINES];
    private static int amountOfLines;

    public static Line createLine(Point a, Point b) {

        return fetchLineFromCacheOrCreate(a, b);
    }

    private static void addLineToCache(Line line) {
        amountOfLines++;
        ALL_CREATED_LINES[amountOfLines - 1] = line;
    }

    private static Line fetchLineFromCacheOrCreate(Point a, Point b) {

        for (int i = 0; i < amountOfLines; i++) {
            if (ALL_CREATED_LINES[i].getA().equals(a) && ALL_CREATED_LINES[i].getB().equals(b)) {
                return ALL_CREATED_LINES[i];
            }
        }

        if (amountOfLines == MAX_AMOUNT_OF_LINES) {
            return null;
        }

        Line line = new Line(a, b);
        addLineToCache(line);
        return line;
    }
}
