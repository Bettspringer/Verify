package de.verify.cmd;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import de.verify.listener.JoinListener;
import de.verify.main.Main;
import de.verify.utils.PlayerCommand;

public class Verify_CMD
  extends PlayerCommand
{
  public boolean command(Player player, Command cmd, String[] args, String label)
  {
    if (args.length != 1)
    {
      player.sendMessage("§fBenutze: /verify <Code>");
      return true;
    }
    String input = args[0];
    if (input.equals("count"))
    {
      if (!player.hasPermission("verifysystem.seecount"))
      {
        player.sendMessage("§fDu hast keine Rechte!");
        return true;
      }
      player.sendMessage("§fVerifizierte Spieler: §f" + Main.getInstance().getVerifiedPlayers());
      return true;
    }
    if (!JoinListener.playersCode.containsKey(player.getUniqueId()))
    {
      player.sendMessage("§fDu bist bereits Verifiziert!");
      return true;
    }
    String code = (String)JoinListener.playersCode.get(player.getUniqueId());
    if (!input.equals(code))
    {
      player.sendMessage("§fDer Code wurde falsch eingegeben!");
      return true;
    }
    JoinListener.playersCode.remove(player.getUniqueId());
    player.sendMessage("§fDu wurdest erfolgreich Verifiziert!");
    Main.getInstance().addVerifiedPlayer(player, code);
    
    return true;
  }
}