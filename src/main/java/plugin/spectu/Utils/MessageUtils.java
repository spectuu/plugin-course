package plugin.spectu.Utils;

import org.bukkit.ChatColor;

public class MessageUtils {

    public static String prefix = "&8[&c&lMiPlugin&b2&8] ";

    public static String getColoredMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }


}
