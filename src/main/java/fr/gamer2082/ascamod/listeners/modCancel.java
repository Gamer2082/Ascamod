package fr.gamer2082.ascamod.listeners;

import fr.gamer2082.ascamod.managers.playerManagers;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class modCancel implements Listener {
    @EventHandler
    public static void onItemDrop(PlayerDropItemEvent e){
        e.setCancelled(playerManagers.isModerator(e.getPlayer()));
    }
    @EventHandler
    public static void onBlock(BlockPlaceEvent e){
        e.setCancelled(playerManagers.isModerator(e.getPlayer()));
    }
    @EventHandler
    public void onBlockBr(BlockBreakEvent e){
        e.setCancelled(playerManagers.isModerator(e.getPlayer()));
    }
    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e){
        if (!(e.getEntity() instanceof Player)){
            return;
        }
        e.setCancelled(playerManagers.isModerator((Player) e.getEntity()));
    }
    @EventHandler
    public void onEntityDm(EntityDamageEvent e){
        if (!(e.getEntity() instanceof Player)){
            return;
        }
        e.setCancelled(playerManagers.isModerator((Player) e.getEntity()));
    }
    @EventHandler
    public void damageByEntity(EntityDamageByEntityEvent e){
        if (!(e.getEntity() instanceof Player)){
            return;
        }
        if (!(e.getDamager() instanceof Player)){
            return;
        }
        Player Damager = (Player) e.getDamager();
        if (playerManagers.isModerator(Damager)){
            e.setCancelled(Damager.getInventory().getItemInMainHand().getType() != Material.STICK);
        }

    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        e.setCancelled(playerManagers.isModerator(e.getPlayer()));
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        e.setCancelled(playerManagers.isModerator((Player) e.getWhoClicked()));
    }


}
