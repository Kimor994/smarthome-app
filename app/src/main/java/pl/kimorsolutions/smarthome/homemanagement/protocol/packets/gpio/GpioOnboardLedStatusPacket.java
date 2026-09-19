package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.gpio;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class GpioOnboardLedStatusPacket  extends Packet {
    public GpioOnboardLedStatusPacket() {
        super(0x51,new float[8]);
    }

}
