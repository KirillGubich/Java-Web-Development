package main.java.com.epam.jwd.figure.logic;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.exception.FigureHasSamePointsException;
import main.java.com.epam.jwd.figure.exception.FigureNotExistException;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.ApplicationContext;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.model.impl.Line;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.model.impl.PointFactory;
import main.java.com.epam.jwd.figure.model.impl.SimpleApplicationContext;
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
                ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
                FigureFactory figureFactory = applicationContext.createFigureFactory();

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
