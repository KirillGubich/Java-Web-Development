package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.builder.FigureCriteria;
import main.java.com.epam.jwd.figure.model.Figure;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FigureSearchService<T extends Figure, V extends FigureCriteria> {

    public T search(List<T> figures, T figure) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figureFromStorage -> figureFromStorage.equals(figure))
                .findAny()
                .orElse(null);
    }

    public T searchByID(List<T> figures, long id) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.getID() == id)
                .findAny()
                .orElse(null);
    }

    public List<T> searchByPerimeter(List<T> figures, double perimeter) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.executeStrategy().calculatePerimeter(figure) == perimeter)
                .collect(Collectors.toList());
    }

    public List<T> searchByMinPerimeter(List<T> figures, double minPerimeter) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.executeStrategy().calculatePerimeter(figure) > minPerimeter)
                .collect(Collectors.toList());
    }

    public List<T> searchByMaxPerimeter(List<T> figures, double maxPerimeter) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.executeStrategy().calculatePerimeter(figure) < maxPerimeter)
                .collect(Collectors.toList());
    }

    public List<T> searchByArea(List<T> figures, double area) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.executeStrategy().calculateArea(figure) == area)
                .collect(Collectors.toList());
    }

    public List<T> searchByMinArea(List<T> figures, double minArea) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.executeStrategy().calculateArea(figure) > minArea)
                .collect(Collectors.toList());
    }

    public List<T> searchByMaxArea(List<T> figures, double maxArea) {
        return figures.stream()
                .filter(Objects::nonNull)
                .filter(figure -> figure.executeStrategy().calculateArea(figure) < maxArea)
                .collect(Collectors.toList());
    }

    public List<T> processCriteria(List<T> figures, V figureCriteria) {
        if (figureCriteria.getPerimeter() != 0) {
            figures = searchByPerimeter(figures, figureCriteria.getPerimeter());
        }
        if (figureCriteria.getMinPerimeter() != 0) {
            figures = searchByMinPerimeter(figures, figureCriteria.getMinPerimeter());
        }
        if (figureCriteria.getMaxPerimeter() != 0) {
            figures = searchByMaxPerimeter(figures, figureCriteria.getMaxPerimeter());
        }
        if ((figureCriteria.getArea() != 0)) {
            figures = searchByArea(figures, figureCriteria.getArea());
        }
        if ((figureCriteria.getMinArea() != 0)) {
            figures = searchByMinArea(figures, figureCriteria.getMinArea());
        }
        if ((figureCriteria.getMaxArea() != 0)) {
            figures = searchByMaxArea(figures, figureCriteria.getMaxArea());
        }

        return figures;
    }

    public boolean criteriaAreIncorrect(FigureCriteria figureCriteria) {
        boolean perimeterMismatch = figureCriteria.getMaxPerimeter() != 0 &&
                figureCriteria.getMinPerimeter() > figureCriteria.getMaxPerimeter();
        boolean areaMismatch = figureCriteria.getMaxArea() != 0 &&
                figureCriteria.getMinArea() > figureCriteria.getMaxArea();

        return perimeterMismatch || areaMismatch;
    }
}
