package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.ws2812b;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;
public class StripUpdateSinglePixelPacket extends Packet {
    public StripUpdateSinglePixelPacket(int index, short r, short g, short b, short brightness) {
        super(0x09, new float[]{index,r,g,b,brightness});
    }
}
