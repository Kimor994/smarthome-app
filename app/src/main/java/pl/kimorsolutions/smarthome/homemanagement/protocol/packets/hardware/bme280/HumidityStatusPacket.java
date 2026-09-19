package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.bme280;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class HumidityStatusPacket extends Packet {
    public HumidityStatusPacket() {
        super(0x53,new float[8]);
    }
}
