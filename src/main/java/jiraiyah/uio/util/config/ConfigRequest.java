/***********************************************************************************
 * Copyright (c) 2024 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.uio.util.config;

import java.io.File;

/**
 * A request for a config object.
 */
public class ConfigRequest
{
    private final File file;
    private final String filename;
    private IConfigProvider provider;

    /**
     * Creates a new config request.
     *
     * @param file     the file to load the config from
     * @param filename the filename of the config file
     */
    public ConfigRequest(File file, String filename)
    {
        this.file = file;
        this.filename = filename;
        this.provider = IConfigProvider::empty;
    }

    /**
     * @return the file to load the config from
     */
    public File getFile()
    {
        return this.file;
    }

    /**
     * @return the filename of the config file
     */
    public String getFilename()
    {
        return this.filename;
    }

    /**
     * Sets the default config provider, used to generate the
     * config if it's missing.
     *
     * @param provider default config provider
     *
     * @return current config request object
     *
     * @see IConfigProvider
     */
    public ConfigRequest provider(IConfigProvider provider)
    {
        this.provider = provider;
        return this;
    }

    /**
     * Loads the config from the filesystem.
     *
     * @return config object
     *
     * @see BaseConfig
     */
    public BaseConfig request()
    {
        return new BaseConfig(this);
    }

    /**
     * @return the config from the provider
     */
    public String getConfig()
    {
        return provider.get(filename) + "\n";
    }
}