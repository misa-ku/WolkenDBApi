package org.misaku.wolkenDBApi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.misaku.wolkenDBApi.manager.DatabaseManager;
import org.misaku.wolkenDBApi.manager.DatabaseService;

public final class WolkenDBApi extends JavaPlugin {

    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.databaseManager = new DatabaseManager(this);
        this.databaseManager.connect();

        DatabaseService databaseService = new DatabaseService(databaseManager);
        Bukkit.getServicesManager().register(
                DatabaseService.class,
                databaseService,
                this,
                ServicePriority.Normal
        );
    }

    @Override
    public void onDisable() {
        if(this.databaseManager!=null){
         databaseManager.disconnect();
        }
    }
}
