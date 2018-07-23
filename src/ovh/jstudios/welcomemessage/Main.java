package ovh.jstudios.welcomemessage;

import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ovh.jstudios.welcomemessage.commands.CommandManager;
import ovh.jstudios.welcomemessage.listeners.PlayerJoinListener;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private Logger logger;
    private FileConfiguration config;
    private Server server;

    // Interface methods ======================================================

    @Override
    public void onDisable() {

        logger.info("Disabled.");

    }

    @Override
    public void onEnable() {

        this.logger = getLogger();


        this.server = getServer();

        initConfig();

        initListeners();

        initCommands();

        logger.info("Loaded.");

    }

    // Private methods ========================================================

    private void initConfig() {

        this.config = getConfig();

        config.options().copyDefaults(true);

        config.addDefault("message", "Welcome to the server, @p");

        saveConfig();

    }

    private void initListeners() {

        server.getPluginManager().registerEvents(new PlayerJoinListener(logger, config), this);

    }

    private void initCommands() {

        PluginCommand welcomeMessageCommand = getCommand("welcomeMessage");
        welcomeMessageCommand.setPermission("welcomeMessage");
        welcomeMessageCommand.setExecutor(new CommandManager(config, this));

    }

}
