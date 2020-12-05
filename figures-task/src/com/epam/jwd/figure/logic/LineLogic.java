package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureHasSamePointsException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.exception.NumberOfFiguresExceededException;
import com.epam.jwd.figure.model.FigureFactory;
import com.epam.jwd.figure.model.Line;
import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineLogic {

    private static LineLogic instance;
    private static final Logger LOGGER = LogManager.getLogger(LineLogic.class);

    private LineLogic() {
    }

    public static LineLogic getInstance() {
        if (instance == null) {
            instance = new LineLogic();
        }
        return instance;
    }

    public Line[] createArray(int count) {
        Line[] lines = new Line[count];
        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(3 * i, i - 3);
            Point b = PointFactory.createPoint(2 + i, -2 + i);
            try {
                lines[i] = (Line) FigureFactory.createFigure("Line", a, b);
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

        return lines;
    }
}
