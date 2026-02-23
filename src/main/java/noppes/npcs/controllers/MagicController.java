package noppes.npcs.controllers;

import kamkeel.npcs.controllers.SyncController;
import kamkeel.npcs.network.enums.EnumSyncType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.LogWriter;
import noppes.npcs.api.handler.IMagicHandler;
import noppes.npcs.constants.EnumDiagramLayout;
import noppes.npcs.controllers.data.Magic;
import noppes.npcs.controllers.data.MagicAssociation;
import noppes.npcs.controllers.data.MagicCycle;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

public class MagicController implements IMagicHandler {
    public HashMap<Integer, Magic> magics = new HashMap<>();
    public HashMap<Integer, Magic> magicSync = new HashMap<>();

    public HashMap<Integer, MagicCycle> cycles = new HashMap<>();
    public HashMap<Integer, MagicCycle> cyclesSync = new HashMap<>();

    public int lastUsedCycleID = 0;
    private int lastUsedMagicID = 0;

    private static MagicController instance;

    public MagicController() {
        instance = this;
    }

    public static MagicController getInstance() {
        return instance;
    }

    @Override
    public Magic getMagic(int magicId) {
        return magics.get(magicId);
    }

    @Override
    public MagicCycle getCycle(int cycleID) {
        return cycles.get(cycleID);
    }

    public void load() {
    }

    public NBTTagCompound getNBT() {
        NBTTagList magicList = new NBTTagList();
        for (Magic mag : magics.values()) {
            NBTTagCompound magCompound = new NBTTagCompound();
            mag.writeNBT(magCompound);
            magicList.appendTag(magCompound);
        }
        NBTTagList catList = new NBTTagList();
        for (MagicCycle cat : cycles.values()) {
            NBTTagCompound catCompound = new NBTTagCompound();
            cat.writeNBT(catCompound);
            catList.appendTag(catCompound);
        }
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("lastID", lastUsedMagicID);
        compound.setInteger("lastCycleID", lastUsedCycleID);
        compound.setTag("Magics", magicList);
        compound.setTag("Cycles", catList);
        return compound;
    }

    public void saveMagicData() {
        try {
            File saveDir = CustomNpcs.getWorldSaveDirectory();
            File fileNew = new File(saveDir, "magic.dat_new");
            File fileOld = new File(saveDir, "magic.dat_old");
            File fileCurrent = new File(saveDir, "magic.dat");
            CompressedStreamTools.writeCompressed(getNBT(), new FileOutputStream(fileNew));
            if (fileOld.exists())
                fileOld.delete();
            fileCurrent.renameTo(fileOld);

            if (fileCurrent.exists())
                fileCurrent.delete();
            fileNew.renameTo(fileCurrent);
            if (fileNew.exists()) fileNew.delete();
        } catch (Exception e) {
            LogWriter.except(e);
        }
    }

    // Enforce unique names and IDs for Magics
    public void saveMagic(Magic mag) {
        if (mag.id < 0) {
            mag.id = getUnusedId();
            while (hasName(mag.name))
                mag.name += "_";
        } else {
            Magic existing = magics.get(mag.id);
            if (existing != null && !existing.name.equals(mag.name))
                while (hasName(mag.name))
                    mag.name += "_";
        }
        magics.put(mag.id, mag);

        NBTTagCompound magicCompound = new NBTTagCompound();
        mag.writeNBT(magicCompound);
        SyncController.syncUpdate(EnumSyncType.MAGIC, -1, magicCompound);

        saveMagicData();
    }

    public void removeMagic(int magicID) {
        if (magics.containsKey(magicID)) {
            magics.remove(magicID);
            SyncController.syncRemove(EnumSyncType.MAGIC, magicID);
            saveMagicData();
        }
    }

    public int getUnusedId() {
        if (lastUsedMagicID == 0) {
            for (int id : magics.keySet())
                if (id > lastUsedMagicID)
                    lastUsedMagicID = id;
        }
        lastUsedMagicID++;
        return lastUsedMagicID;
    }

    public boolean hasName(String newName) {
        if (newName.trim().isEmpty()) return true;
        for (Magic mag : magics.values())
            if (mag.name.equalsIgnoreCase(newName))
                return true;
        return false;
    }

    // === Cycle Management Methods ===

    // Returns a new unique cycle ID
    public int getUnusedCycleId() {
        if (lastUsedCycleID == 0) {
            for (int id : cycles.keySet())
                if (id > lastUsedCycleID)
                    lastUsedCycleID = id;
        }
        lastUsedCycleID++;
        return lastUsedCycleID;
    }

    // Checks if a cycle title already exists (case-insensitive)
    public boolean containsCategoryName(String title) {
        title = title.toLowerCase();
        for (MagicCycle cat : cycles.values()) {
            if (cat.name.toLowerCase().equals(title))
                return true;
        }
        return false;
    }

    // Saves a cycle ensuring a unique title and ID
    public void saveCycle(MagicCycle cycle) {
        if (cycle.id < 0) {
            cycle.id = getUnusedCycleId();
            while (containsCategoryName(cycle.name))
                cycle.name += "_";
        } else {
            MagicCycle existing = cycles.get(cycle.id);
            if (existing != null && !existing.name.equals(cycle.name))
                while (containsCategoryName(cycle.name))
                    cycle.name += "_";
        }
        cycles.put(cycle.id, cycle);

        NBTTagCompound cycleCompound = new NBTTagCompound();
        cycle.writeNBT(cycleCompound);
        SyncController.syncUpdate(EnumSyncType.MAGIC_CYCLE, -1, cycleCompound);

        saveMagicData();
    }

    public void removeCycle(int categoryId) {
        if (cycles.containsKey(categoryId)) {
            cycles.remove(categoryId);
            SyncController.syncRemove(EnumSyncType.MAGIC_CYCLE, categoryId);
            saveMagicData();
        }
    }

    /**
     * Associates a magic with a category along with its per-category ordering data.
     */
    @Override
    public void addMagicToCycle(int magicId, int cycleId, int index, int priority) {
        MagicCycle cat = cycles.get(cycleId);
        if (cat == null)
            return;

        Magic magic = magics.get(magicId);
        if (magic == null)
            return;

        MagicAssociation assoc = new MagicAssociation();
        assoc.magicId = magicId;
        assoc.index = index;
        assoc.priority = priority;
        cat.associations.put(magicId, assoc);

        saveCycle(cat);
    }

    @Override
    public void removeMagicFromCycle(int magicId, int cycleId) {
        MagicCycle cat = cycles.get(cycleId);
        if (cat == null) return;
        cat.associations.remove(magicId);

        saveCycle(cat);
    }
}
