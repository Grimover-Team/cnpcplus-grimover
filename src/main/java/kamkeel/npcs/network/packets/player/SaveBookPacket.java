package kamkeel.npcs.network.packets.player;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import kamkeel.npcs.network.LargeAbstractPacket;
import kamkeel.npcs.network.PacketChannel;
import kamkeel.npcs.network.PacketHandler;
import kamkeel.npcs.network.enums.EnumPlayerPacket;
import kamkeel.npcs.util.ByteBufUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;

import java.io.IOException;

public class SaveBookPacket extends LargeAbstractPacket {
    public static final String packetName = "Player|SaveBook";

    private int x, y, z;
    private boolean sign;
    private NBTTagCompound compound;

    public SaveBookPacket() {

    }

    public SaveBookPacket(int x, int y, int z, boolean sign, NBTTagCompound compound) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sign = sign;
        this.compound = compound;
    }

    @Override
    protected byte[] getData() throws IOException {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeInt(x);
        buffer.writeInt(y);
        buffer.writeInt(z);
        buffer.writeBoolean(sign);
        ByteBufUtils.writeBigNBT(buffer, compound);
        return buffer.array();
    }

    @Override
    protected void handleCompleteData(ByteBuf data, EntityPlayer player) throws IOException {
    }

    @Override
    public Enum getType() {
        return EnumPlayerPacket.SaveBook;
    }

    @Override
    public PacketChannel getChannel() {
        return PacketHandler.PLAYER_PACKET;
    }
}
