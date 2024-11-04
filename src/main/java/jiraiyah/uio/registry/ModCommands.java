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

package jiraiyah.uio.registry;

import jiraiyah.uio.command.DclrCommand;

import static jiraiyah.uio.Reference.*;

/**
 * The {@code ModCommands} class handles the registration of commands for the application.
 * <p>
 * This class is not meant to be instantiated, as it contains a private constructor that
 * throws an {@code AssertionError}. Instead, it provides a static initialization method
 * to register commands.
 * </p>
 * <p>
 * The main functionality of this class is encapsulated in the {@link #init()} method,
 * which logs the registration process and calls the {@link DclrCommand#register()} method
 * to register specific commands.
 * </p>
 *
 * @see DclrCommand
 * @see Reference
 */
public class ModCommands
{
    /**
     * Constructs a new instance of the {@code ModCommands} class.
     * <p>
     * This constructor is intended to be private and throws an {@code AssertionError}
     * to prevent instantiation of the {@code ModCommands} class, as it is designed
     * to function solely through its static methods.
     * </p>
     *
     * @throws AssertionError if an attempt is made to instantiate this class.
     */
    ModCommands()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the command registration process for the application.
     * <p>
     * This method logs a message indicating that the command registration is
     * taking place and subsequently calls the {@link DclrCommand#register()} method
     * to register the commands defined in the {@code DclrCommand} class.
     * </p>
     * <p>
     * This method is static and can be called without creating an instance of the
     * {@code ModCommands} class, making it suitable for initial setup in the
     * application lifecycle.
     * </p>
     */
    public static void init()
    {
        log("Registering Commands");

        DclrCommand.register();
    }
}