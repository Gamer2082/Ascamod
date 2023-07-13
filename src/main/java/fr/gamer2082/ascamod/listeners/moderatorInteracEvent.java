package fr.gamer2082.ascamod.listeners;

import fr.gamer2082.ascamod.managers.playerManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class moderatorInteracEvent implements Listener {
    @EventHandler
    public void ModInterac(PlayerInteractEntityEvent e){
        Player player = e.getPlayer();
        if (!playerManagers.isModerator(player)) return;
        if (!(e.getRightClicked() instanceof Player)) return;
        Player target = (Player) e.getRightClicked();
        e.setCancelled(true);

        switch (player.getInventory().getItemInMainHand().getType()){

            case PAPER:
                Inventory inv = Bukkit.createInventory(null,5 *9, ChatColor.BLUE + "Inventaire " + target.getName());

                for (int i =0; i<36;i++){
                    if (target.getInventory().getItem(i) != null){
                        inv.setItem(i,target.getInventory().getItem(i));
                    }
                }
                inv.setItem(36, target.getInventory().getHelmet());
                inv.setItem(37, target.getInventory().getChestplate());
                inv.setItem(38, target.getInventory().getLeggings());
                inv.setItem(39, target.getInventory().getBoots());

                player.openInventory(inv);

                break;
            case  DIAMOND_SWORD:
                target.damage(target.getHealth() + 1f);
                break;
            case PACKED_ICE:
                /*
                *TODO
                */
                break;
            default: break;
        }
    }
    @EventHandler
    public void ModInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (!playerManagers.isModerator(player)) return;
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        switch (player.getInventory().getItemInMainHand().getType()){
            case ENDER_PEARL:
                List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
                list.remove(player);
                if (list.size() == 0){
                    player.sendMessage("Aucun autre joueur connecté");
                return;
                }
                Player target = list.get(new Random().nextInt(list.size()));
                player.teleport(target.getLocation());
                player.sendMessage("Teleportation a " + target.getName());


                break;
            case BLAZE_POWDER:

                break;
            default: break;
        }

    }
}
