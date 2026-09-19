package pl.kimorsolutions.smarthome.homemanagement.protocol.model;

import java.io.IOException;

import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public interface Device {

    public DeviceType getType();
    public String getCustomName();
    public String getIpv4Address();
    public String getMacAddress();
    public default int getPort() {
        return 8440;
    }
    public void connect() throws IOException;
    public void handshake();
    public void disconnect();
    public void writePacket(Packet packet);
    public void readPacket();
    public float[] readBasicDeviceInformation();



}
