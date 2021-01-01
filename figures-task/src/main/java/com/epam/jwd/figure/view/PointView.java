package main.java.com.epam.jwd.figure.view;

import main.java.com.epam.jwd.figure.model.impl.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class PointView {

    private static final Logger LOGGER = LogManager.getLogger(PointView.class);

    public static void outputPoints(List<Point> points) {
        int i = 0;
        do {
            LOGGER.info(points.get(i));
            i++;
        } while (i < points.size());
    }

}
