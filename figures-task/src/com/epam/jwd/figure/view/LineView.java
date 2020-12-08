package com.epam.jwd.figure.view;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.impl.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineView {

    private static final Logger LOGGER = LogManager.getLogger(LineView.class);

    public static void outputLines(Line[] lines) {
        for (Line line : lines) {
            if (!PointLogic.hasSamePoints(line.getA(), line.getB())) {
                LOGGER.info(line);

            } else {
                LOGGER.error("Object " + line + " is not a line");
            }
        }
    }
}
