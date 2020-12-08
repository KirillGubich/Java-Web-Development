package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureHasSamePointsException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.exception.NumberOfFiguresExceededException;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.ApplicationContext;
import com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import com.epam.jwd.figure.model.impl.SimpleFigureFactory;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.model.impl.PointFactory;
import com.epam.jwd.figure.model.impl.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareLogic {

    private static SquareLogic instance;
    private static final Logger LOGGER = LogManager.getLogger(SquareLogic.class);

    private SquareLogic() {
    }

    public static SquareLogic getInstance() {
        if (instance == null) {
            instance = new SquareLogic();
        }
        return instance;
    }

    public Square[] createArray(int count) {
        Square[] squares = new Square[count];

        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(i, 0);
            Point b = PointFactory.createPoint(i + 2, 0);
            Point c = PointFactory.createPoint(i + 2, i + 2);
            Point d = PointFactory.createPoint(0, i + 2);

            try {
                final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
                final FigureFactory figureFactory = applicationContext.createFigureFactory();

                squares[i] = (Square) figureFactory.createFigure(FigureType.SQUARE, a, b, c, d);
            } catch (FigureNotExistException e) {
                LOGGER.error("Figure not exist");
                e.printStackTrace();
            } catch (FigureHasSamePointsException e) {
                LOGGER.error("Figure has same points");
                e.printStackTrace();
            } catch (NumberOfFiguresExceededException e) {
                LOGGER.error("Number of figures exceeded");
                e.printStackTrace();
            } catch (FigureException e) {
                LOGGER.error("Figure exception");
                e.printStackTrace();
            }
        }

        return squares;
    }

    public double[] fetchSquareSides(Square square) {

        final int SIDE_COUNT = 4;
        double[] sqrSides = new double[SIDE_COUNT];

        sqrSides[0] = PointLogic.getDistance(square.getA(), square.getB());
        sqrSides[1] = PointLogic.getDistance(square.getB(), square.getC());
        sqrSides[2] = PointLogic.getDistance(square.getC(), square.getD());
        sqrSides[3] = PointLogic.getDistance(square.getD(), square.getA());

        return sqrSides;
    }

}
