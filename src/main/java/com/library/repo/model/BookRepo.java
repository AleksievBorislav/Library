package com.library.repo.model;

import com.library.repo.model.SQL.BookSQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BookRepo {

    NamedParameterJdbcTemplate template;

    public BookRepo(@Qualifier("dataSource") DataSource source) {
        template = new NamedParameterJdbcTemplate(source);
    }


    public Book getBookByTitle(String title) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", title);
        return template.queryForObject(BookSQL.getBookByTitle, parameters, new BookMapper());
    }

    public Book getBookById(long id) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("bookId", id);
        return template.queryForObject(BookSQL.getBookById, parameters, new BookMapper());
    }

    public Book getLastBook() {
        SqlParameterSource parameters = new MapSqlParameterSource();
        return template.queryForObject(BookSQL.getLastBook, parameters, new BookMapper());
    }
}
