package fr.gamer2082.ascamod.managers;

import fr.gamer2082.ascamod.Ascamod;
import fr.gamer2082.ascamod.listeners.modCancel;
import fr.gamer2082.ascamod.listeners.moderatorInteracEvent;
import fr.gamer2082.ascamod.listeners.quitEvent;
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
