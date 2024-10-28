package main.java.org.matejko.plugin;

import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Spider;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Cobweb extends JavaPlugin implements Listener {

    private Logger logger;

    @Override
    public void onEnable() {
        this.logger = Logger.getLogger("log");
        this.logger.info("Spiders is now enabled!");

        // Register the event listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        this.logger.info("Spiders is now disabled!");
    }

    @EventHandler
    public void onSpiderDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Spider) {
            if (Math.random() < 0.10) { // 1% chance
                Location spiderLocation = event.getEntity().getLocation();
                World world = spiderLocation.getWorld();
                world.dropItem(spiderLocation, new ItemStack(30, 1)); // Drop cobweb at spider's location
            }
        }
    }
}
