package org.misaku.wolkenDBApi.manager;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseService {
    private final DatabaseManager databaseManager;

    public DatabaseService(DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }

    public Connection getConnection() throws SQLException {
        return this.databaseManager.getConnection();
    }
}
