package ovh.jstudios.welcomemessage.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class PlayerJoinListener implements Listener {

    private final Logger logger;
    private final FileConfiguration config;

    public PlayerJoinListener(Logger logger, FileConfiguration config) {
        this.logger = logger;
        this.config = config;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        String welcomeMessageTemplate = config.getString("message");

        String customMessage = welcomeMessageTemplate.replace("@p", player.getDisplayName());

        player.sendMessage(customMessage);

    }

}
