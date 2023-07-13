package fr.Ascaria.ascamod.listeners;

import fr.Ascaria.ascamod.Ascamod;
import fr.Ascaria.ascamod.managers.playerManagers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class quitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();

        if (Ascamod.instance.modList.contains(player.getUniqueId())){
            Ascamod.instance.modList.add(player.getUniqueId());
            player.setAllowFlight(true);
            player.setFlying(true);
            playerManagers pm = playerManagers.getFromPlayer(player);
            player.getInventory().clear();
            pm.giveIventory();
            pm.destroy();
        }
    }
}
