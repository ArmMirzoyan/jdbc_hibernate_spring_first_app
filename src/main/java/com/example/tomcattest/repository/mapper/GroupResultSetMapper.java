package com.example.tomcattest.repository.mapper;


import com.example.tomcattest.model.Group;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GroupResultSetMapper {

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";

        public static Group mapToPojo(ResultSet resultSet) throws SQLException {
            return mapToPojo(resultSet, null);
        }

        public static Group mapToPojo(ResultSet resultSet, String alias) throws SQLException {
            alias = alias == null ? "" : alias + "_";
            long id = resultSet.getLong(alias + COLUMN_ID);
            String name = resultSet.getString(alias + COLUMN_NAME);
            return new Group(id, name);
        }
    }

