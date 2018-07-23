package ovh.jstudios.welcomemessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ovh.jstudios.welcomemessage.Main;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class CommandManager implements CommandExecutor {

    private final FileConfiguration config;
    private final JavaPlugin plugin;

    public CommandManager(FileConfiguration config, JavaPlugin plugin) {
        this.config = config;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        List<String> newMessageList = Arrays.asList(args);
        String newMessage = String.join(" ", newMessageList);
        config.set("message", newMessage);
        plugin.saveConfig();

        commandSender.sendMessage("Server welcome message changed.");

        return true;

    }

}
