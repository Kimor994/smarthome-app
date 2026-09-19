package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.ws2812b;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

import java.util.List;

public class StripUpdateAllPixelsPacket extends Packet {
    public StripUpdateAllPixelsPacket(List<Pixel> pixels) {
        super(0x08,new float[]{});
        float[] newStripData = new float[5000];
        int currentByte = 0;
        for(Pixel p : pixels){
            newStripData[currentByte] = p.index();
            newStripData[currentByte+1] = p.r();
            newStripData[currentByte+2] = p.g();
            newStripData[currentByte+3] = p.b();
            newStripData[currentByte+4] = p.brightness();
            currentByte+=5;
        }
        this.content = newStripData;
    }
}
