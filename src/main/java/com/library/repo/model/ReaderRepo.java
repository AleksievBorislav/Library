package com.library.repo.model;

import com.library.config.exceptions.EntryNotFoundException;
import com.library.repo.model.SQL.BookSQL;
import com.library.repo.model.SQL.ReaderSQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ReaderRepo {


    NamedParameterJdbcTemplate template;
    public ReaderRepo(@Qualifier("dataSource") DataSource source){
        template = new NamedParameterJdbcTemplate(source);
    }


    public Reader getReaderById(long id){
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("readerId", id);
        return template.queryForObject(ReaderSQL.getReaderById,parameters,new ReaderMapper());
    }
}
