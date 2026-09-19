package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class MemoryStatusPacket extends Packet {
    public MemoryStatusPacket(){
        super(0x56,new float[]{});
    }
}
