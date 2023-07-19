package fr.Ascaria.ascamod.managers;

import fr.Ascaria.ascamod.Ascamod;
import fr.Ascaria.ascamod.command.modCmdExecutor;

public class managment {
    public static void load(){
        Ascamod main = Ascamod.instance;
        main.getCommand("mod").setExecutor(new modCmdExecutor());


    }
    public static void unLoad(){

    }
}
