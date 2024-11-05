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

package jiraiyah.uio.util.inventory;

import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public interface IWrappedInventoryProvider extends IWrappedInventory<SimpleInventory>
{
    /**
     * The index of output inventory. This constant is always the same
     * because we are registering the output inventory as index zero all the time.
     */
    int DEFAULT_OUTPUT_INDEX = 0;

    /**
     * The size of the output inventory, representing the maximum number of items
     * that can be held in this inventory. This constant can be overridden in
     * subclasses to accommodate different output capacities as needed. By default,
     * the output inventory is set to allow only one item, making it suitable for
     * scenarios where a single item output is required.
     */
    int DEFAULT_OUTPUT_SIZE = 1;

    /**
     * The direction in which the output inventory is oriented. This constant
     * defines the default direction for item extraction from the output inventory.
     * Subclasses can override this value if a different output direction is needed
     * for more specialized behavior. By default, the output direction is set to
     * Direction.DOWN, indicating that items are extracted downward from the block
     * entity.
     */
    Direction DEFAULT_OUTPUT_DIRECTION = Direction.DOWN;


    /**
     * Adds an output inventory to this block entity.
     * <p>
     * This method initializes an output inventory of the specified size, allowing
     * items to be extracted or transferred from the block entity in the specified
     * direction. The output inventory facilitates item management and interactions
     * with neighboring blocks or entities.
     * </p>
     *
     * @param size     The size (capacity) of the output inventory. This determines
     *                 how many items the inventory can hold.
     * @param direction The direction from which items can be extracted from the
     *                  output inventory. This parameter can restrict access to the
     *                  inventory from a specific direction (e.g., NORTH, SOUTH).
     *                  If set to null, the inventory may be accessible from all
     *                  directions.
     */
    void addOutputInventory(int size, Direction direction);

    /**
     * Retrieves the wrapped inventory storage of this block entity.
     * The inventory storage contains all inventories associated with the
     * block entity and allows for various inventory operations.
     *
     * @return The WrappedInventoryStorage instance containing the block entity's inventory.
     */
    WrappedInventoryStorage<SimpleInventory> getInventory();

    /**
     * Retrieves the storage for the inventory associated with this block entity
     * in the specified direction. This method allows for accessing the inventory
     * storage in relation to the block entity's orientation, enabling proper
     * interactions with neighboring blocks or entities.
     *
     * @param direction The direction from which the inventory storage is being accessed.
     *                  If null, the storage for all directions may be considered.
     *
     * @return The InventoryStorage instance for the specified direction, or null if
     * no inventory storage exists in that direction.
     */
    InventoryStorage getInventoryStorage(@Nullable Direction direction);

    /**
     * Retrieves the output inventory of this block entity. The output inventory is
     * specifically designated for holding items that can be extracted or transferred
     * from the block entity. If the inventory has been initialized and contains output
     * storage, this method returns the corresponding SimpleInventory; otherwise,
     * it returns null.
     *
     * @return The SimpleInventory instance representing the output inventory, or
     * null if no output inventory exists or is initialized.
     */
    SimpleInventory getOutputInventory();
}