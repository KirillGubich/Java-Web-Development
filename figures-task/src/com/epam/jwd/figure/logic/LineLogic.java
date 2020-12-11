package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureHasSamePointsException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.ApplicationContext;
import com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.model.impl.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

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

    public List<Line> createList(int count) {
        List<Line> lines = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(3 * i, i - 3);
            Point b = PointFactory.createPoint(2 + i, -2 + i);
            try {
                final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
                final FigureFactory figureFactory = applicationContext.createFigureFactory();

                lines.add((Line) figureFactory.createFigure(FigureType.LINE, a, b));
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

        return lines;
    }
}
