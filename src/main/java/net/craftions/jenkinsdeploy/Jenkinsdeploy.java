package net.craftions.jenkinsdeploy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Jenkinsdeploy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        File config = new File("plugins/JenkinsDeploy/config.yml");
        if(!config.getParentFile().isDirectory()){
            config.getParentFile().mkdirs();
        }
        if(!config.exists()){
            Download.download("https://cdn.craftions.net/plugins/JenkinsDeploy/default/config.clean.yml", config);
        }
        Config.init();
        for(String s : Config.conf.getConfigurationSection("plugins").getKeys(false)){
            Boolean ignore = Config.conf.getBoolean("plugins." + s + ".ignore");
            if(!ignore){
                System.out.println("[JenkinsDeploy] Found plugin " + s);
                String localFileName = Config.conf.getString("plugins." + s + ".localFileName");
                String downloadURL = Config.conf.getString("plugins." + s + ".downloadURL");
                System.out.println("[JenkinsDeploy] Deleting original file " + localFileName);
                File localFile = new File("plugins/" + localFileName);
                localFile.delete();
                System.out.println("[JenkinsDeploy] Downloading new file " + localFileName + "...");
                Download.download(downloadURL, localFile);
                System.out.println("[JenkinsDeploy] Finished downloading file!");
                try {
                    Bukkit.getPluginManager().loadPlugin(localFile);
                } catch (InvalidPluginException e) {
                    e.printStackTrace();
                } catch (InvalidDescriptionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
