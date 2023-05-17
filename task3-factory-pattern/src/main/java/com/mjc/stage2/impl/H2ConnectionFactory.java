package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        Connection connection;
        Properties properties;
        String url;
        String user;
        String password;

        try{
            properties = new Properties();
            properties.load(Connection.class.getClassLoader().getResourceAsStream("h2database.properties"));

            url = properties.getProperty("db_url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

