package fr.Ascaria.ascamod.command;

import fr.Ascaria.ascamod.Ascamod;
import fr.Ascaria.ascamod.managers.playerManagers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class modCmdExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (! (sender instanceof Player)) return false;
        Player player = (Player) sender;





        if (!player.hasPermission("mod.join")){
            player.sendMessage(ChatColor.RED + "Hum seul un moderateur peut le faire");
            return false;
        }
        if (Ascamod.instance.modList.contains(player.getUniqueId())){
            playerManagers pm = playerManagers.getFromPlayer(player);
            Ascamod.instance.modList.remove(player.getUniqueId());
            player.sendMessage(ChatColor.RED+"Mod moderateur est desactive");
            player.getInventory().clear();
            pm.giveIventory();
            pm.destroy();
            player.setAllowFlight(false);
            player.setFlying(false);


            return false;
        }else {
            playerManagers pm = new playerManagers(player);
            Ascamod.instance.modList.add(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN+"Mod moderateur est active");
            pm.init();
            pm.saveIventory();
            player.getInventory().clear();
            pm.setup();


        }


        return true;
    }
}
