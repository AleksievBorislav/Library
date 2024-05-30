package com.library.repo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BorrowingsMapper implements RowMapper<Borrowings> {
    @Override
    public Borrowings mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Borrowings.BorrowingsBuilder()
                .withReaderId(rs.getLong("readerid"))
                .withBookId(rs.getLong("bookid"))
                .withBorrowTime(rs.getTime("borrowedTime"))
                .build();
    }
}
