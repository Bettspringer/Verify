package de.verify.listener;


import de.verify.main.Main;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener
  implements Listener
{
  private Random rand = new Random();
  public static Map<UUID, String> playersCode = new HashMap<>();
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    if (Main.getInstance().isVerified(p)) {
      return;
    }
    String code = generateCode();
    p.sendMessage("Verifiziere dich mit </verify> <Code>");
    p.sendMessage("Code: " + code);
    playersCode.put(p.getUniqueId(), code);
  }
  
  @EventHandler
  public void onQuit(PlayerQuitEvent event)
  {
    Player player = event.getPlayer();
    if (playersCode.containsKey(player.getUniqueId())) {
      playersCode.remove(player.getUniqueId());
    }
  }
  
  private String generateCode()
  {
    int lenght = 12;
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder codeBuilder = new StringBuilder();
    while (codeBuilder.length() < lenght)
    {
      int index = (int)(this.rand.nextFloat() * chars.length());
      codeBuilder.append(chars.charAt(index));
    }
    return codeBuilder.toString();
  }
}
