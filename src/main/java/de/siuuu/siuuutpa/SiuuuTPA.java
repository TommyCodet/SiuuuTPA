package de.siuuu.siuuutpa;

import de.siuuu.siuuutpa.commands.TPAAcceptCommand;
import de.siuuu.siuuutpa.commands.TPADenyCommand;
import de.siuuu.siuuutpa.commands.TPACommand;
import de.siuuu.siuuutpa.manager.TPARequestManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SiuuuTPA extends JavaPlugin {

    private TPARequestManager requestManager;

    @Override
    public void onEnable() {

        requestManager = new TPARequestManager();

        getCommand("tpa").setExecutor(new TPACommand(requestManager));
        getCommand("tpaaccept").setExecutor(new TPAAcceptCommand(requestManager));
        getCommand("tpadeny").setExecutor(new TPADenyCommand(requestManager));

        getLogger().info("SiuuuTPA aktiviert!");
    }

    public TPARequestManager getRequestManager() {
        return requestManager;
    }
}
