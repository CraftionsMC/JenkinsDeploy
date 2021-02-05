# JenkinsDeploy
Download the latest plugin version of any plugin at startup.

# How To Use
- Add this to your plugin.yml:
```yaml
depend: [JenkinsDeploy]
```
- Then add this to the config (plugins/JenkinsDeploy/config.yml):
```yaml
plugins:
  Name_of_the_plugin:
    downloadURL: "http://your-jenkins.com/job/your-job/lastSuccessfulBuild/artifact/your-artifact.jar"
    localFileName: "yourPlugin.jar"
```
On every start/reload of the server all plugins in the "plugins" section is being updated.

# Copyright

Copyright (c) 2020-2021 Craftions.net, Ben Siebert. This Content is licensed under the MIT License.

# External Links

Plugin Homepage: https://craftions.net/?page_id=249
SpigotMC Page: https://www.spigotmc.org/resources/jenkinsdeploy.88550/
