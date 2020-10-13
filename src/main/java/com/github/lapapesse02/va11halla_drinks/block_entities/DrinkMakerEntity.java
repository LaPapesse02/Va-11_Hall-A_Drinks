package com.github.lapapesse02.va11halla_drinks.block_entities;

import com.github.lapapesse02.va11halla_drinks.inventories.ImplementedInventory;
import com.github.lapapesse02.va11halla_drinks.guis.DrinkMakerGuiDescription;
import com.github.lapapesse02.va11halla_drinks.register.RegisterBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class DrinkMakerEntity extends BlockEntity implements ImplementedInventory, SidedInventory, InventoryProvider, NamedScreenHandlerFactory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public DrinkMakerEntity() {
        super(RegisterBlocks.DRINK_MAKER_ENTITY_TYPE);
    }

    public DrinkMakerEntity(Inventory inventory) {
        super(RegisterBlocks.DRINK_MAKER_ENTITY_TYPE);
        for (int i = 0; i < inventory.size(); i++) {
            this.setStack(i, inventory.getStack(i));
        }
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return true;
    }

    /**
     * @param player
     * @return true if the player can use the inventory, false otherwise.
     */
    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    /**
     * Retrieves the item in the slot.
     *
     * @param slot
     */
    @Override
    public ItemStack getStack(int slot) {
        return getItems().get(slot);
    }

    /**
     * Removes all items from an inventory slot.
     *
     * @param slot The slot to remove from.
     */
    @Override
    public ItemStack removeStack(int slot) {
        return getItems().remove(slot);
    }

    /**
     * Replaces the current stack in an inventory slot with the provided stack.
     *
     * @param slot  The inventory slot of which to replace the itemstack.
     * @param stack The replacing itemstack. If the stack is too big for
     *              this inventory ({@link Inventory#getMaxCountPerStack()}),
     */
    @Override
    public void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
    }

    @Override
    public int count(Item item) {
        int count = 0;
        for (int i = 0; i < size()-3; i++) {
            if (items.get(i).getItem().equals(item)) {
                count += items.get(i).getCount();
            }
        }
        return count;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, items);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag, items);
        return super.toTag(tag);
    }

    /**
     * Retrieves the item list of this inventory.
     * Must return the same instance every time it's called.
     */
    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        int[] result = new int[getItems().size() - 3];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == 5 && dir == Direction.DOWN;
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return getInventory();
    }

    public SidedInventory getInventory() {
        return this;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new DrinkMakerGuiDescription(syncId, inventory, ScreenHandlerContext.create(world, this.getPos()));
    }
}
