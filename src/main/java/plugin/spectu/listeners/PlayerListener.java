package plugin.spectu.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.spectu.Utils.MessageUtils;

public class PlayerListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        String message = event.getMessage();

        if(message.toLowerCase().contains("aternos")){
            event.setCancelled(true);
            player.sendMessage(MessageUtils.getColoredMessage(MessageUtils.prefix + "No decir malas palabras"));
        }

    }

    @EventHandler
    public void onJoinServer(PlayerJoinEvent event){

        Player player = event.getPlayer();

        player.sendMessage(MessageUtils.getColoredMessage(MessageUtils.prefix + "cule gay"));

        Location location = new Location(
                Bukkit.getWorld(player.getWorld().getName()), 102.70, 65, 99.34, -106, 0);

        player.teleport(location);

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

       Player player = event.getPlayer();

       if(!player.hasPermission("miplugin.admin")) {

           player.sendMessage(
                   MessageUtils.getColoredMessage(MessageUtils.prefix + "no puedes romper bloques!"));

           event.setCancelled(true);
       }

    }
}
