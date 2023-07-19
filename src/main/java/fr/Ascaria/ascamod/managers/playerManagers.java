package fr.Ascaria.ascamod.managers;

import fr.Ascaria.ascamod.Ascamod;
import fr.Ascaria.ascamod.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class playerManagers {
    private Player player;
    private ItemStack[] items = new ItemStack[40];
    public static boolean isModerator(Player player){
        return Ascamod.instance.modList.contains(player.getUniqueId());

    }
    public static boolean isVanished(Player player){
        return Ascamod.instance.vList.contains(player.getUniqueId());

    }
    public static boolean isFreezed(Player player){
        return Ascamod.instance.freezList.contains(player.getUniqueId());

    }

    public playerManagers(Player player){
        this.player = player;

    }

    public void init(){
        Ascamod.instance.players.put(player.getUniqueId(), this);
    }
    public void setup(){
        ItemStack invSee = new ItemBuilder(Material.PAPER).setName(ChatColor.GREEN +"Voir inventaire").setLore("Click droit sur un joueur").toItemStack();
        ItemStack vanish = new ItemBuilder(Material.BLAZE_POWDER).setName(ChatColor.YELLOW +"Vanish").setLore("Click droit pour passer en vanish").toItemStack();
        ItemStack freeze = new ItemBuilder(Material.PACKED_ICE).setName(ChatColor.BLUE +"Freeze").setLore("Click droit sur un joueur").toItemStack();
        ItemStack rbTp = new ItemBuilder(Material.ENDER_EYE).setName(ChatColor.DARK_GREEN +"Aller a un joueur").setLore("Click droit pour","aller a un joueur").toItemStack();
        ItemStack kbTester = new ItemBuilder(Material.STICK).setName(ChatColor.DARK_GRAY +"KB").setLore("Click guache test les kb").addUnsafeEnchantment(Enchantment.KNOCKBACK, 5).toItemStack();
        ItemStack playerKiller = new ItemBuilder(Material.DIAMOND_SWORD).setName(ChatColor.RED +"Killer").setLore("Click droit sur un joueur","pour le tuer").toItemStack();

        player.getInventory().setItem(0,invSee);
        player.getInventory().setItem(1,vanish);
        player.getInventory().setItem(2,freeze);
        player.getInventory().setItem(3,rbTp);
        player.getInventory().setItem(4,kbTester);
        player.getInventory().setItem(5,playerKiller);
        player.sendMessage(ChatColor.GREEN+"Outils de moderation");
        player.setAllowFlight(true);
        player.setFlying(true);


    }
    public void destroy(){
        Ascamod.instance.players.remove(player.getUniqueId());
    }
    public static playerManagers getFromPlayer(Player player){

        return Ascamod.instance.players.get(player.getUniqueId());
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void saveIventory(){
        for (int i =0; i < 36; i++){
            ItemStack item= player.getInventory().getItem(i);
            if (item != null){
                items[i] = item;
            }
        }

    }
    public void giveIventory(){
        player.getInventory().clear();
        for (int i =0; i < 36; i++){
            ItemStack item= getItems()[i];
            if (item != null){
                player.getInventory().setItem(i, item);
            }

        }


    }
}
