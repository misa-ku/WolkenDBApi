package org.misaku.wolkenDBApi.manager;

import com.zaxxer.hikari.HikariDataSource;
import org.misaku.wolkenDBApi.WolkenDBApi;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {

    private HikariDataSource dataSource;
    String url;

    public DatabaseManager(WolkenDBApi plugin){
        url = plugin.getConfig().getString("url");;
    }

    public void connect(){
        this.dataSource = new HikariDataSource();
        this.dataSource.setJdbcUrl(url);
        this.dataSource.setMaximumPoolSize(10);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void disconnect(){
        if(this.dataSource!=null) this.dataSource.close();
    }
}
