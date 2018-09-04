package au.com.grieve.bungeeresourceshack;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class BungeeResourcesHack extends JavaPlugin implements CommandExecutor {
    @Override
    public void onEnable() {
        getCommand("gusepack").setExecutor(new CommandSetPack(this));
        getServer().getMessenger().registerOutgoingPluginChannel(this, "rp:plugin");

    }
//    @Override
//    public void onDisable() {
//        getLogger().info("onDisable is called!");
//    }




}
