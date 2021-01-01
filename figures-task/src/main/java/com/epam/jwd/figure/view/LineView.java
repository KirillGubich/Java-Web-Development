package main.java.com.epam.jwd.figure.view;

import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.model.impl.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LineView {

    private static final Logger LOGGER = LogManager.getLogger(LineView.class);

    public static void outputLines(List<Line> lines) {
        for (Line line : lines) {
            if (!PointLogic.hasSamePoints(line.getA(), line.getB())) {
                LOGGER.info(line);

            } else {
                LOGGER.error("Object " + line + " is not a line");
            }
        }
    }
}
