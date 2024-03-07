package plugin.spectu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.spectu.Utils.MessageUtils;
import plugin.spectu.commands.MainCommand;
import plugin.spectu.listeners.PlayerListener;

public class PluginMain extends JavaPlugin {

    public String version = getDescription().getVersion();

    public void onEnable(){

        commandRegister();
        registerEvents();

        Bukkit.getConsoleSender()
                .sendMessage(MessageUtils.getColoredMessage(
                MessageUtils.prefix + "&eHas been enabled &fVersion -> " + version));
    }

    public void onDisable(){
        Bukkit.getConsoleSender()
                .sendMessage(MessageUtils.getColoredMessage(
                        MessageUtils.prefix + "&eHas been disabled  &fVersion -> " + version));
    }

    public void commandRegister(){
        this.getCommand("mp").setExecutor(new MainCommand(this));
    }
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

}
