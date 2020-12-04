package com.epam.jwd.figure.view;

import com.epam.jwd.figure.logic.LineLogic;
import com.epam.jwd.figure.model.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineView {

    private static final Logger LOGGER = LogManager.getLogger(LineView.class);

    public static void outputLines(Line[] lines) {
        LineLogic lineLogic = new LineLogic();
        for (Line line : lines) {
            if (!lineLogic.hasSamePoints(line)) {
                LOGGER.info(line);

            } else {
                LOGGER.error("Object " + line + " is not a line");
            }
        }
    }
}
