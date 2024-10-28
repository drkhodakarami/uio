package jiraiyah.uio.util.config;

import com.mojang.datafixers.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Provided by Kaupenjoe
 * Modification by Jiraiyah
 */
public class ConfigProvider implements IConfigProvider
{
    private String configContent;
    private final List<Pair<String, ?>> configsList;
    private final ConfigKeyCasing casing;

    public ConfigProvider()
    {
        this(ConfigKeyCasing.NO_CHANGE);
    }

    public ConfigProvider(ConfigKeyCasing casing)
    {
        this.configContent = "";
        this.configsList = new ArrayList<>();
        this.casing = casing;
    }

    public List<Pair<String, ?>> getConfigList()
    {
        return configsList;
    }

    @Override
    public String get(String namespace)
    {
        return this.configContent;
    }

    public void addPair(Pair<String, ?> pair, String comment)
    {
        addPair(pair, comment, true, false);
    }

    public void addPair(Pair<String, ?> pair)
    {
        addPair(pair,true, false);
    }

    public void addPair(Pair<String, ?> pair, String comment, boolean addNewLine)
    {
        addPair(pair, comment, addNewLine, false);
    }

    public void addPair(Pair<String, ?> pair, boolean addNewLine)
    {
        addPair(pair, addNewLine, false);
    }

    public void addPair(Pair<String, ?> pair, String comment, boolean addNewLine, boolean isLast)
    {
        configsList.add(pair);
        configContent +="#The default value is: " + pair.getSecond() + " | " + pair.getSecond().getClass().getSimpleName() + "\n";
        configContent +=
                (this.casing == ConfigKeyCasing.NO_CHANGE
                     ? pair.getFirst()
                     : this.casing == ConfigKeyCasing.ALL_UPPER_CASE
                        ? pair.getFirst().toUpperCase()
                        : pair.getFirst().toLowerCase())
               + " = " + pair.getSecond() + " #" + comment;
        if(addNewLine)
            configContent += "\n\n";
        else if(!isLast)
            configContent += "\n";
    }

    public void addPair(Pair<String, ?> pair, boolean addNewLine, boolean isLast)
    {
        configsList.add(pair);
        configContent +="#The default value is: " + pair.getSecond() + " | " + pair.getSecond().getClass().getSimpleName() + "\n";
        configContent +=
                (this.casing == ConfigKeyCasing.NO_CHANGE
                 ? pair.getFirst()
                 : this.casing == ConfigKeyCasing.ALL_UPPER_CASE
                   ? pair.getFirst().toUpperCase()
                   : pair.getFirst().toLowerCase())
                + " = " + pair.getSecond();
        if(addNewLine)
            configContent += "\n\n";
        else if(!isLast)
            configContent += "\n";
    }

    public void addComment(String comment)
    {
        configContent += "#" + comment + "\n";
    }
    public void addNewLine()
    {
        configContent += "\n";
    }
}