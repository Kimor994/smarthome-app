package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.gpio;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class GpioOnboardLedDisablePacket extends Packet {
    public GpioOnboardLedDisablePacket() {
        super(0x11,new float[8]);
    }
}
