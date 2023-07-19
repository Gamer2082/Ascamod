package fr.Ascaria.ascamod.listeners;

import fr.Ascaria.ascamod.managers.playerManagers;
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
        if(playerManagers.isModerator(e.getPlayer()) || playerManagers.isFreezed(e.getPlayer())){
            e.setCancelled(true);
        }

    }
    @EventHandler
    public static void onBlock(BlockPlaceEvent e){
        if(playerManagers.isModerator(e.getPlayer()) || playerManagers.isFreezed(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBlockBr(BlockBreakEvent e){
        if(playerManagers.isModerator(e.getPlayer()) || playerManagers.isFreezed(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e){
        if (!(e.getEntity() instanceof Player)){
            return;
        }
        if(playerManagers.isModerator((Player) e.getEntity()) || playerManagers.isFreezed((Player) e.getEntity())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onEntityDm(EntityDamageEvent e){
        if (!(e.getEntity() instanceof Player)){
            return;
        }
        if(playerManagers.isModerator((Player) e.getEntity()) || playerManagers.isFreezed((Player) e.getEntity())){
            e.setCancelled(true);
        }
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
        if (playerManagers.isFreezed(Damager)){
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(playerManagers.isModerator(e.getPlayer()) || playerManagers.isFreezed(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(playerManagers.isModerator((Player) e.getWhoClicked()) || playerManagers.isFreezed((Player) e.getWhoClicked())){
            e.setCancelled(true);
        }
    }


}
