package com.epam.jwd.figure.strategy;

import com.epam.jwd.figure.model.Figure;

public interface FigurePropertiesStrategy {

    double calculateArea(Figure figure);

    double calculatePerimeter(Figure figure);

}
