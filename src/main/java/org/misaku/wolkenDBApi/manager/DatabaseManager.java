package org.misaku.wolkenDBApi;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {

    private HikariDataSource dataSource;

    public void connect(){
        this.dataSource = new HikariDataSource();
        this.dataSource.setJdbcUrl("jdbc:postgresql://neondb_owner:npg_B02ZRlAjLhMi@ep-billowing-smoke-alj20fz5-pooler.c-3.eu-central-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require");
        this.dataSource.setMaximumPoolSize(10);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void disconnect(){
        if(this.dataSource!=null) this.dataSource.close();
    }
}
