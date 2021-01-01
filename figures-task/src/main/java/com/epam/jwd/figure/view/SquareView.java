package main.java.com.epam.jwd.figure.view;

import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.model.impl.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SquareView {

    private static final Logger LOGGER = LogManager.getLogger(SquareView.class);

    public static void outputSquares(List<Square> squares) {
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
