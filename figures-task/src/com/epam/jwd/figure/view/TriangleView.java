package com.epam.jwd.figure.view;

import com.epam.jwd.figure.logic.TriangleLogic;
import com.epam.jwd.figure.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleView {

    private static final Logger LOGGER = LogManager.getLogger(TriangleView.class);

    public static void outputTriangles(Triangle[] triangles) {
        TriangleLogic triangleLogic = new TriangleLogic();
        for (Triangle triangle : triangles) {
            if (triangleLogic.isExist(triangle)) {
                LOGGER.info(triangle);
            } else if (triangleLogic.hasSamePoints(triangle)) {
                LOGGER.error("Object " + triangle + " is not a triangle shape");
            } else {
                LOGGER.error(triangle + " can not exist");
            }
        }
    }
}
