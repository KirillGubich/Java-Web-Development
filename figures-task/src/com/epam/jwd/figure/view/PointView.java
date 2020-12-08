package com.epam.jwd.figure.view;

import com.epam.jwd.figure.model.impl.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointView {

    private static final Logger LOGGER = LogManager.getLogger(PointView.class);

    public static void outputPoints(Point[] points) {
        int i = 0;
        do {
            LOGGER.info(points[i]);
            i++;
        } while (i < points.length);
    }

}
