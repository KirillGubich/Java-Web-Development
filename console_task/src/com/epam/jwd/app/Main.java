package com.epam.jwd.app;

import com.epam.jwd.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        LOGGER.info("Program started");

        Book[] bookshelf = new Book[5];

        bookshelf[0] = new Book("Code complete", "Macconnell", 1993);
        bookshelf[1] = new Book("Head First Java", "Sierra, Bates", 2003);
        bookshelf[2] = new Book("Java programming techniques", "Blinov", 2013);
        bookshelf[3] = new Book("Murder on the Orient Express", "Christie", 2017);
        bookshelf[4] = new Book("Fahrenheit 451", "Bradbury", 2015);

        for (Book book: bookshelf) {
            LOGGER.debug(book);
        }

        LOGGER.info("Program finished");
    }
}
