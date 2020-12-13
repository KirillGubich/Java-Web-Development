package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.FigureType;

public class FigureCriteriaBuilder implements Builder {

    private static FigureCriteriaBuilder instance;
    private FigureCriteria figureCriteria;

    private FigureCriteriaBuilder() {
        this.reset();
    }

    public static FigureCriteriaBuilder getInstance() {
        if (instance == null) {
            instance = new FigureCriteriaBuilder();
        }
        return instance;
    }

    public FigureCriteria getProduct() {
        FigureCriteria figureCriteria = this.figureCriteria;
        this.reset();
        return figureCriteria;
    }

    @Override
    public void reset() {
        figureCriteria = new FigureCriteria();
    }

    @Override
    public void setFigureType(FigureType figureType) {
        figureCriteria.setFigureType(figureType);
    }

    @Override
    public void setAmountOfAngles(int amountOfAngles) {
        figureCriteria.setAmountOfAngles(amountOfAngles);
    }
}
