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

package jiraiyah.uio.registry.misc;

import static jiraiyah.uio.Reference.log;

/**
 * The {@code ModTrades} class is responsible for managing and initializing
 * custom trade registrations within the application. This class is not
 * intended to be instantiated, as it only provides static methods for
 * initialization purposes.
 */
public class ModTrades
{
    /**
     * Constructs a new {@code ModTrades} instance.
     * <p>
     * This constructor is private to prevent instantiation of the class,
     * as it is designed to be used statically. An {@code AssertionError}
     * is thrown if instantiation is attempted.
     */
    ModTrades()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the custom trades by registering them with the system.
     * <p>
     * This method logs a message indicating the start of the registration
     * process for custom trades. It utilizes the organization's logging
     * mechanism to output the message.
     */
    public static void init()
    {
        log("Registering Custom Trades");
    }
}