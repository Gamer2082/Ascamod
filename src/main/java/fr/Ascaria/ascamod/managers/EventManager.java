package fr.Ascaria.ascamod.managers;

import fr.Ascaria.ascamod.Ascamod;
import fr.Ascaria.ascamod.listeners.modCancel;
import fr.Ascaria.ascamod.listeners.moderatorInteracEvent;
import fr.Ascaria.ascamod.listeners.quitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager {
    public void registers() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        Ascamod main = Ascamod.instance;

        pluginManager.registerEvents(new quitEvent(),main);
        pluginManager.registerEvents(new moderatorInteracEvent(),main);
        pluginManager.registerEvents(new modCancel(),main);

    }
}
