package com.library.repo.model.SQL;

public class ReaderSQL {

    public static String getReaderById = """
            SELECT * FROM Reader
            WHERE readerid = :readerId;
            """;

    public static String addReader = """
            INSERT INTO public.reader(
            	readerid, name, age, bookcount)
            	VALUES (:EGN, :name, :age, 0);
            """;

    public static String getReaderCount = """
            SELECT COUNT(*)
            FROM information_schema.columns
            WHERE table_schema = 'library'
              AND table_name = 'reader';
            """;
}
