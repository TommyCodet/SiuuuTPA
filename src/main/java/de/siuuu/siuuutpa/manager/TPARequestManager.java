package de.siuuu.siuuutpa.manager;

import java.util.HashMap;
import java.util.UUID;

public class TPARequestManager {

    private final HashMap<UUID, UUID> requests = new HashMap<>();

    public void addRequest(UUID target, UUID sender) {
        requests.put(target, sender);
    }

    public UUID getRequester(UUID target) {
        return requests.get(target);
    }

    public void removeRequest(UUID target) {
        requests.remove(target);
    }

    public boolean hasRequest(UUID target) {
        return requests.containsKey(target);
    }
}
