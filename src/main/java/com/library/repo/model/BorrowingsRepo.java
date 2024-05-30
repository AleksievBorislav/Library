package com.library.repo.model;

import com.library.repo.model.SQL.BookSQL;
import com.library.repo.model.SQL.BorrowingsSQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BorrowingsRepo {

    NamedParameterJdbcTemplate template;
    public BorrowingsRepo(@Qualifier("dataSource") DataSource source){ template = new NamedParameterJdbcTemplate(source);
    }

    public Book getLastBorrowedBokkByReaderId(String readerId) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("readerId", readerId);
        return template.queryForObject(BorrowingsSQL.getLastBorrowedBookByReaderId,parameters,new BookMapper());
    }
}
