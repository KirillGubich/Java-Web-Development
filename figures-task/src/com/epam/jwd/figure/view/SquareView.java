package com.epam.jwd.figure.view;

import com.epam.jwd.figure.logic.SquareLogic;
import com.epam.jwd.figure.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareView {

    private static final Logger LOGGER = LogManager.getLogger(SquareView.class);

    public static void outputSquares(Square[] squares) {
        SquareLogic squareLogic = new SquareLogic();
        for (Square square : squares) {
            if (squareLogic.isExist(square)) {
                LOGGER.info(square);
            } else if (squareLogic.hasSamePoints(square)) {
                LOGGER.error("Object " + square + " is not a square shape");
            } else {
                LOGGER.error("Объект " + square + " is not a square");
            }
        }
    }
}
