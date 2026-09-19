package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.ws2812b;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;
public class StripSetAnimationPacket extends Packet {
    public StripSetAnimationPacket(float[] data) {
        super(0x16,data);
    }
}
