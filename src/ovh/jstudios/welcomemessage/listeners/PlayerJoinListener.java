package ovh.jstudios.welcomemessage.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class PlayerJoinListener implements Listener {

    private final Logger logger;
    private final String welcomeMessageTemplate;

    public PlayerJoinListener(Logger logger, String welcomeMessageTemplate) {
        this.logger = logger;
        this.welcomeMessageTemplate = welcomeMessageTemplate;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        String customMessage = welcomeMessageTemplate.replace("@p", player.getDisplayName());

        player.sendMessage(customMessage);

    }

}
