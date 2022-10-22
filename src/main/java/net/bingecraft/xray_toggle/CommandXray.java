package net.bingecraft.xray_toggle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class CommandXray implements CommandExecutor {
  private final Plugin plugin;

  public CommandXray(Plugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;
    if (player.getMetadata("xray").size() > 0) {
      player.removeMetadata("xray", plugin);
      player.setResourcePack("https://static.planetminecraft.com/files/resource_media/texture/nothing.zip");
    } else {
      player.setMetadata("xray", new FixedMetadataValue(plugin, true));
      player.setResourcePack("https://mediafilez.forgecdn.net/files/3904/15/Xray_Ultimate_1.19_v4.2.3.zip");
    }
    return true;
  }
}
