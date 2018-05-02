package de.verify.utils;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String args, String[] label)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Dieser Befehl ist nur als Spieler möglich!");
      return true;
    }
    Player player = (Player)sender;
    return command(player, cmd, label, args);
  }
  
  public abstract boolean command(Player paramPlayer, Command paramCommand, String[] paramArrayOfString, String paramString);
}