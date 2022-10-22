package net.bingecraft.xray_toggle;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {
  @Override
  public void onEnable() {
    FileConfiguration config = getConfig();
    config.addDefault("xray_resource_pack", "https://mediafilez.forgecdn.net/files/3904/15/Xray_Ultimate_1.19_v4.2.3.zip");
    config.addDefault("nothing_resource_pack", "https://static.planetminecraft.com/files/resource_media/texture/nothing.zip");
    config.options().copyDefaults(true);
    saveConfig();

    getCommand("xray").setExecutor(
      new CommandXray(
        this,
        config.getString("xray_resource_pack"),
        config.getString("nothing_resource_pack")
      )
    );
    getServer().getPluginManager().registerEvents(new PlayerLogoutListener(this), this);
  }
}
