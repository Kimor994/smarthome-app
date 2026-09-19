package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.bme280;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class PressureStatusPacket extends Packet {
    public PressureStatusPacket() {
        super(0x54,new float[8]);
    }
}
