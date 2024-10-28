package jiraiyah.uio.util.config;

import static jiraiyah.uio.Reference.logN;

public abstract class Config
{
    protected static BaseConfig CONFIG;

    protected static ConfigProvider provider;

    protected Config(){}

    public static BaseConfig getConfig()
    {
        return CONFIG;
    }

    public static void load(String modID)
    {
        provider = new ConfigProvider(ConfigKeyCasing.ALL_UPPER_CASE);
        createConfigs();

        CONFIG = BaseConfig.of(modID + "_config").provider(provider).request();

        logN("All " + provider.getConfigList().size() + " config entries have been set properly");

        assignConfigValues();

        logN("All " + provider.getConfigList().size() + " config entries have been loaded properly");
    }

    protected static void createConfigs(){};
    protected static void assignConfigValues(){};
}