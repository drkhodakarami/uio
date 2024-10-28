package jiraiyah.uio.util.config;

import java.io.File;

public class ConfigRequest
{
    private final File file;
    private final String filename;
    private IConfigProvider provider;

    public ConfigRequest(File file, String filename )
    {
        this.file = file;
        this.filename = filename;
        this.provider = IConfigProvider::empty;
    }

    public File getFile()
    {
        return this.file;
    }

    public String getFilename()
    {
        return this.filename;
    }

    /**
     * Sets the default config provider, used to generate the
     * config if it's missing.
     *
     * @param provider default config provider
     * @return current config request object
     * @see IConfigProvider
     */
    public ConfigRequest provider( IConfigProvider provider )
    {
        this.provider = provider;
        return this;
    }

    /**
     * Loads the config from the filesystem.
     *
     * @return config object
     * @see BaseConfig
     */
    public BaseConfig request()
    {
        return new BaseConfig(this);
    }

    public String getConfig()
    {
        return provider.get(filename) + "\n";
    }
}