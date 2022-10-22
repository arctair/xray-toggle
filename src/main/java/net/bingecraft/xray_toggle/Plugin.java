package net.bingecraft.xray_toggle;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {
  @Override
  public void onEnable() {
    FileConfiguration config = getConfig();
    config.options().copyDefaults(true);
    saveConfig();

    getCommand("xray").setExecutor(new CommandXray(this));
    getServer().getPluginManager().registerEvents(new PlayerLogoutListener(this), this);
  }
}
