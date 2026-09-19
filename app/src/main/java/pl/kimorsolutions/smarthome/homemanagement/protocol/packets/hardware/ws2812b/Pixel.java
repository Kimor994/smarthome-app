package pl.kimorsolutions.smarthome.homemanagement.protocol.packets.hardware.ws2812b;

public class Pixel{
    private int index;
    private short r,g,b,brightness;
    public Pixel(int index, short r, short g, short b, short brightness){
        this.index=index;
        this.r=r;
        this.g=g;
        this.b=b;
        this.brightness=brightness;
    }

    public int index() {
        return index;
    }

    public short r() {
        return r;
    }

    public short g() {
        return g;
    }

    public short b() {
        return b;
    }

    public short brightness() {
        return brightness;
    }
}
