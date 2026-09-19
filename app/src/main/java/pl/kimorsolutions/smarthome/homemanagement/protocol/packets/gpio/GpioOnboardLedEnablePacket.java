package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.gpio;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class GpioOnboardLedEnablePacket extends Packet {
    public GpioOnboardLedEnablePacket() {
        super(0x10,new float[8]);
    }
}
