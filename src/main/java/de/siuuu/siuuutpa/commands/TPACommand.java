package de.siuuu.siuuutpa.commands;

import de.siuuu.siuuutpa.manager.TPARequestManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TPACommand implements CommandExecutor {

    private final TPARequestManager manager;

    public TPACommand(TPARequestManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (!(sender instanceof Player player))
            return true;

        if (args.length != 1) {
            player.sendMessage("§c/tpa <Spieler>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§cSpieler nicht gefunden.");
            return true;
        }

        manager.addRequest(
                target.getUniqueId(),
                player.getUniqueId()
        );

        Component accept = Component.text("§a§l[ANNEHMEN]")
                .clickEvent(ClickEvent.runCommand("/tpaaccept"));

        Component deny = Component.text(" §c§l[ABLEHNEN]")
                .clickEvent(ClickEvent.runCommand("/tpadeny"));

        target.sendMessage(
                Component.text("§6" + player.getName() +
                        " möchte sich zu dir teleportieren.")
        );

        target.sendMessage(accept.append(deny));

        player.sendMessage("§aTPA-Anfrage gesendet.");

        return true;
    }
}
