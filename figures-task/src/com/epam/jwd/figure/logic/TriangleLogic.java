package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureHasSamePointsException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.ApplicationContext;
import com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.model.impl.PointFactory;
import com.epam.jwd.figure.model.impl.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleLogic {

    private static TriangleLogic instance;
    private static final Logger LOGGER = LogManager.getLogger(TriangleLogic.class);

    private TriangleLogic() {
    }

    public static TriangleLogic getInstance() {
        if (instance == null) {
            instance = new TriangleLogic();
        }

        return instance;
    }

    public List<Triangle> createList(int count) {
        List<Triangle> triangles = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(2 * i, 4 * i);
            Point b = PointFactory.createPoint(1 + i, i - 5);
            Point c = PointFactory.createPoint(2 + i, i - 2);
            try {
                final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
                final FigureFactory figureFactory = applicationContext.createFigureFactory();

                triangles.add((Triangle) figureFactory.createFigure(FigureType.TRIANGLE, a, b, c));
            } catch (FigureNotExistException e) {
                LOGGER.error("Figure not exist");
                e.printStackTrace();
            } catch (FigureHasSamePointsException e) {
                LOGGER.error("Figure has same points");
                e.printStackTrace();
            } catch (FigureException e) {
                LOGGER.error("Figure exception");
                e.printStackTrace();
            }
        }

        return triangles;
    }

    public double[] fetchTriangleSides(Triangle triangle) {
        final int SIDE_COUNT = 3;
        double[] triangleSides = new double[SIDE_COUNT];

        triangleSides[0] = PointLogic.getDistance(triangle.getA(), triangle.getB());
        triangleSides[1] = PointLogic.getDistance(triangle.getB(), triangle.getC());
        triangleSides[2] = PointLogic.getDistance(triangle.getA(), triangle.getC());

        return triangleSides;
    }
}
