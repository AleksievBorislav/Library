package com.library.repo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book.BookBuilder()
                .withBookID(rs.getLong("bookID"))
                .withPageCount(rs.getInt("pageCount"))
                .withPrice(rs.getBigDecimal("price"))
                .withReadersCount(rs.getInt("readersCount"))
                .withTitle(rs.getString("title"))
                .build();
    }
}
