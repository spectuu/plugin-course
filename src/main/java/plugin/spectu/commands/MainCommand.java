package plugin.spectu.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.spectu.PluginMain;
import plugin.spectu.Utils.MessageUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCommand implements CommandExecutor {

    private PluginMain plugin;

    public MainCommand(PluginMain plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        if(!(sender instanceof Player)) {
            //console
            Bukkit.getConsoleSender().sendMessage("Only Players can do this!");
            return true;
        }

        //player
        Player player = (Player) sender;

        // /mp [args0] [args1] ... [argsN]

        if(args.length >= 1){
            if(args[0].equalsIgnoreCase("bienvenida")){
                sender.sendMessage(MessageUtils.getColoredMessage(MessageUtils.prefix + "welcome " + player.getName()));
            }else if(args[0].equalsIgnoreCase("fecha")){
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = dateFormat.format(new Date());
                sender.sendMessage(MessageUtils.getColoredMessage(MessageUtils.prefix + "Fecha y hora actual: " + date));
            }else if(args[0].equalsIgnoreCase("get")){
                subCommandGet(sender, args);
            }else{
                help(sender);
            }
        }else{
            help(sender);
        }

        return true;
    }

    public void help(CommandSender sender){
        sender.sendMessage(MessageUtils.getColoredMessage("§4---------------- COMMANDS ----------- "));
        sender.sendMessage("§5 /mp bienvenida");
        sender.sendMessage("§5 /mp fecha");
        sender.sendMessage("§5 /mp get <Author/Version>");
    }

    public void subCommandGet(CommandSender sender, String[] args){
        if(args.length == 1){
            sender.sendMessage(MessageUtils.getColoredMessage("§4 Debes usar /mp <Author/Version>"));
            return;
        }

        if(args[1].equalsIgnoreCase("author")){
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MessageUtils.prefix + "plugin author: " + plugin.getDescription().getAuthors()));
        }else if(args[1].equalsIgnoreCase("version")){
            sender.sendMessage(MessageUtils.getColoredMessage(MessageUtils.prefix + "plugin version: " + plugin.version));
        } else {
            sender.sendMessage(MessageUtils.getColoredMessage(MessageUtils.prefix + "§4 Debes usar /mp <Author/Version>"));
        }
    }

}
