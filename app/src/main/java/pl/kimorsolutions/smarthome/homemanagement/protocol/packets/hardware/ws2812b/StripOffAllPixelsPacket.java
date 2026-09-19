package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.ws2812b;


import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class StripOffAllPixelsPacket extends Packet {
    public StripOffAllPixelsPacket() {
        super(0x07,new float[8]);
    }
}
