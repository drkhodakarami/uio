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

import com.mojang.datafixers.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to provide a way to store and retrieve configuration values.
 *
 * @author Kaupenjoe, Jiraiyah
 */
public class ConfigProvider implements IConfigProvider
{
    private String configContent;
    private final List<Pair<String, ?>> configsList;
    private final ConfigKeyCasing casing;

    /**
     * The default constructor with no change of casing for the config keys.
     */
    public ConfigProvider()
    {
        this(ConfigKeyCasing.NO_CHANGE);
    }

    /**
     * The constructor with a specified casing for the config keys.
     *
     * @param casing The casing to use for the config keys.
     */
    public ConfigProvider(ConfigKeyCasing casing)
    {
        this.configContent = "";
        this.configsList = new ArrayList<>();
        this.casing = casing;
    }

    /**
     * @return The list of pairs containing the config keys and their values.
     */
    public List<Pair<String, ?>> getConfigList()
    {
        return configsList;
    }

    /**
     * @param namespace The namespace to get the value for.
     *
     * @return The value of the specified namespace.
     */
    @Override
    public String get(String namespace)
    {
        return this.configContent;
    }

    /**
     * Adds a new entry pair to the config system with custom comment
     *
     * @param pair    The pair to add to the config system.
     * @param comment The comment to add to the config system.
     */
    public void addPair(Pair<String, ?> pair, String comment)
    {
        addPair(pair, comment, true, false);
    }

    /**
     * Adds a new entry pair to the config system without custom comment
     *
     * @param pair The pair to add to the config system.
     */
    public void addPair(Pair<String, ?> pair)
    {
        addPair(pair, true, false);
    }

    /**
     * Adds a new entry pair to the config system with custom comment. It asks to add a new line after the entry or not.
     *
     * @param pair       The pair to add to the config system.
     * @param comment    The comment to add to the config system.
     * @param addNewLine Whether to add a new line after the entry or not.
     */
    public void addPair(Pair<String, ?> pair, String comment, boolean addNewLine)
    {
        addPair(pair, comment, addNewLine, false);
    }

    /**
     * Adds a new entry pair to the config system without custom comment. It asks to add a new line after the entry or not.
     *
     * @param pair       The pair to add to the config system.
     * @param addNewLine Whether to add a new line after the entry or not.
     */
    public void addPair(Pair<String, ?> pair, boolean addNewLine)
    {
        addPair(pair, addNewLine, false);
    }

    /**
     * Adds a new entry pair to the config system with custom comment. It asks to add a new line after the entry or not. We can mark an entry as the last one.
     *
     * @param pair       The pair to add to the config system.
     * @param comment    The comment to add to the config system.
     * @param addNewLine Whether to add a new line after the entry or not.
     * @param isLast     Whether the entry is the last one or not.
     */
    public void addPair(Pair<String, ?> pair, String comment, boolean addNewLine, boolean isLast)
    {
        configsList.add(pair);
        configContent += "#The default value is: " + pair.getSecond() + " | " + pair.getSecond().getClass().getSimpleName() + "\n";
        configContent +=
                (this.casing == ConfigKeyCasing.NO_CHANGE
                 ? pair.getFirst()
                 : this.casing == ConfigKeyCasing.ALL_UPPER_CASE
                   ? pair.getFirst().toUpperCase()
                   : pair.getFirst().toLowerCase())
                + " = " + pair.getSecond() + " #" + comment;
        if (addNewLine)
            configContent += "\n\n";
        else if (!isLast)
            configContent += "\n";
    }

    /**
     * Adds a new entry pair to the config system without custom comment. It asks to add a new line after the entry or not. We can mark an entry as the last one.
     *
     * @param pair       The pair to add to the config system.
     * @param addNewLine Whether to add a new line after the entry or not.
     * @param isLast     Whether the entry is the last one or not.
     */
    public void addPair(Pair<String, ?> pair, boolean addNewLine, boolean isLast)
    {
        configsList.add(pair);
        configContent += "#The default value is: " + pair.getSecond() + " | " + pair.getSecond().getClass().getSimpleName() + "\n";
        configContent +=
                (this.casing == ConfigKeyCasing.NO_CHANGE
                 ? pair.getFirst()
                 : this.casing == ConfigKeyCasing.ALL_UPPER_CASE
                   ? pair.getFirst().toUpperCase()
                   : pair.getFirst().toLowerCase())
                + " = " + pair.getSecond();
        if (addNewLine)
            configContent += "\n\n";
        else if (!isLast)
            configContent += "\n";
    }

    /**
     * Adds a new comment to the config system.
     *
     * @param comment The comment to add to the config system.
     */
    public void addComment(String comment)
    {
        configContent += "#" + comment + "\n";
    }

    /**
     * Adds a new line to the config system.
     */
    public void addNewLine()
    {
        configContent += "\n";
    }
}