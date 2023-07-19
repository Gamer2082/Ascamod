package fr.Ascaria.ascamod.listeners;

import fr.Ascaria.ascamod.managers.playerManagers;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class freezEvent implements Listener {
    @EventHandler
    public void onFrezeEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location to = e.getTo();
        Location from = e.getFrom();
        if (playerManagers.isFreezed(player)){
            player.sendTitle("Un moderateur vous a freez","venez sur discord");
            player.sendMessage("Un moderateur vous a freez venez sur discord : /discord");
            if (from.getX() != to.getX() && from.getY() != to.getY() && from.getZ() != to.getZ()) {
                e.setCancelled(true); // Annuler le déplacement par défaut
                player.teleport(to); // Déplacer manuellement le joueur à sa position actuelle
            }
        }

    }
}
