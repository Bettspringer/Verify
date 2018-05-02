package de.verify.main;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.verify.listener.JoinListener;
import de.verify.listener.MoveListener;
import de.verify.utils.UTF8YamlConfiguration;
import de.verify.cmd.Verify_CMD;

public class Main extends JavaPlugin {
	  public static Main main;
	  public File configFile;
	  public YamlConfiguration config;
	  
	  public void onEnable()
	  {
	    main = this;
	    register();
	    manageFiles();
	  }
	  
	  private void register()
	  {
	    PluginManager pm = getServer().getPluginManager();
	    getCommand("verify").setExecutor(new Verify_CMD());
	    pm.registerEvents(new JoinListener(), this);
	    pm.registerEvents(new MoveListener(), this);
	  }
	  
	  private void manageFiles()
	  {
	    this.configFile = new File(getDataFolder().getPath(), "players.yml");
	    if (!this.configFile.exists()) {
	      saveResource("players.yml", true);
	    }
	    this.config = new UTF8YamlConfiguration(this.configFile);
	  }
	  
	  public void addVerifiedPlayer(Player t, String code)
	  {
	    this.config.set("Verified." + t.getUniqueId(), code);
	    saveConfig();
	  }
	  
	  public int getVerifiedPlayers()
	  {
	    return this.config.getConfigurationSection("Verified").getKeys(false).size();
	  }
	  
	  public boolean isVerified(Player t)
	  {
	    return this.config.isSet("Verified." + t.getUniqueId());
	  }
	  
	  public void saveConfig()
	  {
	    try
	    {
	      this.config.save(this.configFile);
	    }
	    catch (Exception ex)
	    {
	      ex.printStackTrace();
	    }
	  }
	  
	  public static Main getInstance()
	  {
	    return main;
	  }
	}
