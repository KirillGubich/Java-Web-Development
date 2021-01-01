package main.java.com.epam.jwd.figure.storage.impl;

import main.java.com.epam.jwd.figure.model.impl.MultiAngleFigure;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class MultiAngleFigureStorage implements FigureStorage<MultiAngleFigure> {

    private static MultiAngleFigureStorage instance;
    private static final List<MultiAngleFigure> allCreatedMultiAngleFigures = new ArrayList<>();

    private MultiAngleFigureStorage() {
    }

    public static MultiAngleFigureStorage getInstance() {
        if (instance == null) {
            instance = new MultiAngleFigureStorage();
        }
        return instance;
    }

    @Override
    public void addToStorage(MultiAngleFigure figure) {
        allCreatedMultiAngleFigures.add(figure);
    }

    @Override
    public void removeFromStorage(MultiAngleFigure figure) {
        allCreatedMultiAngleFigures.remove(figure);
    }

    @Override
    public void saveToStorage(List<MultiAngleFigure> figures) {
        allCreatedMultiAngleFigures.addAll(figures);
    }

    @Override
    public List<MultiAngleFigure> getStorage() {
        return allCreatedMultiAngleFigures;
    }
}
