package com.library.repo.model;

import com.library.config.exceptions.BorrowingNotFoundException;
import com.library.config.exceptions.ReaderNotFoundException;
import com.library.repo.model.SQL.BorrowingsSQL;
import com.library.repo.model.SQL.ReaderSQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BorrowingsRepo {

    NamedParameterJdbcTemplate template;
    public BorrowingsRepo(@Qualifier("dataSource") DataSource source){ template = new NamedParameterJdbcTemplate(source);
    }

    public Book getLastBorrowedBookByReaderId(Long readerId) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("readerId", readerId);
        try {
            return template.queryForObject(BorrowingsSQL.getLastBorrowedBookByReaderId,parameters,new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new BorrowingNotFoundException("It seems a reader with ID %s, has not borrowed any books yet.".formatted(readerId));
        }
    }

    public void borrow(Long readerId, Long bookId){
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("readerId", readerId)
                .addValue("bookId", bookId);
        template.update(BorrowingsSQL.borrow, parameters);
    };

    public List<Borrowings> getAllBorrowings(Long readerId) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("readerId", readerId);
        try {
            return template.queryForStream(BorrowingsSQL.getAllBorrowingsByReaderId,parameters,new BorrowingsMapper()).toList();
        } catch (EmptyResultDataAccessException e) {
            throw new BorrowingNotFoundException("It seems a reader with ID %s, has not borrowed any books yet.".formatted(readerId));
        }
    }
}
