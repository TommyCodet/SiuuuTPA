package de.siuuu.siuuutpa.commands;

import de.siuuu.siuuutpa.manager.TPARequestManager;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TPADenyCommand implements CommandExecutor {

    private final TPARequestManager manager;

    public TPADenyCommand(TPARequestManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (!(sender instanceof Player target))
            return true;

        if (!manager.hasRequest(target.getUniqueId())) {
            target.sendMessage("§cKeine Anfrage vorhanden.");
            return true;
        }

        UUID requesterUUID =
                manager.getRequester(target.getUniqueId());

        Player requester =
                Bukkit.getPlayer(requesterUUID);

        if (requester != null) {
            requester.sendMessage(
                    "§cDeine Anfrage wurde abgelehnt."
            );
        }

        target.sendMessage("§cAnfrage abgelehnt.");

        manager.removeRequest(target.getUniqueId());

        return true;
    }
}
