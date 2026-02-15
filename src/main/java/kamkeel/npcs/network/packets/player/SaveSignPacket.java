package kamkeel.npcs.network.packets.player;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import kamkeel.npcs.network.LargeAbstractPacket;
import kamkeel.npcs.network.PacketChannel;
import kamkeel.npcs.network.PacketHandler;
import kamkeel.npcs.network.enums.EnumPlayerPacket;
import kamkeel.npcs.util.ByteBufUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import java.io.IOException;

public class SaveSignPacket extends LargeAbstractPacket {
    public static final String packetName = "Player|SaveSign";
    private int x, y, z;
    private String text;

    public SaveSignPacket() {

    }

    public SaveSignPacket(int x, int y, int z, String text) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.text = text;
    }

    @Override
    protected byte[] getData() throws IOException {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeInt(x);
        buffer.writeInt(y);
        buffer.writeInt(z);
        ByteBufUtils.writeString(buffer, text);
        return buffer.array();
    }

    @Override
    protected void handleCompleteData(ByteBuf data, EntityPlayer player) throws IOException {
    }

    @Override
    public Enum getType() {
        return EnumPlayerPacket.SaveSign;
    }

    @Override
    public PacketChannel getChannel() {
        return PacketHandler.PLAYER_PACKET;
    }
}
