package cgntools.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class CommandPreProcess implements Listener {

	@EventHandler(priority=EventPriority.HIGHEST)
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
	  {
	    Player p = event.getPlayer();
	    if (!event.isCancelled())
	    {
	      String command = event.getMessage().split(" ")[0];
	      HelpTopic htopic = Bukkit.getServer().getHelpMap().getHelpTopic(command);
	      if (htopic == null)
	      {
	        p.sendMessage("§fUnknown command.");
	        event.setCancelled(true);
	      }
	    }
	  }
	
}
