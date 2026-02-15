package noppes.npcs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import noppes.npcs.blocks.BlockBorder;
import noppes.npcs.blocks.BlockCarpentryBench;
import noppes.npcs.blocks.BlockMailbox;
import noppes.npcs.blocks.BlockNpcRedstone;
import noppes.npcs.blocks.BlockScripted;
import noppes.npcs.blocks.BlockWaypoint;
import noppes.npcs.blocks.tiles.TileBlockAnvil;
import noppes.npcs.blocks.tiles.TileMailbox;
import noppes.npcs.blocks.tiles.TileRedstoneBlock;
import noppes.npcs.blocks.tiles.TileScripted;
import noppes.npcs.blocks.tiles.TileWaypoint;
import noppes.npcs.items.ItemLinked;
import noppes.npcs.items.ItemMounter;
import noppes.npcs.items.ItemMusic;
import noppes.npcs.items.ItemMusicBanjo;
import noppes.npcs.items.ItemMusicClarinet;
import noppes.npcs.items.ItemMusicOracina;
import noppes.npcs.items.ItemMusicViolin;
import noppes.npcs.items.ItemNpcBlock;
import noppes.npcs.items.ItemNpcCloner;
import noppes.npcs.items.ItemNpcInterface;
import noppes.npcs.items.ItemNpcMovingPath;
import noppes.npcs.items.ItemNpcScripter;
import noppes.npcs.items.ItemNpcTool;
import noppes.npcs.items.ItemNpcWand;
import noppes.npcs.items.ItemScripted;
import noppes.npcs.items.ItemSoulstoneEmpty;
import noppes.npcs.items.ItemSoulstoneFilled;
import noppes.npcs.items.ItemTeleporter;

public class CustomItems {

    public static Item wand;
    public static Item cloner;
    public static Item scripter;
    public static Item moving;
    public static Item mount;
    public static Item teleporter;
    public static Item tool;

    public static Item scripted_item;
    public static Item linked_item;

    public static Item soulstoneEmpty;
    public static Item soulstoneFull;

    public static Item banjo;
    public static Item violin;
    public static Item violinbow;
    public static Item harp;
    public static Item guitar;
    public static Item frenchHorn;
    public static Item clarinet;
    public static Item ocarina;

    public static Item spellNature;
    public static Item spellArcane;
    public static Item spellFire;
    public static Item spellDark;
    public static Item spellHoly;

    public static Item earthElement;
    public static Item waterElement;
    public static Item airElement;

    public static Item mana;

    public static Item kunai;
    public static Item shuriken;

    public static Item letter;
    public static Item bag;
    public static Item satchel;

    public static Block redstoneBlock;
    public static Block carpentyBench;
    public static Block mailbox;
    public static Block waypoint;
    public static Block border;
    public static Block scripted;

    public static CreativeTabNpcs tab = new CreativeTabNpcs("cnpcs");

    public static void load() {
        GameRegistry.registerTileEntity(TileRedstoneBlock.class, "TileRedstoneBlock");
        GameRegistry.registerTileEntity(TileBlockAnvil.class, "TileBlockAnvil");
        GameRegistry.registerTileEntity(TileMailbox.class, "TileMailbox");
        GameRegistry.registerTileEntity(TileWaypoint.class, "TileWaypoint");
        GameRegistry.registerTileEntity(TileScripted.class, "TileNPCScripted");

        wand = new ItemNpcWand().setUnlocalizedName("npcWand").setFull3D();
        cloner = new ItemNpcCloner().setUnlocalizedName("npcMobCloner").setFull3D();
        scripter = new ItemNpcScripter().setUnlocalizedName("npcScripter").setFull3D();
        moving = new ItemNpcMovingPath().setUnlocalizedName("npcMovingPath").setFull3D();
        mount = new ItemMounter().setUnlocalizedName("npcMounter").setFull3D();
        teleporter = new ItemTeleporter().setUnlocalizedName("npcTeleporter").setFull3D();
        scripted_item = new ItemScripted().setUnlocalizedName("scripted_item").setFull3D();
        linked_item = new ItemLinked().setUnlocalizedName("linked_item").setFull3D();
        tool = new ItemNpcTool().setUnlocalizedName("npcTool").setFull3D();

        redstoneBlock = new BlockNpcRedstone().setHardness(50.0F).setResistance(2000).setBlockName("npcRedstoneBlock").setBlockTextureName("customnpcs:npcRedstoneBlock").setCreativeTab(tab);
        carpentyBench = new BlockCarpentryBench().setBlockName("npcCarpentyBench").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(tab);
        mailbox = new BlockMailbox().setBlockName("npcMailbox").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tab);
        waypoint = new BlockWaypoint().setBlockName("npcLocationBlock").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName("customnpcs:npcWaypoint").setCreativeTab(tab);
        border = new BlockBorder().setBlockName("npcBorder").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tab).setBlockTextureName("customnpcs:npcBorder");
        scripted = new BlockScripted().setBlockName("npcScripted").setHardness(5.0F).setResistance(10.0F).setCreativeTab(tab).setBlockTextureName("customnpcs:npcScripted");

        soulstoneEmpty = new ItemSoulstoneEmpty().setUnlocalizedName("npcSoulstoneEmpty").setTextureName("customnpcs:npcSoulstoneEmpty").setCreativeTab(tab);
        soulstoneFull = new ItemSoulstoneFilled().setUnlocalizedName("npcSoulstoneFilled").setTextureName("customnpcs:npcSoulstoneFilled");

        BlockDispenser.dispenseBehaviorRegistry.putObject(soulstoneFull, new BehaviorDefaultDispenseItem() {

            @Override
            public ItemStack dispenseStack(IBlockSource source, ItemStack item) {
                EnumFacing enumfacing = BlockDispenser.func_149937_b(source.getBlockMetadata());
                int x = source.getXInt() + enumfacing.getFrontOffsetX();
                int z = source.getZInt() + enumfacing.getFrontOffsetZ();
                ((ItemSoulstoneFilled) soulstoneFull).spawn(null, item, source.getWorld(), x, source.getYInt(), z);
                item.splitStack(1);
                return item;
            }
        });
        GameRegistry.registerBlock(redstoneBlock, "npcRedstoneBlock");
        GameRegistry.registerBlock(carpentyBench, ItemNpcBlock.class, "npcCarpentyBench");
        GameRegistry.registerBlock(mailbox, ItemBlock.class, "npcMailbox");
        GameRegistry.registerBlock(waypoint, "npcWaypoint");
        GameRegistry.registerBlock(border, "npcBorder");
        GameRegistry.registerBlock(scripted, "npcScripted");

        Item.getItemFromBlock(mailbox).setHasSubtypes(true);
        Item.getItemFromBlock(carpentyBench).setHasSubtypes(true);

        ((ItemNpcBlock) Item.getItemFromBlock(carpentyBench)).names = new String[]{"tile.npcCarpentyBench", "tile.anvil"};

        banjo = new ItemMusicBanjo().setUnlocalizedName("npcBanjo").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBanjo");
        violin = new ItemMusicViolin().setUnlocalizedName("npcViolin").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcViolin");
        violinbow = new ItemNpcInterface().setUnlocalizedName("npcViolinBow").setFull3D().setMaxStackSize(1).setCreativeTab(CustomItems.tab).setTextureName("customnpcs:npcViolinBow");
        harp = new ItemMusicViolin().setUnlocalizedName("npcHarp").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcHarp");
        guitar = new ItemMusicBanjo().setUnlocalizedName("npcGuitar").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcGuitar");
        frenchHorn = new ItemMusic().setRotated().setUnlocalizedName("npcFrenchHorn").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcFrenchHorn");
        ocarina = new ItemMusicOracina().setUnlocalizedName("npcOcarina").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcOcarina");
        clarinet = new ItemMusicClarinet().setUnlocalizedName("npcClarinet").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcClarinet");

        tab.item = wand;
    }
}
