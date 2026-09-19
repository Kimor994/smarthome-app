package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.bme280;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class TemperatureStatusPacket extends Packet {
    public TemperatureStatusPacket(){
        super(0x52,new float[8]);
    }
}
