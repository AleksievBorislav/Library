package com.library.repo.model.SQL;

public class BookSQL {
    public static String getBookByTitle = """
            SELECT * FROM Book
            WHERE title = :title;
            """;

    public static String getBookById = """
            SELECT * FROM Book
            WHERE bookId = :bookId;
            """;

    public static String getLastBook = """
            SELECT * FROM Book
            WHERE bookId = (SELECT max(bookId) FROM Book);
            """;

    public static String getBookCount = """
            SELECT COUNT(*)
            FROM information_schema.columns
            WHERE table_schema = 'library'
              AND table_name = 'book';
            """;
}
