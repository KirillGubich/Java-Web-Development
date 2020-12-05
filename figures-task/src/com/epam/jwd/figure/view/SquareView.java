package com.epam.jwd.figure.view;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareView {

    private static final Logger LOGGER = LogManager.getLogger(SquareView.class);

    public static void outputSquares(Square[] squares) {
        for (Square square : squares) {
            if (square.isExist()) {
                LOGGER.info(square);
            } else if (PointLogic.hasSamePoints(square.getA(), square.getB(), square.getC(), square.getD())) {
                LOGGER.error("Object " + square + " is not a square shape");
            } else {
                LOGGER.error("Object " + square + " is not a square");
            }
        }
    }
}
