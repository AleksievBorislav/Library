package com.library.repo.model;

import com.library.config.exceptions.BookNotFoundException;
import com.library.config.exceptions.ReaderNotFoundException;
import com.library.repo.model.SQL.BookSQL;
import com.library.repo.model.SQL.ReaderSQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class ReaderRepo {


    NamedParameterJdbcTemplate template;
    public ReaderRepo(@Qualifier("dataSource") DataSource source){
        template = new NamedParameterJdbcTemplate(source);
    }


    public Reader getReaderById(long id){
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("readerId", id);
        try {
            return template.queryForObject(ReaderSQL.getReaderById,parameters,new ReaderMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new ReaderNotFoundException("Reader not found with ID of %s.".formatted(id));
        }
    }

    public Integer getReaderCount() {
        SqlParameterSource parameters = new MapSqlParameterSource();
        return Optional.ofNullable(template.queryForObject(ReaderSQL.getReaderCount, parameters, Integer.class))
                .orElseThrow(() -> new BookNotFoundException("No reader records are available at this time."));

    }
}
