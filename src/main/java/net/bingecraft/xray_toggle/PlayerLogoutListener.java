package net.bingecraft.xray_toggle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLogoutListener implements Listener {
  private final Plugin plugin;

  public PlayerLogoutListener(Plugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void playerLogout(PlayerQuitEvent playerQuitEvent) {
    playerQuitEvent.getPlayer().removeMetadata("xray", plugin);
  }
}
