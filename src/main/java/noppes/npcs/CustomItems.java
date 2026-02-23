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
import noppes.npcs.blocks.BlockBanner;
import noppes.npcs.blocks.BlockBeam;
import noppes.npcs.blocks.BlockBigSign;
import noppes.npcs.blocks.BlockBook;
import noppes.npcs.blocks.BlockBorder;
import noppes.npcs.blocks.BlockCandle;
import noppes.npcs.blocks.BlockCarpentryBench;
import noppes.npcs.blocks.BlockChair;
import noppes.npcs.blocks.BlockCouchWood;
import noppes.npcs.blocks.BlockCouchWool;
import noppes.npcs.blocks.BlockCrate;
import noppes.npcs.blocks.BlockCrystal;
import noppes.npcs.blocks.BlockLantern;
import noppes.npcs.blocks.BlockMailbox;
import noppes.npcs.blocks.BlockNpcRedstone;
import noppes.npcs.blocks.BlockPedestal;
import noppes.npcs.blocks.BlockPlaceholder;
import noppes.npcs.blocks.BlockScripted;
import noppes.npcs.blocks.BlockShelf;
import noppes.npcs.blocks.BlockSign;
import noppes.npcs.blocks.BlockStool;
import noppes.npcs.blocks.BlockTable;
import noppes.npcs.blocks.BlockTombstone;
import noppes.npcs.blocks.BlockWallBanner;
import noppes.npcs.blocks.BlockWaypoint;
import noppes.npcs.blocks.BlockWeaponRack;
import noppes.npcs.blocks.tiles.TileBanner;
import noppes.npcs.blocks.tiles.TileBeam;
import noppes.npcs.blocks.tiles.TileBigSign;
import noppes.npcs.blocks.tiles.TileBlockAnvil;
import noppes.npcs.blocks.tiles.TileBook;
import noppes.npcs.blocks.tiles.TileBorder;
import noppes.npcs.blocks.tiles.TileCandle;
import noppes.npcs.blocks.tiles.TileChair;
import noppes.npcs.blocks.tiles.TileCouchWood;
import noppes.npcs.blocks.tiles.TileCouchWool;
import noppes.npcs.blocks.tiles.TileCrate;
import noppes.npcs.blocks.tiles.TileLamp;
import noppes.npcs.blocks.tiles.TileMailbox;
import noppes.npcs.blocks.tiles.TilePedestal;
import noppes.npcs.blocks.tiles.TileRedstoneBlock;
import noppes.npcs.blocks.tiles.TileScripted;
import noppes.npcs.blocks.tiles.TileShelf;
import noppes.npcs.blocks.tiles.TileSign;
import noppes.npcs.blocks.tiles.TileStool;
import noppes.npcs.blocks.tiles.TileTable;
import noppes.npcs.blocks.tiles.TileTombstone;
import noppes.npcs.blocks.tiles.TileWallBanner;
import noppes.npcs.blocks.tiles.TileWaypoint;
import noppes.npcs.blocks.tiles.TileWeaponRack;
import noppes.npcs.config.ConfigItem;
import noppes.npcs.items.ItemLinked;
import noppes.npcs.items.ItemMounter;
import noppes.npcs.items.ItemNpcBlock;
import noppes.npcs.items.ItemNpcCloner;
import noppes.npcs.items.ItemNpcColored;
import noppes.npcs.items.ItemNpcMovingPath;
import noppes.npcs.items.ItemNpcScripter;
import noppes.npcs.items.ItemNpcTool;
import noppes.npcs.items.ItemNpcWand;
import noppes.npcs.items.ItemPlaceholder;
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

    public static Block redstoneBlock;
    public static Block carpentyBench;
    public static Block mailbox;
    public static Block waypoint;
    public static Block border;

    public static Block banner;
    public static Block wallBanner;
    public static Block book;
    public static Block chair;
    public static Block crate;
    public static Block weaponsRack;
    public static Block pedestal;
    public static Block couchWool;
    public static Block couchWood;
    public static Block table;
    public static Block stool;
    public static Block bigsign;
    public static Block barrel;
    public static Block tombstone;
    public static Block shelf;
    public static Block sign;
    public static Block beam;
    public static Block crystal;

    public static Block lantern;
    public static Block candle;

    public static Block lantern_unlit;
    public static Block candle_unlit;
    public static Block scripted;

    public static CreativeTabNpcs tab = new CreativeTabNpcs("cnpcs");
    public static CreativeTabNpcs tabBlocks = new CreativeTabNpcs("cnpcsb");

    public static void load() {
        GameRegistry.registerTileEntity(TileRedstoneBlock.class, "TileRedstoneBlock");
        GameRegistry.registerTileEntity(TileBlockAnvil.class, "TileBlockAnvil");
        GameRegistry.registerTileEntity(TileMailbox.class, "TileMailbox");
        GameRegistry.registerTileEntity(TileWaypoint.class, "TileWaypoint");
        GameRegistry.registerTileEntity(TileBanner.class, "TileNPCBanner");
        GameRegistry.registerTileEntity(TileScripted.class, "TileNPCScripted");

        if (!ConfigItem.DisableExtraBlock) {
            GameRegistry.registerTileEntity(TileWallBanner.class, "TileNPCWallBanner");
            GameRegistry.registerTileEntity(TileChair.class, "TileNPCChair");
            GameRegistry.registerTileEntity(TileCrate.class, "TileNPCCrate");
            GameRegistry.registerTileEntity(TileWeaponRack.class, "TileNPCWeaponRack");
            GameRegistry.registerTileEntity(TileCouchWool.class, "TileNPCCouchWool");
            GameRegistry.registerTileEntity(TileCouchWood.class, "TileNPCCouchWood");
            GameRegistry.registerTileEntity(TileTable.class, "TileNPCTable");
            GameRegistry.registerTileEntity(TileLamp.class, "TileNPCLamp");
            GameRegistry.registerTileEntity(TileCandle.class, "TileNPCCandle");
            GameRegistry.registerTileEntity(TileBorder.class, "TileNPCBorder");
            GameRegistry.registerTileEntity(TileStool.class, "TileNPCStool");
            GameRegistry.registerTileEntity(TileBigSign.class, "TileNPCBigSign");
            GameRegistry.registerTileEntity(TileTombstone.class, "TileNPCTombstone");
            GameRegistry.registerTileEntity(TileShelf.class, "TileNPCShelf");
            GameRegistry.registerTileEntity(TileSign.class, "TileNPCSign");
            GameRegistry.registerTileEntity(TileBeam.class, "TileNPCBeam");
            GameRegistry.registerTileEntity(TileBook.class, "TileNPCBook");
            GameRegistry.registerTileEntity(TilePedestal.class, "TileNPCPedestal");
        }
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
        carpentyBench = new BlockCarpentryBench().setBlockName("npcCarpentyBench").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(tabBlocks);
        mailbox = new BlockMailbox().setBlockName("npcMailbox").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tabBlocks);
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

        if (!ConfigItem.DisableExtraBlock) {
            banner = new BlockBanner().setBlockName("npcBanner").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth).setCreativeTab(tabBlocks);
            wallBanner = new BlockWallBanner().setBlockName("npcWallBanner").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth).setCreativeTab(tabBlocks);
            chair = new BlockChair().setBlockName("npcChair").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            crate = new BlockCrate().setBlockName("npcCrate").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            weaponsRack = new BlockWeaponRack().setBlockName("npcWeaponRack").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            couchWool = new BlockCouchWool().setBlockName("npcCouchWool").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            table = new BlockTable().setBlockName("npcTable").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            couchWood = new BlockCouchWood().setBlockName("npcCouchWood").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            lantern = new BlockLantern(true).setBlockName("npcLamp").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tabBlocks).setBlockTextureName("customnpcs:lantern");
            candle = new BlockCandle(true).setBlockName("npcCandle").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(tabBlocks).setBlockTextureName("customnpcs:candle");
            stool = new BlockStool().setBlockName("npcStool").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            Block placeholder = new BlockPlaceholder().setBlockName("npcPlaceholder").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            bigsign = new BlockBigSign().setBlockName("npcBigSign").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            tombstone = new BlockTombstone().setBlockName("npcTombstone").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(tabBlocks);
            shelf = new BlockShelf().setBlockName("npcShelf").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            sign = new BlockSign().setBlockName("npcSign").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            beam = new BlockBeam().setBlockName("npcBeam").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            book = new BlockBook().setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            pedestal = new BlockPedestal().setBlockName("npcPedestal").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
            crystal = new BlockCrystal().setBlockName("npcCrystal").setBlockTextureName("customnpcs:npcCrystal").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabBlocks);

            lantern_unlit = new BlockLantern(false).setBlockName("npcLamp").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName("customnpcs:lantern");
            candle_unlit = new BlockCandle(false).setBlockName("npcCandle").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("customnpcs:candle");

            GameRegistry.registerBlock(banner, ItemBlock.class, "npcBanner");
            GameRegistry.registerBlock(wallBanner, ItemBlock.class, "npcWallBanner");
            GameRegistry.registerBlock(chair, ItemBlock.class, "npcChair");
            GameRegistry.registerBlock(crate, ItemBlock.class, "npcCrate");
            GameRegistry.registerBlock(weaponsRack, ItemBlock.class, "npcWeaponRack");
            GameRegistry.registerBlock(couchWool, ItemBlock.class, "npcCouchWool");
            GameRegistry.registerBlock(couchWood, ItemBlock.class, "npcCouchWood");
            GameRegistry.registerBlock(table, ItemBlock.class, "npcTable");
            GameRegistry.registerBlock(stool, ItemBlock.class, "npcStool");
            GameRegistry.registerBlock(placeholder, ItemPlaceholder.class, "npcPlaceholder");
            GameRegistry.registerBlock(bigsign, "npcBigSign");
            GameRegistry.registerBlock(tombstone, ItemBlock.class, "npcTombstone");
            GameRegistry.registerBlock(shelf, ItemBlock.class, "npcShelf");
            GameRegistry.registerBlock(sign, ItemBlock.class, "npcSign");
            GameRegistry.registerBlock(beam, ItemBlock.class, "npcBeam");
            GameRegistry.registerBlock(book, "npcBook");
            GameRegistry.registerBlock(pedestal, ItemBlock.class, "npcPedestal");
            GameRegistry.registerBlock(crystal, ItemNpcColored.class, "npcCrystalBlock");
            GameRegistry.registerBlock(lantern, "npcLamp");
            GameRegistry.registerBlock(candle, "npcCandle");
            GameRegistry.registerBlock(candle_unlit, "npcLampUnlit");
            GameRegistry.registerBlock(lantern_unlit, "npcCandleUnlit");

            Item.getItemFromBlock(banner).setHasSubtypes(true);
            Item.getItemFromBlock(wallBanner).setHasSubtypes(true);
            Item.getItemFromBlock(chair).setHasSubtypes(true);
            Item.getItemFromBlock(crate).setHasSubtypes(true);
            Item.getItemFromBlock(weaponsRack).setHasSubtypes(true);
            Item.getItemFromBlock(couchWool).setHasSubtypes(true);
            Item.getItemFromBlock(couchWood).setHasSubtypes(true);
            Item.getItemFromBlock(table).setHasSubtypes(true);
            Item.getItemFromBlock(stool).setHasSubtypes(true);
            Item.getItemFromBlock(tombstone).setHasSubtypes(true);
            Item.getItemFromBlock(shelf).setHasSubtypes(true);
            Item.getItemFromBlock(sign).setHasSubtypes(true);
            Item.getItemFromBlock(beam).setHasSubtypes(true);
            Item.getItemFromBlock(pedestal).setHasSubtypes(true);

            tabBlocks.item = Item.getItemFromBlock(couchWool);
            tabBlocks.meta = 1;
        }

        tab.item = wand;
    }
}
