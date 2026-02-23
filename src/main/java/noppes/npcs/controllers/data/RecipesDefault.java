package noppes.npcs.controllers.data;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import noppes.npcs.CustomItems;
import noppes.npcs.config.ConfigItem;
import noppes.npcs.controllers.RecipeController;

public class RecipesDefault {
    public static void addRecipe(String name, Object ob, boolean isGlobal, Object... recipe) {
        ItemStack item;
        if (ob instanceof Item)
            item = new ItemStack((Item) ob);
        else if (ob instanceof Block)
            item = new ItemStack((Block) ob);
        else
            item = (ItemStack) ob;

        RecipeCarpentry recipeCarpentry = new RecipeCarpentry(name);
        recipeCarpentry.isGlobal = isGlobal;
        recipeCarpentry = RecipeCarpentry.saveRecipe(recipeCarpentry, item, recipe);
        RecipeController.Instance.addRecipe(recipeCarpentry);
    }

    public static void loadDefaultRecipes(int i) {
    }
}
