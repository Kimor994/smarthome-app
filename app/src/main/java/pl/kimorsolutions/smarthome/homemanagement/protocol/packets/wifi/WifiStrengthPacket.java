package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.wifi;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class WifiStrengthPacket extends Packet {
    public WifiStrengthPacket() {
        super(0x57, new float[]{});
    }
}
