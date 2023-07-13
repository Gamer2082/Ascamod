package fr.gamer2082.ascamod;

import fr.gamer2082.ascamod.command.modCmdExecutor;
import fr.gamer2082.ascamod.managers.EventManager;
import fr.gamer2082.ascamod.managers.managment;
import fr.gamer2082.ascamod.managers.playerManagers;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class Ascamod extends JavaPlugin {
    public ArrayList<UUID> modList = new ArrayList<>();
    public boolean isVanish;
    public HashMap<UUID, playerManagers> players = new HashMap<>();
    public static Ascamod instance;

    @Override
    public void onEnable() {
        instance = this;

        new EventManager().registers();
        getCommand("mod").setExecutor(new modCmdExecutor());
        // Plugin startup logic
        managment.load();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        managment.unLoad();
    }
}
