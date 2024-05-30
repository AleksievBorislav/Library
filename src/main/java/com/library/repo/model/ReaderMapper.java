package com.library.repo.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ReaderMapper implements RowMapper<Reader> {
    @Override
    public Reader mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Reader.ReaderBuilder()
                .withId(rs.getLong("readerid"))
                .withAge(rs.getShort("age"))
                .withName(rs.getString("name"))
                .withBookCount(rs.getInt("bookcount"))
                .build();
    }
}
