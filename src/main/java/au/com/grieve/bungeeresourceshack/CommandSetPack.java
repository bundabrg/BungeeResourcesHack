package au.com.grieve.bungeeresourceshack;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetPack implements CommandExecutor {

    private final BungeeResourcesHack plugin;

    CommandSetPack(BungeeResourcesHack plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Must only be sent by console
        if (sender instanceof Player) {
            return false;
        }

        if (args.length < 2) {
            return false;
        }

        Player player = plugin.getServer().getPlayer(args[0]);
        String pack = args[1];

        if (player != null) {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("setpack");
            out.writeUTF(player.getUniqueId().toString());
            out.writeUTF(pack);
            player.sendPluginMessage(plugin, "rp:plugin", out.toByteArray());
            return true;
        }

        return false;
    }
}
