package net.bingecraft.xray_toggle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

public class CommandXray implements CommandExecutor {
  private final Plugin plugin;
  private final String xrayResourcePack;
  private final String nothingResourcePack;

  public CommandXray(Plugin plugin, String xrayResourcePack, String nothingResourcePack) {
    this.plugin = plugin;
    this.xrayResourcePack = xrayResourcePack;
    this.nothingResourcePack = nothingResourcePack;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;
    if (player.getMetadata("xray").size() > 0) {
      player.removeMetadata("xray", plugin);
      player.setResourcePack(nothingResourcePack);
    } else {
      player.setMetadata("xray", new FixedMetadataValue(plugin, true));
      player.setResourcePack(xrayResourcePack);
    }
    return true;
  }
}
