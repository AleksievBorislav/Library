package com.library.repo.model.SQL;

public class BorrowingsSQL {

    public static String getLastBorrowedBookByReaderId = """
            select *
            	from book
            	where bookid = (
                select bookid from borrowings
            	    where readerid = :readerId
            	    and borrowedtime =
            	    (
            		    select MAX(borrowedtime)
            		    from borrowings
            		    where readerid = :readerId
            	    ));
            """;

}
