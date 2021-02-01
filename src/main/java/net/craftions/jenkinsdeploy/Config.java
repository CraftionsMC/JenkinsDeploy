/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.jenkinsdeploy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    public static FileConfiguration conf;

    public static void init(){
        conf = YamlConfiguration.loadConfiguration(new File("plugins/JenkinsDeploy/config.yml"));
    }
}
