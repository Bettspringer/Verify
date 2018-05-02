package de.verify.listener;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener
  implements Listener
{
  @EventHandler
  public void onMove(PlayerMoveEvent event)
  {
    Location from = event.getFrom();
    Location to = event.getTo();
    Player p = event.getPlayer();
    if (!JoinListener.playersCode.containsKey(p.getUniqueId())) {
      return;
    }
    if ((from.getBlockX() == to.getBlockX()) && (from.getBlockY() == to.getBlockY()) && (from.getBlockZ() == to.getBlockZ())) {
      return;
    }
    p.teleport(from);
  }
}
