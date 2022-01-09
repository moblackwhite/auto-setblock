package org.kuang.autosetblock;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class AutoSetblock extends JavaPlugin {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(1);

    private static final int[][] coordinates = {
            {243, 69, 401},
            {243, 69, 402},
            {243, 69, 403},
            {243, 69, 404},
            {243, 69, 405},
            {243, 69, 406},
            {243, 69, 407},
            {243, 69, 408},
            {243, 69, 409},
            {243, 69, 410},
            {243, 69, 411},
    };

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("AutoSetblock startup !");

        threadPool.submit(() -> {
            while (true) {
                World world = getServer().getWorld("world");
                for (int[] coordinate : coordinates) {
                    Block block = world.getBlockAt(coordinate[0], coordinate[1], coordinate[2]);
                    block.setType(Material.ANVIL);
                    block.setData((byte) 0);
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
