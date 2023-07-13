package fr.Ascaria.ascamod;

import fr.Ascaria.ascamod.command.modCmdExecutor;
import fr.Ascaria.ascamod.managers.EventManager;
import fr.Ascaria.ascamod.managers.managment;
import fr.Ascaria.ascamod.managers.playerManagers;
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
