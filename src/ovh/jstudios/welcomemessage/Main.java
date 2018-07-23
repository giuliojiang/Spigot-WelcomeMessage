package ovh.jstudios.welcomemessage;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private Logger logger;

    @Override
    public void onDisable() {

        logger.info("WelcomeMessage: onDisable");

    }

    @Override
    public void onEnable() {

        this.logger = getLogger();

        logger.info("WelcomeMessage: onEnable");

    }
}
