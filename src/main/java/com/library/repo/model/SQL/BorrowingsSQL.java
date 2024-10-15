package com.library.repo.model.SQL;

public class BorrowingsSQL {

    public static String getLastBorrowedBookByReaderId = """
            SELECT *
            	FROM book
            	WHERE bookid = (
                    select bookid from borrowings
                    where readerid = :readerId
                    order by borrowedtime desc
                    limit 1)
            """;

    public static String borrow = """
            INSERT INTO public.borrowings(
            	readerid, bookid, borrowedtime)
            	VALUES (:readerId, :bookId, NOW());
            """;

    public static String getAllBorrowingsByReaderId = """
            SELECT *
            	FROM borrowings
            	WHERE readerId = :readerId
            """;

}
