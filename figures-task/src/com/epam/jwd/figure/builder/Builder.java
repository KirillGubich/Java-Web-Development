package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.FigureType;

public interface Builder {

    void reset();

    void setFigureType(FigureType figureType);

    void setArea(double area);

    void setPerimeter(double perimeter);
}
