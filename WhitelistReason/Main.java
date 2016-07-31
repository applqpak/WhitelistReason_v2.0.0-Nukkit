package WhitelistReason;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Config;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;

import java.io.File;

public class Main extends PluginBase
{

  public Config config;

  public String VERSION = "v2.0.0";

  public String USAGE = "/whitelistreason <version | add | set | enable | disable> <player | message>";

  public String implode(String glue, String[] strArray)
  {

    String ret = "";

    for(int i = 0; i < strArray.length; i++)
    {

      if(strArray[i].trim() != "")
      {

        ret += (i == strArray.length - 1) ? strArray[i] : strArray[i] + glue;

      }

    }

    return ret;

  }

  public boolean in_array(String key, String[] strArray)
  {

    boolean keyExists = false;

    for(String item : strArray)
    {

      if(item == key)
      {

        keyExists = true;

      }

    }

    if(keyExists == true)
    {

      return true;

    }
    else
    {

      return false;

    }

  }

  public String[] toS(List lst)
  {

    String[] strArray = new String[lst.size()];

    int index = 0;

    for(Object value : lst)
    {

      strArray[index] = String.valueOf(value);

      index++;

    }

    return strArray;

  }

  @Override

  public void onEnable()
  {

    this.getDataFolder().mkdirs();

    if(!(new File(this.getDataFolder(), "config.yml").exists()))
    {

      saveResource("config.yml");

    }

    this.config = getConfig();

    this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

    this.getLogger().info(TextFormat.GREEN + "Enabled.");

  }

  @Override

  public void onDisable()
  {

    this.getLogger().info(TextFormat.RED + "Disabled.");

  }

}
