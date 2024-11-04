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

import static jiraiyah.uio.Reference.logN;

/**
 * The main config entry class. Your mod's config class should extend this class.
 *
 * @author Jiraiyah
 */
public abstract class Config
{
    protected static BaseConfig CONFIG;

    protected static ConfigProvider provider;

    protected Config()
    {
    }

    /**
     * @return the current config instance.
     */
    public static BaseConfig getConfig()
    {
        return CONFIG;
    }

    /**
     * Loads the config for the specified mod.
     *
     * @param modID The mod ID of the mod to load the config for.
     */
    public static void load(String modID)
    {
        provider = new ConfigProvider(ConfigKeyCasing.ALL_UPPER_CASE);
        createConfigs();

        CONFIG = BaseConfig.of(modID + "_config").provider(provider).request();

        logN("All " + provider.getConfigList().size() + " config entries have been set properly");

        assignConfigValues();

        logN("All " + provider.getConfigList().size() + " config entries have been loaded properly");
    }

    /**
     * Creates the config entries for the mod.
     */
    protected static void createConfigs()
    {
    }

    /**
     * Assigns the values of the config entries to their respective variables.
     */
    protected static void assignConfigValues()
    {
    }

}