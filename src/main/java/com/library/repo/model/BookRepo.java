package com.library.repo.model;

import com.library.config.exceptions.BookNotFoundException;
import com.library.repo.model.SQL.BookSQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class BookRepo {

    NamedParameterJdbcTemplate template;

    public BookRepo(@Qualifier("dataSource") DataSource source) {
        template = new NamedParameterJdbcTemplate(source);
    }


    public Book getBookByTitle(String title) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", title);
        try {
            return template.queryForObject(BookSQL.getBookByTitle, parameters, new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new BookNotFoundException("Book not found with the title of '%s'.".formatted(title));
        }
    }

    public Book getBookById(long id) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("bookId", id);
        try {
            return template.queryForObject(BookSQL.getBookById, parameters, new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new BookNotFoundException("Book not found with ID of %s.".formatted(id));
        }
    }

    public Book getLastBook() {
        SqlParameterSource parameters = new MapSqlParameterSource();
        try {
            return template.queryForObject(BookSQL.getLastBook, parameters, new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new BookNotFoundException("No book records are available at this time.");
        }
    }

    public Integer getBookCount() {
        SqlParameterSource parameters = new MapSqlParameterSource();
        return Optional.ofNullable(template.queryForObject(BookSQL.getBookCount, parameters, Integer.class))
                .orElseThrow(() -> new BookNotFoundException("No book records are available at this time."));

    }

}
